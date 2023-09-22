package Simulation;

import Simulation.Actions.Actions;
import entity.Creatures.Herbivore;
import entity.Creatures.Predator;
import entity.terrains.Grass;
import entity.terrains.Rock;
import entity.terrains.Tree;

import java.util.ArrayList;
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

        Render render =new Render(thisMap);

        System.out.println( render.renderMap());
//        System.out.println(herbivore.icon);
//        System.out.println(predator.icon);
//        System.out.println(tree.icon);
//        System.out.println(rock.icon);
//        herbivore.makeMove();



//        if (thisMap.map.get(null) ==null){
//            System.out.println("is null");
//        }

//       entity.Creatures.Herbivore herbivore=new entity.Creatures.Herbivore(10,100);
//       herbivore.makeMove();
//
//       entity.Creatures.Predator predator = new entity.Creatures.Predator(20,40,50);
//       predator.makeMove();
//       predator.attack();

    }
}
