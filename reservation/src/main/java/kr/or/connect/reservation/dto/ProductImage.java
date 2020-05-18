package kr.or.connect.reservation.dto;

public class ProductImage {
    private int id;
    private String type;

    private Product product;
    private FileInfo fileInfo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public FileInfo getFileInfo() {
        return fileInfo;
    }

    public void setFileInfo(FileInfo fileInfo) {
        this.fileInfo = fileInfo;
    }

    @Override
    public String toString() {
        return "ProductImage{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", product=" + product +
                ", fileInfo=" + fileInfo +
                '}';
    }
}
