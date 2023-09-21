package entity.Creatures;

import entity.Creatures.Creature;

public class Predator extends Creature {
    public int attackPower;
    protected Predator(int speed, int heathPoints,int attackPower) {
        super(speed, heathPoints);
        this.attackPower=attackPower;
    }

    @Override
    public void makeMove() {
        System.out.println("entity.Creatures.Predator is moving "+speed);
    }
    public void attack(){
        System.out.println("entity.Creatures.Predator is attacking power"+attackPower);
    }
}
