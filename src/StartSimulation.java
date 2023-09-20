public class StartSimulation {
    public static void main(String[] args) {
        SimulationFrame simulationFrame = new SimulationFrame(302,502,10,10);

       Herbivore herbivore=new Herbivore(10,100);
       herbivore.makeMove();

       Predator predator = new Predator(20,40,50);
       predator.makeMove();
       predator.attack();

    }
}
