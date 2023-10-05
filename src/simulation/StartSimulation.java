package simulation;

import entity.Entity;
import simulation.actions.Actions;
import entity.creatures.Herbivore;
import entity.creatures.Predator;
import entity.terrains.*;

import java.util.ArrayList;
import java.util.List;

public class StartSimulation {

    public static final int MAX_ROW = 10;
    public static final int MAX_COL = 10;

    public static List<Herbivore> herbivoreList = new ArrayList<>();
    public static List<Predator> predatorList = new ArrayList<>();
    public static List<Tree> treeList = new ArrayList<>();
    public static List<Rock> rockList = new ArrayList<>();
    public static List<Grass> grassList = new ArrayList<>();


    public static void main(String[] args) {
//        SimulationFrame simulationFrame = new SimulationFrame(302,502,10,10);
        Map thisMap = new Map();
        thisMap.setHSize(MAX_ROW);
        thisMap.setWSize(MAX_COL);

        Actions actions = new Actions(thisMap);


        for (int i = 0; i < 3; i++) {
            herbivoreList.add(new Herbivore(2, 100));
        }

        for (int i = 0; i < 1; i++) {
            predatorList.add(new Predator(4, 50, 25));
        }
        for (int i = 0; i < 5; i++) {
            treeList.add(new Tree());
        }
        for (int i = 0; i < 10; i++) {
            rockList.add(new Rock());
        }
        for (int i = 0; i < 15; i++) {
            grassList.add(new Grass());
        }


        herbivoreList = actions.initializeEntity(herbivoreList);
        predatorList = actions.initializeEntity(predatorList);
        grassList = actions.initializeEntity(grassList);
        treeList = actions.initializeEntity(treeList);
        rockList = actions.initializeEntity(rockList);
        actions.fillEmptyCellsWithGround();
        Render render = new Render(thisMap);

        System.out.println(render.renderMap());

        for (int i = 0; i < 5; i++) {
            System.out.println("Turn: " + (i + 1));
            actions.herbivoreCheck();
            herbivoreList = new ArrayList<>();
            predatorList = new ArrayList<>();
            grassList = new ArrayList<>();
            treeList = new ArrayList<>();
            rockList = new ArrayList<>();
            for (java.util.Map.Entry<Coordinates, Entity> entry : thisMap.getMap().entrySet()
            ) {
                Entity value = entry.getValue();
                if (value instanceof Herbivore herbivore) {
                    herbivoreList.add(herbivore);
                }
                if (value instanceof Predator predator) {
                    predatorList.add(predator);
                }
                if (value instanceof Grass grass) {
                    grassList.add(grass);
                }
                if (value instanceof Rock rock) {
                    rockList.add(rock);
                }
                if (value instanceof Tree tree) {
                    treeList.add(tree);
                }
            }
            System.out.println(render.displayMap());
        }

//        for (int i = 0; i < 5; i++) {
//            for (Herbivore herbivore: herbivoreList
//            ) {
//                herbivore.setAllObstacles(treeList);
//                herbivore.setAllObstacles(rockList);
//                herbivore.findTarget(grassList);
//                herbivore.makeMove();
//                actions.herbivoreMove(herbivore);
//                if (herbivore.reproduction) {
//                    Herbivore childHerbivore = new Herbivore(2,100);
//                    childHerbivore.setCurrentCoordinates(herbivore.getTargetCoordinates());
//                    thisMap.removeEntityFromMap(herbivore.getTargetCoordinates());
//                    thisMap.addEntityToMap(childHerbivore.getCurrentCoordinates(),childHerbivore);
//                }
//            }
//            System.out.println( render.displayMap());
//        }

//        System.out.println(thisMap.getMap());

    }


}



