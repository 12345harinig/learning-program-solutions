package ProxyPatternExample;

public class ProxyImage implements Image {
    private RealImage realImage;
    private String fileName;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(fileName); // Lazy loading
        } else {
            System.out.println(fileName + " already loaded. Using cached image.");
        }
        realImage.display();
    }
}

