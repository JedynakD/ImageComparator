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
