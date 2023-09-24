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

    boolean GoalReached = false;
    public Pathfinding(Map map) {
        this.map = map;
        this.maxRow=map.getHSize();
        this.maxCol= map.getWSize();
        setAllNodesCost();


    }
    public void setStartNode(Coordinates coordinates) {
        startNode = node[coordinates.width][coordinates.height];
        startNode.setAsStart();
    }
    public void setGoalNode(Coordinates coordinates) {
        node[coordinates.width][coordinates.height].setAsGoal();
        goalNode = node[coordinates.width][coordinates.height];
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

    public void search(){
        while (!GoalReached && !openList.isEmpty()) {
            int col = currentNode.x;
            int row = currentNode.y;
            currentNode.setAsClosed();
            closedList.add(currentNode);
            openList.remove(currentNode);
            if (row>0){
                openNode(node[col][row-1]);
            }
            if (col>0){
                openNode(node[col-1][row]);
            }
            if (row<maxRow){
                openNode(node[col][row+1]);
            }
            if (col<maxCol){
                openNode(node[col+1][row]);
            }

            int bestNodeIndex = 0;
            int bestNodeFCost =999;
            for (int i = 0; i < openList.size(); i++) {
                if(openList.get(i).fCost<bestNodeFCost){
                    bestNodeIndex=i;
                    bestNodeFCost=openList.get(i).fCost;
                }
                else {
                    if (openList.get(i).fCost==bestNodeFCost) {
                        if(openList.get(i).gCost< openList.get(bestNodeIndex).gCost){
                            bestNodeIndex=i;
                        }
                    }
                }

            }
            currentNode=openList.get(bestNodeIndex);
            if (currentNode==goalNode){
                GoalReached=true;
            }
        }

    }
    private void openNode (Node node){
        if (!node.open && !node.checked && !node.solid){
            node.setAsOpen();
            node.parent=currentNode;
            openList.add(node);
        }
    }

}
