package entity;

import Simulation.Coordinates;

public class Entity {
    public String icon=" ";
    private Coordinates currentCoordinates;
    protected Entity() {
    }
    public void setCurrentCoordinates(Coordinates currentCoordinates) {
        this.currentCoordinates = currentCoordinates;
    }

    public Coordinates getCurrentCoordinates() {
        return currentCoordinates;
    }


}
