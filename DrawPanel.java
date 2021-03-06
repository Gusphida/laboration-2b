import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    ArrayList<ImagePosition> cars = new ArrayList<>();

    void moveit(int x,int y, String modelName){
        try {
            ImagePosition img = new ImagePosition(ImageIO.read(DrawPanel.class.getResourceAsStream("pics/" + modelName + ".jpg")), x, y);
            cars.add(img);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
    }

    protected void drawCars(Graphics g) {
        for (ImagePosition car : cars) {
            g.drawImage(car.getImage(), car.getX(), car.getY(), null);
        }
        cars.clear();
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawCars(g);
    }
}
