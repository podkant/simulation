import javax.swing.*;
import java.awt.*;

public class SimulationMap extends JFrame {
    private int mapWidth;
    private int mapHeight;



    SimulationMap(int mapWidth, int mapHeight) {

        this.mapHeight = mapHeight;
        this.mapWidth = mapWidth;
//        Toolkit toolkit = Toolkit.getDefaultToolkit();
//        Dimension dimension = toolkit.getScreenSize();
//        this.setBounds(dimension.width/2- (mapWidth/2),dimension.height/2- (mapHeight/2), mapWidth, mapHeight);

//        this.setSize(mapWidth,mapHeight);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void changeMapStatus(int width, int height){
        SimulationGraphics graphics = new SimulationGraphics(mapWidth, mapHeight,width,height);
        this.add(graphics);

    }

}
