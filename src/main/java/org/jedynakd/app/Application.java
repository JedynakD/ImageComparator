package org.jedynakd.app;

import org.jedynakd.comparator.ImageComparator;
import org.jedynakd.loader.ImageLoader;
import org.jedynakd.saver.ImageSaver;
import org.jedynakd.util.ImageUtility;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class Application {

    static final String ERROR_MESSAGE = "No arguments, please provide paths to two files.";

    public static void main(String... args) throws IOException {
        checkArguments(args);
        String imageOnePath = args[0];
        String imageTwoPath = args[1];
        ImageLoader loader = new ImageLoader();
        BufferedImage imageOne = loader.loadImageFromFile(imageOnePath);
        BufferedImage imageTwo = loader.loadImageFromFile(imageTwoPath);
        ImageComparator imageComparator = new ImageComparator(new ImageUtility());
        BufferedImage comparedImage = imageComparator.compare(imageOne, imageTwo);
        ImageSaver saver = new ImageSaver();
        saver.saveImageToFile("result.png", comparedImage);
    }

    private static void checkArguments(String[] args) {
        if (args.length != 2) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }
}
