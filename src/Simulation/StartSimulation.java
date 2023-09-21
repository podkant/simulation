package Simulation;

import entity.Creatures.Creature;
import entity.Creatures.Herbivore;
import entity.Creatures.Predator;
import entity.Entity;
import entity.terrains.Rock;
import entity.terrains.Tree;
import graphics.SimulationFrame;

public class StartSimulation {



    public static void main(String[] args) {
//        SimulationFrame simulationFrame = new SimulationFrame(302,502,10,10);
        Map thisMap = new Map();
        thisMap.setHSize(60);
        thisMap.setWSize(50);
        Creature creature =new Creature(5,10) {
            @Override
            public void makeMove() {
                System.out.println("move");
            }
        };

        Herbivore herbivore=new Herbivore(10,100);
        Predator predator = new Predator(15, 50,25);
        Tree tree = new Tree();
        Rock rock =new Rock();


        System.out.println(creature.icon);
        System.out.println(herbivore.icon);
        System.out.println(predator.icon);
        System.out.println(tree.icon);
        System.out.println(rock.icon);

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
