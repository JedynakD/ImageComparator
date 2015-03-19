package org.jedynakd.data;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Image {
    private BufferedImage image;

    public Image(BufferedImage image) {
        this.image = image;
    }

    public List<Integer> getImageRGBValueOfPixels() {
        List<Integer> pixels = new ArrayList<>();
        for (int height = 0; height < image.getHeight(); height++) {
            for (int width = 0; width < image.getWidth(); width++) {
                pixels.add(image.getRGB(width, height));
            }
        }
        return pixels;
    }

    public BufferedImage getImage() {
        return image;
    }
}
