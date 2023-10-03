package simulation;

public class Node {
    Node parent;

    int x;
    int y;
    int gCost;
    int hCost;
    int fCost;
    boolean start;
    boolean goal;
    boolean solid;
    boolean open;
    boolean checked;


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
    public void setAsSolid(){
        solid=true;
    }

    public void setAsOpen(){
        open=true;
    }
    public void setAsClosed(){
//        if (start==false && goal==false){   }
        checked = true;
    }

}
