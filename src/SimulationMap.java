import javax.swing.*;
import java.awt.*;

public class SimulationMap extends JFrame {
    private int mapWidth;
    private int mapHeight;
    private int cellH;
    private int cellW;


    SimulationGraphics panel;

    SimulationMap(int mapWidth, int mapHeight,int cellW, int cellH) {
        this.mapHeight = mapHeight;
        this.mapWidth = mapWidth;
        this.cellH=cellH;
        this.cellW=cellW;
        //this.setSize(mapWidth,mapHeight+200);

        panel =new SimulationGraphics(mapWidth,mapHeight,cellW,cellH);
        this.add(panel);
        this.pack();

//        Toolkit toolkit = Toolkit.getDefaultToolkit();
//        Dimension dimension = toolkit.getScreenSize();
//        this.setBounds(dimension.width/2- (mapWidth/2),dimension.height/2- (mapHeight/2), mapWidth, mapHeight);

//        this.setSize(mapWidth,mapHeight);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

//    public void changeMapStatus(int width, int height){
////        SimulationGraphics graphics = new SimulationGraphics(mapWidth, mapHeight,width,height);
////        this.add(graphics);
//
//    }

}
