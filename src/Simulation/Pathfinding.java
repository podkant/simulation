package Simulation;

import java.util.ArrayList;

public class Pathfinding {

    int maxRow;
    int maxCol;

    Map map;
    Node[][] node = new Node[maxCol][maxRow];
    Node startNode, currentNode, goalNode;
    ArrayList<Node> openList= new ArrayList<>();
    ArrayList<Node> closedList= new ArrayList<>();

    public Pathfinding(Map map) {
        this.map = map;
        this.maxRow=map.getHSize();
        this.maxCol= map.getWSize();

    }
    public void setStartNode(Coordinates coordinates) {
        startNode = node[coordinates.width][coordinates.height];
        startNode.setAsStart();
    }
    private void setGoalNode(Coordinates coordinates) {
        goalNode = node[coordinates.width][coordinates.height];
        goalNode.setAsGoal();
    }
    private void getCost(Node node) {
        //G cost
        int xDistance = Math.abs(node.x- startNode.x);
        int yDistance = Math.abs(node.y- startNode.y);
        node.gCost=xDistance+yDistance;
        //H cost
        xDistance = Math.abs(node.x- goalNode.x);
        yDistance = Math.abs(node.y- goalNode.y);
        node.hCost=xDistance+yDistance;
        //F cost
        node.fCost= node.gCost+node.hCost;
    }
    private void setAllNodesCost (){
        for (int i = 0; i < maxCol; i++) {
            for (int j = 0; j < maxRow; j++) {
                getCost(node[i][j]);
            }
        }

    }

}
