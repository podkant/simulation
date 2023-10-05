package simulation;

import entity.Entity;
import simulation.actions.Actions;
import entity.creatures.*;

import entity.terrains.*;

import java.util.ArrayList;
import java.util.List;

public class StartSimulation {

    public static final int MAX_ROW = 10;
    public static final int MAX_COL = 10;

    public static final int PREDATOR_HP =50;
    public static final int PREDATOR_SPEED =5;
    public static final int PREDATOR_ATTACK =60;

    public static final int HERBIVORE_HP =100;
    public static final int HERBIVORE_SPEED =2;

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
            Herbivore herbivore =new Herbivore(HERBIVORE_SPEED, HERBIVORE_HP);
            herbivore.currentHP=HERBIVORE_HP-1;
            herbivoreList.add(herbivore);
        }

        for (int i = 0; i < 1; i++) {
            predatorList.add(new Predator(PREDATOR_SPEED, PREDATOR_HP, PREDATOR_ATTACK));
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

        for (int i = 0; i < 20; i++) {
            System.out.println("Turn: " + (i + 1));
            actions.herbivoreTurn();
            actions.predatorTurn();
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
    }
}



