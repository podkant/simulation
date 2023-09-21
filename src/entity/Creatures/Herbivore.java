package entity.Creatures;

import entity.Creatures.Creature;

public class Herbivore extends Creature {

    public Herbivore(int speed, int heathPoints) {
        super(speed, heathPoints);
//        super.icon="\uD83E\uDD81";
        this.icon="\uD83D\uDC30";

    }

    @Override
    public void makeMove() {
       System.out.println(icon+"is moving "+speed);

    }
}
