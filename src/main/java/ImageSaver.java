import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageSaver {
    private Image image;

    public ImageSaver(Image image) {
        this.image = image;
    }

    public void saveImageToFile(String imageName) {
        File file = new File(imageName + ".png");
        BufferedImage bufferedImage = image.getImage();
        try {
            ImageIO.write(bufferedImage, "png", file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
