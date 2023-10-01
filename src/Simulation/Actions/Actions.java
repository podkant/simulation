package Simulation.Actions;

import Simulation.Coordinates;
import Simulation.Map;
import entity.*;
import entity.terrains.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Actions {
    Map map;


    public Actions(Map map) {
        this.map = map;
    }

    public <T extends Entity> List<T>  initializeEntity(List<T> entityType) {
        int filledCellsOnMap = 0;
        List<T> modifiedList=new ArrayList<>();
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

    public void fillEmptyCellsWithGround (){
        for (int i = 0; i < map.getWSize(); i++) {
            for (int j = 0; j < map.getHSize(); j++) {
                Coordinates coordinates = new Coordinates(i,j);
                if (!map.containsKey(coordinates)){
                    Ground ground =new Ground();
                    map.addEntityToMap(coordinates,ground);
                    ground.setCurrentCoordinates(coordinates);

                }
            }
        }
    }

    public void simulateTurn(int turnCount){

    }

}
