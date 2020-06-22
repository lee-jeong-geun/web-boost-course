package kr.or.connect.reservation.product.dto;

public class ProductDto {
    private int displayInfoId;
    private int productId;
    private String productDescription;
    private String placeName;
    private String productContent;
    private String productImageUrl;

    public int getDisplayInfoId() {
        return displayInfoId;
    }

    public void setDisplayInfoId(int displayInfoId) {
        this.displayInfoId = displayInfoId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getProductContent() {
        return productContent;
    }

    public void setProductContent(String productContent) {
        this.productContent = productContent;
    }

    public String getProductImageUrl() {
        return productImageUrl;
    }

    public void setProductImageUrl(String productImageUrl) {
        this.productImageUrl = productImageUrl;
    }

    @Override
    public String toString() {
        return "ProductDto{" +
                "displayInfoId=" + displayInfoId +
                ", productId=" + productId +
                ", productDescription='" + productDescription + '\'' +
                ", placeName='" + placeName + '\'' +
                ", productContent='" + productContent + '\'' +
                ", productImageUrl='" + productImageUrl + '\'' +
                '}';
    }
}
