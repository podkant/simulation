package Simulation;

import entity.Entity;

import java.util.HashMap;

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

    public boolean containsKey(Coordinates coordinates){
        for (java.util.Map.Entry<Coordinates, Entity> entry : map.entrySet()) {
            if (entry.getKey()==null ? coordinates==null :entry.getKey().equals(coordinates)) {
                return true;
            }
        }
        return false;
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
