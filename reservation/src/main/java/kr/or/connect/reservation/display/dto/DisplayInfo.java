package kr.or.connect.reservation.display.dto;

import kr.or.connect.reservation.product.dto.Product;

import java.util.Date;

public class DisplayInfo {
    private int id;
    private String openingHours;
    private String placeName;
    private String placeLot;
    private String placeStreet;
    private String tel;
    private String homepage;
    private String email;
    private Date createDate;
    private Date modifyDate;

    private Product product;

    public int getId() {
        return id;
    }

    public String getOpeningHours() {
        return openingHours;
    }

    public String getPlaceName() {
        return placeName;
    }

    public String getPlaceLot() {
        return placeLot;
    }

    public String getPlaceStreet() {
        return placeStreet;
    }

    public String getTel() {
        return tel;
    }

    public String getHomepage() {
        return homepage;
    }

    public String getEmail() {
        return email;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public Product getProduct() {
        return product;
    }

    @Override
    public String toString() {
        return "DisplayInfo{" +
                "id=" + id +
                ", openingHours='" + openingHours + '\'' +
                ", placeName='" + placeName + '\'' +
                ", placeLot='" + placeLot + '\'' +
                ", placeStreet='" + placeStreet + '\'' +
                ", tel='" + tel + '\'' +
                ", homepage='" + homepage + '\'' +
                ", email='" + email + '\'' +
                ", createDate=" + createDate +
                ", modifyDate=" + modifyDate +
                ", product=" + product +
                '}';
    }
}
