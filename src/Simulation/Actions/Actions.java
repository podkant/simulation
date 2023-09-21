package Simulation.Actions;
import Simulation.Coordinates;
import Simulation.Map;
import entity.Entity;

import java.util.Random;

 public class Actions {
    Map map ;

    public Actions(Map map) {
        this.map = map;
    }

    public <T extends Entity> void initializeEntity (T element , int count){
        int i =0;
        while ( i < count) {
            Random random = new Random();
            int x = random.nextInt(map.getWSize());
            int y = random.nextInt(map.getHSize());
            Coordinates coordinates = new Coordinates(x,y);
            if (!map.isCellFilled(coordinates)){
                map.addEntityToMap(coordinates,element);
                i++;
            }

        }
    }


}
