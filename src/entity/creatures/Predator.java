package entity.creatures;

import entity.terrains.Grass;
import simulation.Coordinates;
import simulation.Pathfinding;

import java.util.ArrayList;
import java.util.List;

import static simulation.StartSimulation.MAX_COL;
import static simulation.StartSimulation.MAX_ROW;

public class Predator extends Creature {
    public int attackPower;
    private ArrayList<Coordinates> currentTrack;
    public int currentHP=heathPoints;
    public boolean attacking = false;
    public Predator(int speed, int heathPoints,int attackPower) {
        super(speed, heathPoints);
        this.attackPower=attackPower;
        this.icon="\uD83E\uDD81";
    }

    public void findTarget(List<Herbivore> herbivoreList) {
        Pathfinding pathfinding = new Pathfinding(MAX_ROW, MAX_COL);
        pathfinding.setStartNode(getCurrentCoordinates());
        int minDist = Integer.MAX_VALUE;
        for (Herbivore herbivore : herbivoreList
        ) {
            int distance = getCurrentCoordinates().distanceTo(herbivore.getCurrentCoordinates());
            if (distance < minDist) {
                minDist = distance;
                setTargetCoordinates(herbivore.getCurrentCoordinates());
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
            //If no need to move predator attacks
            attack(targetCoordinates);
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
    public void attack (Coordinates coordinates){
        System.out.println(this.icon + " attacking herbivore at " + coordinates);
        if (currentHP<heathPoints) {
            currentHP=heathPoints;
        } else{
            attacking=true;

        }
    }

}
