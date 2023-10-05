package entity.creatures;

import entity.Entity;
import entity.terrains.NotPassable;
import simulation.Coordinates;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Creature extends Entity {
    public  int speed;
    public  int heathPoints;

    protected Set<Coordinates> obstaclesSet = new HashSet<>();
    protected Coordinates targetCoordinates;
    protected Coordinates startedCoordinates;

    public Creature(int speed, int heathPoints) {
        this.speed = speed;
        this.heathPoints = heathPoints;


    }

    public void setTargetCoordinates(Coordinates targetCoordinates) {
        this.targetCoordinates = targetCoordinates;
    }

    public Coordinates getTargetCoordinates() {
        return targetCoordinates;
    }

    public Coordinates getStartedCoordinates() {
        return startedCoordinates;
    }

    public void setStartedCoordinates(Coordinates startedCoordinates) {
        this.startedCoordinates = startedCoordinates;
    }

    public void makeMove(){

    }
    public <T extends Entity & NotPassable> void setAllObstacles(List<T> entityType) {
        for (T ent : entityType) {
            obstaclesSet.add(ent.getCurrentCoordinates());

        }
    }

}
