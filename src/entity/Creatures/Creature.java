package entity.Creatures;

import entity.Entity;

public abstract class Creature extends Entity {
    public  int speed;
    public  int heathPoints;



    public Creature(int speed, int heathPoints) {
        this.speed = speed;
        this.heathPoints = heathPoints;


    }

    public abstract void makeMove();

}
