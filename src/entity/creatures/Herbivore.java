package entity.creatures;
import simulation.Coordinates;
import simulation.Pathfinding;
import entity.Entity;
import entity.terrains.*;


import java.util.*;

import static simulation.StartSimulation.MAX_COL;
import static simulation.StartSimulation.MAX_ROW;

public class Herbivore extends Creature  {


    private ArrayList<Coordinates> currentTrack;
    public int currentHP=heathPoints;
    public boolean reproduction = false;


    public Herbivore(int speed, int heathPoints) {
        super(speed, heathPoints);
        this.icon = "\uD83D\uDC30";

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
//                System.out.println(minDist);
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
//        System.out.println(getCurrentCoordinates().toString());
        boolean endOfTurn = false;
        int movedCells = 0;
        setStartedCoordinates(getCurrentCoordinates());
        if (currentTrack.isEmpty()) {
            //If no need to move herbivore eats
            eating(targetCoordinates);
        } else {
            int i = currentTrack.size()-1;
            while (!endOfTurn) {
                //moving up to speed or up to target
                coordToCheck = currentTrack.get(i);
                currentTrack.remove(i);
                i--;
//                System.out.println(icon + "is moving to" + coordToCheck.toString());
                movedCells++;
                if (currentTrack.isEmpty()) {
                    setCurrentCoordinates(coordToCheck);
//                    System.out.println(icon + "is finished at " + getCurrentCoordinates().toString());
                    endOfTurn = true;
                }
                if (movedCells == speed) {
                    endOfTurn = true;
                }
            }
            setCurrentCoordinates(coordToCheck);
        }

    }

    public void eating (Coordinates coordinates){
        System.out.println(this.icon + " eating grass at " + coordinates);
        if (currentHP<heathPoints) {
            currentHP=currentHP+10;
            if (currentHP>=heathPoints) {
                this.icon="\uD83D\uDC30";
                currentHP=heathPoints;
            }
        } else{
            reproduction=true;
            System.out.println("New "+this.icon + " will burn at " + coordinates);
        }
    }
}
