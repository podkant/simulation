package Simulation;

import Simulation.Actions.Actions;
import entity.Creatures.Herbivore;
import entity.Creatures.Predator;
import entity.terrains.*;
import java.util.ArrayList;
import java.util.List;

public class StartSimulation {

    public static final int MAX_ROW=10;
    public static final int MAX_COL=10;



    public static void main(String[] args) {
//        SimulationFrame simulationFrame = new SimulationFrame(302,502,10,10);
        Map thisMap = new Map();
        thisMap.setHSize(MAX_ROW);
        thisMap.setWSize(MAX_COL);

        Actions actions = new Actions(thisMap);

        List<Herbivore> herbivoreList =new ArrayList<>();
        List<Predator> predatorList =new ArrayList<>();
        List<Tree> treeList =new ArrayList<>();
        List<Rock> rockList =new ArrayList<>();
        List<Grass> grassList =new ArrayList<>();


        for (int i = 0; i < 1; i++) {
            herbivoreList.add(new Herbivore(2,100));
        }

        for (int i = 0; i < 1; i++) {
            predatorList.add(new Predator(4, 50,25));
        }
        for (int i = 0; i < 5; i++) {
            treeList.add(new Tree());
        }
        for (int i = 0; i < 10; i++) {
            rockList.add(new Rock());
        }
        for (int i = 0; i < 20; i++) {
            grassList.add(new Grass());
        }


        herbivoreList=actions.initializeEntity(herbivoreList);
        predatorList=actions.initializeEntity(predatorList);
        grassList=actions.initializeEntity(grassList);
        treeList=actions.initializeEntity(treeList);
        rockList=actions.initializeEntity(rockList);
        actions.fillEmptyCellsWithGround();
        Render render =new Render(thisMap);

        System.out.println( render.renderMap());


        for (Herbivore herbivore: herbivoreList
             ) {
            herbivore.setAllObstacles(treeList);
            herbivore.setAllObstacles(rockList);
            herbivore.findTarget(grassList);
            herbivore.makeMove();
            if (herbivore.reproduction) {
                Herbivore childHerbivore = new Herbivore(2,100);
                childHerbivore.setCurrentCoordinates(herbivore.getTargetCoordinates());
                thisMap.removeEntityFromMap(herbivore.getTargetCoordinates());
                thisMap.addEntityToMap(childHerbivore.getCurrentCoordinates(),childHerbivore);
            }
        }

//        System.out.println(thisMap.getMap());

    }
}
