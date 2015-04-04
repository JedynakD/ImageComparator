package org.jedynakd.comparator;

import org.jedynakd.util.ImageUtility;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Iterator;
import java.util.List;

public class ImageComparator {
    private final static int MAXIMUM_RGB_VALUE = 16777216;
    private final static int MAXIMUM_RGB_COMPONENT_VALUE = 255;
    private final ImageUtility imageUtility;

    public ImageComparator(ImageUtility imageUtility) {
        this.imageUtility = imageUtility;
    }

    public BufferedImage compare(BufferedImage imageOne, BufferedImage imageTwo) {
        BufferedImage comparedImage;
        if (imageOne.getWidth() >= imageTwo.getWidth()) {
            imageTwo = getResizedImage(imageTwo, imageOne);
            comparedImage = imageTwo;
        } else {
            imageOne = getResizedImage(imageOne, imageTwo);
            comparedImage = imageOne;
        }
        List<Integer> imageOneRGBValues = imageUtility.getImageRGBValueOfPixels(imageOne);
        List<Integer> imageTwoRGBValues = imageUtility.getImageRGBValueOfPixels(imageTwo);
        Iterator<Integer> valueOne = imageOneRGBValues.iterator();
        Iterator<Integer> valueTwo = imageTwoRGBValues.iterator();

        for (int height = 0; height < comparedImage.getHeight(); height++) {
            for (int width = 0; width < comparedImage.getWidth(); width++) {
                if (valueOne.hasNext() && valueTwo.hasNext()) {
                    int imageOneRGBValue = Math.abs(valueOne.next());
                    int imageTwoRGBValue = Math.abs(valueTwo.next());
                    int differenceInRGB = Math.abs(imageOneRGBValue - imageTwoRGBValue);
                    int linearDifferenceInRGBValues = MAXIMUM_RGB_COMPONENT_VALUE - (differenceInRGB / (MAXIMUM_RGB_VALUE / MAXIMUM_RGB_COMPONENT_VALUE));
                    comparedImage.setRGB(width, height, new Color(linearDifferenceInRGBValues, linearDifferenceInRGBValues, linearDifferenceInRGBValues).getRGB());
                }
            }
        }
        return comparedImage;
    }

    private BufferedImage getResizedImage(BufferedImage original, BufferedImage imageWithParametersToResize) {
        int width = imageWithParametersToResize.getWidth();
        int height = imageWithParametersToResize.getHeight();
        int type = imageWithParametersToResize.getType();
        BufferedImage resizedImage = new BufferedImage(width, height, type);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(original, 0, 0, width, height, null);
        g.dispose();
        return resizedImage;
    }
}