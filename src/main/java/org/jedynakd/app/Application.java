package org.jedynakd.app;

import org.jedynakd.comparator.ImageComparator;
import org.jedynakd.data.Image;
import org.jedynakd.loader.ImageLoader;
import org.jedynakd.saver.ImageSaver;

public class Application {
    public static void main(String[] args) {
        ImageLoader loaderOne = new ImageLoader();
        Image imageOne = loaderOne.loadImageFromFile("images/test1");
        ImageLoader loaderTwo = new ImageLoader();
        Image imageTwo = loaderTwo.loadImageFromFile("images/test2");
        ImageComparator imageComparator = new ImageComparator();
        imageComparator.compareImages(imageOne, imageTwo);
        Image comparedImage = imageComparator.getComparedImage();
        ImageSaver saver = new ImageSaver(comparedImage);
        saver.saveImageToFile("images/result");
    }
}
