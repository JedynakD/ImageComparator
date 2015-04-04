package org.jedynakd.util;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class ImageUtility {

    public List<Integer> getImageRGBValueOfPixels(BufferedImage image) {
        List<Integer> pixels = new ArrayList<>();
        for (int height = 0; height < image.getHeight(); height++) {
            for (int width = 0; width < image.getWidth(); width++) {
                pixels.add(image.getRGB(width, height));
            }
        }
        return pixels;
    }

}
