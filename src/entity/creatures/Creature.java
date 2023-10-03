package entity.creatures;

import entity.Entity;

public class Creature extends Entity {
    public  int speed;
    public  int heathPoints;



    public Creature(int speed, int heathPoints) {
        this.speed = speed;
        this.heathPoints = heathPoints;


    }

    public void makeMove(){

    }

}
