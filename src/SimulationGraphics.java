import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.Random;

public class SimulationGraphics extends JPanel {

    private int width;
    private int height;
    private int cellH;
    private int cellW;


    SimulationGraphics(int width, int height, int cellW, int cellH) {

        this.height = height;
        this.width = width;
        this.cellW = cellW;
        this.cellH = cellH;
        this.setPreferredSize(new Dimension(width,height));

    }

    private void generateGrass(Graphics2D graphics2D,int grassCount) {
        int verticalCount = (int) Math.floor((double) height / cellH);
        int horizontalCount = (int) Math.floor((double) width / cellW);
        for (int i = 0; i < grassCount; i++) {
            Random random = new Random();
            int x = random.nextInt(horizontalCount) ;
            int y = random.nextInt(verticalCount) ;
            Rectangle2D grass = new Rectangle2D.Double(x * cellW, y * cellH, cellW, cellH);
            graphics2D.setColor(new Color(0, 255, 0));
            graphics2D.fill(grass);

        }

    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        Rectangle2D r = new Rectangle2D.Double(0, 0, width, height);
        g2d.setColor(new Color(187, 158, 158));
        g2d.fill(r);
        generateGrass(g2d,20);

//        g2d.setColor(new Color(255, 0, 0));
//        generateGrass(g2d);
    }

}

