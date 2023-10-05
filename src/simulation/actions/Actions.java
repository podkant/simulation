package simulation.actions;

import simulation.Coordinates;
import simulation.Map;
import entity.*;
import entity.creatures.*;
import entity.terrains.*;
import simulation.StartSimulation;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Actions {
    Map map;



    public Actions(Map map) {
        this.map = map;
    }

    public <T extends Entity> List<T> initializeEntity(List<T> entityType) {
        int filledCellsOnMap = 0;
        List<T> modifiedList = new ArrayList<>();
        for (T ent : entityType
        ) {
            Random random = new Random();
            int x = random.nextInt(map.getWSize());
            int y = random.nextInt(map.getHSize());
            Coordinates coordinates = new Coordinates(x, y);
            if (!map.isCellFilled(coordinates)) {
                map.addEntityToMap(coordinates, ent);
                ent.setCurrentCoordinates(coordinates);
                modifiedList.add(ent);
                filledCellsOnMap++;
            }
            if (filledCellsOnMap == map.getHSize() * map.getWSize()) {

                break;
            }
        }
        return modifiedList;
    }

    public void fillEmptyCellsWithGround() {
        for (int i = 0; i < map.getWSize(); i++) {
            for (int j = 0; j < map.getHSize(); j++) {
                Coordinates coordinates = new Coordinates(i, j);
                if (!map.containsKey(coordinates)) {
                    Ground ground = new Ground();
                    map.addEntityToMap(coordinates, ground);
                    ground.setCurrentCoordinates(coordinates);

                }
            }
        }
    }

    public  <T extends Creature> void creatureMoveOnMap(T creature) {

        if (!creature.getStartedCoordinates().equals(creature.getCurrentCoordinates())) {
            if (map.getEntityFromMap(creature.getCurrentCoordinates()) instanceof Ground) {
                map.swapMapCell(creature.getStartedCoordinates(), creature.getCurrentCoordinates());
            } else {
                creature.setCurrentCoordinates(creature.getStartedCoordinates());
            }
        }
    }

    public void herbivoreTurn() {
        for (Herbivore herbivore : StartSimulation.herbivoreList
        ) {
            herbivore.setAllObstacles(StartSimulation.treeList);
            herbivore.setAllObstacles(StartSimulation.rockList);
            herbivore.findTarget(StartSimulation.grassList);
            herbivore.makeMove();
            creatureMoveOnMap(herbivore);
            if (herbivore.reproduction) {
                Herbivore childHerbivore = new Herbivore(StartSimulation.HERBIVORE_SPEED, StartSimulation.HERBIVORE_HP);
                childHerbivore.setCurrentCoordinates(herbivore.getTargetCoordinates());
                map.removeEntityFromMap(herbivore.getTargetCoordinates());
                map.addEntityToMap(childHerbivore.getCurrentCoordinates(), childHerbivore);
                herbivore.reproduction = false;
            }
        }
    }
    public void predatorTurn() {
        for (Predator predator : StartSimulation.predatorList
        ) {
            predator.setAllObstacles(StartSimulation.treeList);
            predator.setAllObstacles(StartSimulation.rockList);
            predator.findTarget(StartSimulation.herbivoreList);
            predator.makeMove();
            creatureMoveOnMap(predator);
            if (predator.attacking) {
                if (map.getEntityFromMap(predator.getTargetCoordinates()) instanceof Herbivore attacked){
                    attacked.currentHP=attacked.currentHP-predator.attackPower;
                    attacked.icon="\uD83D\uDC07";
                    if (attacked.currentHP <= 0) {
                        Predator childPredator = new Predator(StartSimulation.PREDATOR_SPEED, StartSimulation.PREDATOR_HP,StartSimulation.PREDATOR_ATTACK);
                        childPredator.setCurrentCoordinates(predator.getTargetCoordinates());
                        childPredator.currentHP=StartSimulation.PREDATOR_HP-1;
                        map.removeEntityFromMap(predator.getTargetCoordinates());
                        map.addEntityToMap(childPredator.getCurrentCoordinates(), childPredator);
                        System.out.println("New "+childPredator.icon + " will burn at " + childPredator.getCurrentCoordinates());
                    }
                }
                predator.attacking = false;
            }
        }
    }


//    public <T extends Creature > List<T>  moveCreatures(List<T> creatureList) {
//        List<T> modifiedList=new ArrayList<>();
//        for (T creature: creatureList
//        ) {
//            creature.setAllObstacles(treeList);
//            creature.setAllObstacles(rockList);
//            creature.findTarget(grassList);
//            herbivore.makeMove();
//            actions.herbivoreMove(herbivore);
//            if (herbivore.reproduction) {
//                Herbivore childHerbivore = new Herbivore(2,100);
//                childHerbivore.setCurrentCoordinates(herbivore.getTargetCoordinates());
//                thisMap.removeEntityFromMap(herbivore.getTargetCoordinates());
//                thisMap.addEntityToMap(childHerbivore.getCurrentCoordinates(),childHerbivore);
//            }
//        }
//        System.out.println( render.displayMap());
//        return modifiedList;
//    }

    public void simulateTurn(int turnCount) {

    }

}
