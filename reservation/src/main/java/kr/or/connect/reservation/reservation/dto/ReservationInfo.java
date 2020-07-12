package kr.or.connect.reservation.reservation.dto;

import kr.or.connect.reservation.display.dto.DisplayInfo;
import kr.or.connect.reservation.product.dto.Product;

import java.util.Date;

public class ReservationInfo {
    private int id;
    private String reservationName;
    private String reservationTelephone;
    private String reservationEmail;
    private Date reservationDate;
    private int cancelFlag;
    private Date createDate;
    private Date modifyDate;

    private Product product;
    private DisplayInfo displayInfo;

    public int getId() {
        return id;
    }

    public String getReservationName() {
        return reservationName;
    }

    public String getReservationTelephone() {
        return reservationTelephone;
    }

    public String getReservationEmail() {
        return reservationEmail;
    }

    public Date getReservationDate() {
        return reservationDate;
    }

    public int getCancelFlag() {
        return cancelFlag;
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

    public DisplayInfo getDisplayInfo() {
        return displayInfo;
    }

    @Override
    public String toString() {
        return "ReservationInfo{" +
                "id=" + id +
                ", reservationName='" + reservationName + '\'' +
                ", reservationTel='" + reservationTelephone + '\'' +
                ", reservationEmail='" + reservationEmail + '\'' +
                ", reservationDate=" + reservationDate +
                ", cancelFlag=" + cancelFlag +
                ", createDate=" + createDate +
                ", modifyDate=" + modifyDate +
                ", product=" + product +
                ", displayInfo=" + displayInfo +
                '}';
    }
}
