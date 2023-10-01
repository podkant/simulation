package Simulation;

import entity.terrains.Rock;
import entity.terrains.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Pathfinding {

    int maxRow;
    int maxCol;


    private Node[][] node ;
    private Node startNode, currentNode, goalNode;
    private ArrayList<Node> openList= new ArrayList<>();
    private ArrayList<Node> closedList= new ArrayList<>();
    private ArrayList<Coordinates> track = new ArrayList<>();

    boolean GoalReached = false;
    public Pathfinding(int maxRow,int maxCol) {

        this.maxRow = maxRow;
        this.maxCol = maxCol;
        node = new Node[maxCol][maxRow];

        for (int i = 0; i < maxCol; i++) {
            for (int j = 0; j < maxRow; j++) {
                Coordinates coordinates = new Coordinates(i,j);
                node[i][j]=new Node(coordinates);
//                setSolidFromMap(coordinates);
            }
        }
    }
    private void setAllNodesCost (){
        for (int i = 0; i < maxCol; i++) {
            for (int j = 0; j < maxRow; j++) {
                getCost(node[i][j]);
            }
        }
    }

//    private void setSolidFromMap (Coordinates coordinates) {
//        if ( (map.getEntityFromMap(coordinates) instanceof Rock) || (map.getEntityFromMap(coordinates) instanceof Tree)){
//            setSolidNode(coordinates);
////            System.out.println(coordinates.toString());
//        }
//    }
    public void setStartNode(Coordinates coordinates) {
        startNode = node[coordinates.width][coordinates.height];
        startNode.setAsStart();
        currentNode=startNode;
    }
    public void setGoalNode(Coordinates coordinates) {
        node[coordinates.width][coordinates.height].setAsGoal();
        goalNode = node[coordinates.width][coordinates.height];
    }
    public void setSolidNode(Coordinates coordinates){
        node[coordinates.width][coordinates.height].setAsSolid();


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


    public void search(){

        setAllNodesCost();
        while (!GoalReached ) {
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
            if (row+1 < maxRow){
                openNode(node[col][row+1]);
            }
            if (col+1 < maxCol){
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
                backtrackPath();
            }
            if (openList.isEmpty()){
                System.out.println("failed to find path");
                break;
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

    private void backtrackPath() {
        Node current = goalNode;
        StringBuilder stringBuilder=new StringBuilder("Track is: ");
        while  (current!=startNode){
            current=current.parent;
            if (current != startNode) {
                track.add(new Coordinates(current.x,current.y));
                stringBuilder.append(current.x).append("_").append(current.y).append(" ");
            }
        }
        System.out.println(stringBuilder);

    }

    public ArrayList<Coordinates> getTrack() {
        return track;

    }
}
