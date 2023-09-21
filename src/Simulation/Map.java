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

//    public  getEntry(Coordinates coordinates) {
//
//        for ( : map.entrySet()){
//            return map.get(coordinates);
//        }
//
//    }

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
