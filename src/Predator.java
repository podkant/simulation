public class Predator extends Creature{
    public int attackPower;
    protected Predator(int speed, int heathPoints,int attackPower) {
        super(speed, heathPoints);
        this.attackPower=attackPower;
    }

    @Override
    public void makeMove() {
        System.out.println("Predator is moving "+speed);
    }
    public void attack(){
        System.out.println("Predator is attacking power"+attackPower);
    }
}
