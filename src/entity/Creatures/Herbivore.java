package entity.Creatures;

import Simulation.Coordinates;
import Simulation.Pathfinding;
import entity.Creatures.Creature;
import entity.Entity;
import entity.terrains.Grass;
import entity.terrains.Rock;
import entity.terrains.Tree;

import java.util.*;

import static Simulation.StartSimulation.MAX_COL;
import static Simulation.StartSimulation.MAX_ROW;

public class Herbivore extends Creature {

    private Coordinates targetCoordinates;
    private Set<Coordinates> obstaclesSet = new HashSet<>();
    private Queue<Coordinates> currentTrack;

    public Herbivore(int speed, int heathPoints) {
        super(speed, heathPoints);
        this.icon = "\uD83D\uDC30";

    }

    public void setTargetCoordinates(Coordinates targetCoordinates) {
        this.targetCoordinates = targetCoordinates;
    }

    public  <T extends Entity> void setAllObstacles(List<T> entityType) {
        if ((entityType instanceof Rock) || (entityType instanceof Tree)) {
            for (T ent : entityType) {
                obstaclesSet.add(ent.getCurrentCoordinates());
            }
        }
    }

    public void findTarget(List<Grass> grassList) {
        Pathfinding pathfinding = new Pathfinding(MAX_ROW, MAX_COL);
        pathfinding.setStartNode(getCurrentCoordinates());
        int minDist = Integer.MAX_VALUE;
        for (Grass grass : grassList
        ) {
            int distance = getCurrentCoordinates().distanceTo(grass.getCurrentCoordinates());
            if (distance < minDist) {
                minDist = distance;
                setTargetCoordinates(grass.getCurrentCoordinates());
            }
        }
        pathfinding.setGoalNode(targetCoordinates);
        for (Coordinates coordinates : obstaclesSet
        ) {
            pathfinding.setSolidNode(coordinates);
        }
        pathfinding.search();
        currentTrack = pathfinding.getTrack();
    }

    @Override
    public void makeMove() {
        System.out.println(icon + "is moving " + speed);
        Coordinates coordToCheck = getCurrentCoordinates();
        System.out.println(getCurrentCoordinates().toString());
        for (int i = 0; i < speed; i++) {
            try {
                coordToCheck = currentTrack.remove();


            } catch (NoSuchElementException exception) {
                setCurrentCoordinates(coordToCheck);
                break;

            }
        }
        setCurrentCoordinates(coordToCheck);
        System.out.println(getCurrentCoordinates().toString());

    }
}
