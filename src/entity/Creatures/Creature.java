package entity.Creatures;

import entity.Entity;

public abstract class Creature extends Entity {
    final int speed;
    final int heathPoints;

    protected Creature(int speed, int heathPoints) {
        this.speed = speed;
        this.heathPoints = heathPoints;
    }

    public abstract void makeMove();

}
