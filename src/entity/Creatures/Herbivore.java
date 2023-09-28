package entity.Creatures;

import Simulation.Coordinates;
import Simulation.Pathfinding;
import entity.Creatures.Creature;

public class Herbivore extends Creature {


    public Herbivore(int speed, int heathPoints) {
        super(speed, heathPoints);
//        super.icon="\uD83E\uDD81";
        this.icon="\uD83D\uDC30";

    }


    public void walkTo(Coordinates coordinates){

    }

    @Override
    public void makeMove() {
       System.out.println(icon+"is moving "+speed);


    }
}
