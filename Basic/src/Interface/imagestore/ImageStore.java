package Interface.imagestore;

/**
 * Interface 通常表示一些action has-a 关系
 *
 * */
public interface ImageStore {

    public String getToken();

    public void connection();

    public Image downloadImage(String url, String token);

    public void uploadImage(Image image, String token);

}
