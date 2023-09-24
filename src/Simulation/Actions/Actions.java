package Simulation.Actions;

import Simulation.Coordinates;
import Simulation.Map;
import entity.Entity;
import entity.terrains.Ground;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Actions {
    Map map;
    int filledCellsOnMap = 0;

    public Actions(Map map) {
        this.map = map;
    }

    //    public <T extends Entity> void initializeEntity (T element , int count){
//        int i =0;
//        while ( i < count) {
//            Random random = new Random();
//            int x = random.nextInt(map.getWSize());
//            int y = random.nextInt(map.getHSize());
//            Coordinates coordinates = new Coordinates(x,y);
//            if (!map.isCellFilled(coordinates)){
//                map.addEntityToMap(coordinates,element);
//                i++;
//                filledCellsOnMap++;
//            }
//            if (filledCellsOnMap==map.getHSize()*map.getWSize()) {
//                break;
//            }
//
//        }
//    }
    public <T extends Entity> void initializeEntity(List<T> entityType) {
        int i = 0;
        for (T ent : entityType
        ) {
            Random random = new Random();
            int x = random.nextInt(map.getWSize());
            int y = random.nextInt(map.getHSize());
            Coordinates coordinates = new Coordinates(x, y);
            if (!map.isCellFilled(coordinates)) {
                map.addEntityToMap(coordinates, ent);
                i++;
                filledCellsOnMap++;
            }
            if (filledCellsOnMap == map.getHSize() * map.getWSize()) {
                break;
            }
        }

    }

    public void fillEmptyCellsWithGround (){
        for (int i = 0; i < map.getWSize(); i++) {
            for (int j = 0; j < map.getHSize(); j++) {
                Coordinates coordinates = new Coordinates(i,j);
                if (!map.containsKey(coordinates)){
                    map.addEntityToMap(coordinates,new Ground());
                }
            }

        }
    }

}
