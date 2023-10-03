package simulation;

import entity.Entity;
import entity.creatures.Herbivore;
import entity.creatures.Predator;
import entity.terrains.Grass;
import entity.terrains.Ground;
import entity.terrains.Rock;
import entity.terrains.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Map {
    private int hSize;
    private int wSize;



    private HashMap <Coordinates, Entity> map = new HashMap<>();


    public boolean isCellFilled(Coordinates coordinates) {
        return map.get(coordinates) != null;
    }
    public void addEntityToMap(Coordinates coordinates,Entity entity){
        map.put(coordinates,entity);
    }
    public void removeEntityFromMap(Coordinates coordinates){
        map.remove(coordinates);
    }
    public Entity getEntityFromMap(Coordinates coordinates){
        if (map.containsKey(coordinates)){
            return map.get(coordinates);
        }
        else {
            System.out.println("No such coordinates at map");
            throw new RuntimeException() ;
        }
    }

    public boolean containsKey(Coordinates coordinates){
        for (java.util.Map.Entry<Coordinates, Entity> entry : map.entrySet()) {
            if (entry.getKey()==null ? coordinates==null :entry.getKey().equals(coordinates)) {
                return true;
            }
        }
        return false;
    }
    public void swapMapCell(Coordinates oldCoordinates, Coordinates newCoordinates) {
        Entity oldEnt = getEntityFromMap(oldCoordinates);
        Entity newEnt = getEntityFromMap(newCoordinates);
        oldEnt.setCurrentCoordinates(newCoordinates);
        newEnt.setCurrentCoordinates(oldCoordinates);
        removeEntityFromMap(oldCoordinates);
        removeEntityFromMap(newCoordinates);
        addEntityToMap(oldCoordinates,newEnt);
        addEntityToMap(newCoordinates,oldEnt);
    }
    public HashMap<Coordinates, Entity> getMap(){
        return map;
    }
    public int getHSize() {
        return hSize;
    }

    public void setHSize(int hSize) {
        this.hSize = hSize;
    }

    public int getWSize() {
        return wSize;
    }

    public void setWSize(int wSize) {
        this.wSize = wSize;
    }
}
