import java.awt.image.BufferedImage;
import java.awt.*;

public class ImagePosition {
    private BufferedImage image;
    private Point position;

    public ImagePosition(BufferedImage image, Point position) {
        this.image = image;
        this.position = position;
    }

    public BufferedImage getImage() {
        return image;
    }

    public Point getPosition() {
        return position;
    }
}
