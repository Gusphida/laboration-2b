import java.awt.image.BufferedImage;
import java.awt.*;

public class ImagePosition {
    private BufferedImage image;
    private int x;
    private int y;

    public ImagePosition(BufferedImage image, int x, int y) {
        this.image = image;
        this.x = x;
        this.y = y;
    }

    public BufferedImage getImage() {
        return image;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
