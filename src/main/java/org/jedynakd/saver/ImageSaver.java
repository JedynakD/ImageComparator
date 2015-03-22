package org.jedynakd.saver;

import org.jedynakd.data.Image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageSaver {
    public void saveImageToFile(String imageName, Image image) {
        File file = new File(imageName + ".png");
        BufferedImage bufferedImage = image.getImage();
        try {
            ImageIO.write(bufferedImage, "png", file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
