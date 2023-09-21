package entity.Creatures;

import entity.Creatures.Creature;

public class Predator extends Creature {
    public int attackPower;
    public Predator(int speed, int heathPoints,int attackPower) {
        super(speed, heathPoints);
        this.attackPower=attackPower;
        this.icon="\uD83E\uDD81";
    }

    @Override
    public void makeMove() {
        System.out.println(icon+" is moving "+speed);
        System.out.println(icon+" is attacking power"+attackPower);
    }

}
