package Simulation;

import Simulation.Actions.Actions;
import entity.Creatures.Herbivore;
import entity.Creatures.Predator;
import entity.terrains.Rock;
import entity.terrains.Tree;

public class StartSimulation {



    public static void main(String[] args) {
//        SimulationFrame simulationFrame = new SimulationFrame(302,502,10,10);
        Map thisMap = new Map();
        thisMap.setHSize(10);
        thisMap.setWSize(10);

        Actions actions = new Actions(thisMap);

        Herbivore herbivore=new Herbivore(10,100);
        Predator predator = new Predator(15, 50,25);
        Tree tree = new Tree();
        Rock rock =new Rock();

        actions.initializeEntity(rock,5);
        actions.initializeEntity(tree,5);
        actions.initializeEntity(herbivore,2);
        actions.initializeEntity(predator,1);

        Render render =new Render(thisMap);
        Tree tree1 = new Tree();
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
