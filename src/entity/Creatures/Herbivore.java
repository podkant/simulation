package entity.Creatures;

import entity.Creatures.Creature;

public class Herbivore extends Creature {


    public Herbivore(int speed, int heathPoints) {
        super(speed, heathPoints);
        this.icon="\uD83D\uDC30";

    }

    @Override
    public void makeMove() {
       System.out.println("entity.Creatures.Herbivore is moving ");

    }
}
