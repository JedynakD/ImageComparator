package org.jedynakd.saver;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageSaver {
    public void saveImageToFile(String imageName, BufferedImage image) throws IOException {
        File file = new File(imageName);
        ImageIO.write(image, "png", file);
    }
}
