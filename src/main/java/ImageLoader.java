import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageLoader {
    public Image loadImageFromFile(String imageName) {
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File(imageName + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image wrappedImage = new Image(image);
        return wrappedImage;
    }
}
