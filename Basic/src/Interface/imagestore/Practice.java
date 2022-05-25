package Interface.imagestore;

class PngImage extends Image {

}

class AwsImageStore implements ImageStore {

    private boolean connected;
    @Override
    public String getToken() {
        return "AWS";
    }

    @Override
    public void connection() {
        connected = true;
        System.out.println("Connect to AWS");
    }

    @Override
    public Image downloadImage(String url, String token) {
        if (!connected) return null;

        // how to input diff format of image
        Image image = new PngImage();
        return image;

    }

    @Override
    public void uploadImage(Image image, String token) {
        if (token==null || token.length()==0) return;

        System.out.println("Uploading");
    }
}

public class Practice {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        // Use Reflection to define specific image store Or use factory
        ImageStore imageStore = (ImageStore)Class.forName("Interface.imagestore.GCPImageStore").newInstance();
        System.out.println(imageStore.getToken());
    }
}
