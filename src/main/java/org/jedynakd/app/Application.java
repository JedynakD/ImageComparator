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
        Image comparedImage = imageComparator.compare(imageOne, imageTwo);
        ImageSaver saver = new ImageSaver();
        saver.saveImageToFile("images/result", comparedImage);
    }
}
