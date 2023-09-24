package Simulation;

public class Node {
    Node parent;
    int x;
    int y;
    int gCost;
    int hCost;
    int fCost;
    boolean start;
    boolean goal;

    public Node(Coordinates coordinates) {
        this.x = coordinates.width;
        this.y = coordinates.height;
    }

    public void setAsStart(){
        start=true;
    }
    public void setAsGoal(){
        goal=true;
    }

}
