package graphics;

import javax.swing.*;

public class SimulationFrame extends JFrame {
    private int mapWidth;
    private int mapHeight;
    private int cellH;
    private int cellW;

    SimulationPanel panel;

    public SimulationFrame(int mapWidth, int mapHeight, int cellW, int cellH) {
        this.mapHeight = mapHeight;
        this.mapWidth = mapWidth;
        this.cellH=cellH;
        this.cellW=cellW;
        this.setTitle("Simulation");
        this.setResizable(false);

        panel =new SimulationPanel(mapWidth,mapHeight,cellW,cellH);
        this.add(panel);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }



}
