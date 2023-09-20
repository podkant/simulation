public class Herbivore extends Creature{

    protected Herbivore(int speed, int heathPoints) {
        super(speed, heathPoints);
    }


    @Override
    public void makeMove() {
        System.out.println("Herbivore is moving "+speed);

    }
}
