package org.jedynakd.loader;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageLoader {
    public BufferedImage loadImageFromFile(String imageName) throws IOException {
        return ImageIO.read(new File(imageName));
    }
}
