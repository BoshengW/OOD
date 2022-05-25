package Interface.imagestore;

public abstract class Image {

    private String createAt;

    private int size;

    private byte content;

    private String name;

    public int getSize() {
        return size;
    };

    public String getCreateAt() {
        return createAt;
    }


    public byte getContent() {
        return content;
    }



}
