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

    public <T extends Entity> void setAllObstacles(List<T> entityType) {
        for (T ent : entityType) {
            if ((ent instanceof Rock) || (ent instanceof Tree)) {
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
                System.out.println(minDist);
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
        Coordinates coordToCheck = getCurrentCoordinates();
        System.out.println(getCurrentCoordinates().toString());
        boolean endOfTurn = false;
        int movedCells = 0;
        if (currentTrack.isEmpty()) {
            //If no need to move we eat
            endOfTurn = true;
            System.out.println(this.icon + " eating grass at " + targetCoordinates);
        } else {
            while (!endOfTurn) {
                //moving up to speed or up to target
                try {
                    coordToCheck = currentTrack.remove();
                    System.out.println(icon + "is moving to" + coordToCheck.toString());
                    movedCells++;
                } catch (NoSuchElementException exception) {
                    setCurrentCoordinates(coordToCheck);
                    System.out.println(icon + "is finished at " + getCurrentCoordinates().toString());
                    endOfTurn = true;
                }
                if (movedCells == speed) {
                    endOfTurn = true;
                }
            }
            setCurrentCoordinates(coordToCheck);
//            System.out.println(icon + "is moving to" + getCurrentCoordinates().toString());
        }

//        Iterator<Coordinates> iterator = currentTrack.iterator();
//        if (iterator.hasNext()) {
//            for (int i = 0; i < speed; i++) {
//                try {
//                    coordToCheck = currentTrack.remove();
//                } catch (NoSuchElementException exception) {
//                    setCurrentCoordinates(coordToCheck);
//                    break;
//                }
//            }
//            iterator.next();

    }
}
