package org.jedynakd.comparator;

import org.jedynakd.data.Image;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Iterator;
import java.util.List;

public class ImageComparator {
    private final static int maximumRGBValue = 16777216;
    private final static int maximumRGBComponentValue = 255;
    private Image comparedImage;

    public void compareImages(Image imageOne, Image imageTwo) {
        if (imageOne.getImage().getWidth() >= imageTwo.getImage().getWidth()) {
            imageTwo = returnResizedImage(imageTwo, imageOne);
        } else {
            imageOne = returnResizedImage(imageOne, imageTwo);
        }
        List<Integer> imageOneRGBValues = imageOne.getImageRGBValueOfPixels();
        List<Integer> imageTwoRGBValues = imageTwo.getImageRGBValueOfPixels();
        comparedImage = imageOne;
        Iterator<Integer> valueOne = imageOneRGBValues.iterator();
        Iterator<Integer> valueTwo = imageTwoRGBValues.iterator();
        int imageOneRGBValue;
        int imageTwoRGBValue;
        int differenceInRGB;
        int linearDifferenceInRGBValues;
        for (int height = 0; height < comparedImage.getImage().getHeight(); height++) {
            for (int width = 0; width < comparedImage.getImage().getWidth(); width++) {
                if (valueOne.hasNext() && valueTwo.hasNext()) {
                    imageOneRGBValue = Math.abs(valueOne.next());
                    imageTwoRGBValue = Math.abs(valueTwo.next());
                    differenceInRGB = Math.abs(imageOneRGBValue - imageTwoRGBValue);
                    linearDifferenceInRGBValues = maximumRGBComponentValue - (differenceInRGB / (maximumRGBValue / maximumRGBComponentValue));
                    comparedImage.getImage().setRGB(width, height, new Color(linearDifferenceInRGBValues, linearDifferenceInRGBValues, linearDifferenceInRGBValues).getRGB());
                }
            }
        }
    }

    private Image returnResizedImage(Image original, Image imageWithParametersToResize) {
        int width = imageWithParametersToResize.getImage().getWidth();
        int height = imageWithParametersToResize.getImage().getHeight();
        int type = imageWithParametersToResize.getImage().getType();
        BufferedImage resizedImage = new BufferedImage(width, height, type);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(original.getImage(), 0, 0, width, height, null);
        g.dispose();
        return new Image(resizedImage);
    }

    public Image getComparedImage() {
        return comparedImage;
    }
}