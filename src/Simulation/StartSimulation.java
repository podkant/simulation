package Simulation;

import Simulation.Actions.Actions;
import entity.Creatures.Herbivore;
import entity.Creatures.Predator;
import entity.terrains.Grass;
import entity.terrains.Rock;
import entity.terrains.Tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StartSimulation {



    public static void main(String[] args) {
//        SimulationFrame simulationFrame = new SimulationFrame(302,502,10,10);
        Map thisMap = new Map();
        thisMap.setHSize(10);
        thisMap.setWSize(10);

        Actions actions = new Actions(thisMap);

        List<Herbivore> herbivoreList =new ArrayList<>();
        List<Predator> predatorList =new ArrayList<>();
        List<Tree> treeList =new ArrayList<>();
        List<Rock> rockList =new ArrayList<>();
        List<Grass> grassList =new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            herbivoreList.add(new Herbivore(10,100));
        }

        for (int i = 0; i < 1; i++) {
            predatorList.add(new Predator(15, 50,25));
        }
        for (int i = 0; i < 5; i++) {
            treeList.add(new Tree());
        }
        for (int i = 0; i < 5; i++) {
            rockList.add(new Rock());
        }
        for (int i = 0; i < 20; i++) {
            grassList.add(new Grass());
        }


        actions.initializeEntity(herbivoreList);
        actions.initializeEntity(predatorList);
        actions.initializeEntity(grassList);
        actions.initializeEntity(treeList);
        actions.initializeEntity(rockList);
        actions.fillEmptyCellsWithGround();
        Render render =new Render(thisMap);

        System.out.println( render.renderMap());
        Pathfinding pathfinding = new Pathfinding(thisMap);
        pathfinding.setStartNode(new Coordinates(0,2));
        pathfinding.setGoalNode(new Coordinates(8,7));
        pathfinding.setSolidNode(new Coordinates(8,2));
        pathfinding.setSolidNode(new Coordinates(8,3));
        pathfinding.setSolidNode(new Coordinates(8,4));
        pathfinding.setSolidNode(new Coordinates(8,5));
        pathfinding.setSolidNode(new Coordinates(8,6));
        pathfinding.setSolidNode(new Coordinates(7,6));
        pathfinding.setSolidNode(new Coordinates(7,7));
        pathfinding.setSolidNode(new Coordinates(6,7));
        pathfinding.setSolidNode(new Coordinates(6,8));
        pathfinding.search();


//Iteration throw queue
//        Iterator<Coordinates> iterator = pathfinding.getTrack().iterator();
//        while(iterator.hasNext()){
//            Coordinates iter = iterator.next();
//            int trackWidth = iter.width;
//            int trackHeight = iter.height;
//        }

    }
}
