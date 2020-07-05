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

    public void setId(int id) {
        this.id = id;
    }

    public String getReservationName() {
        return reservationName;
    }

    public void setReservationName(String reservationName) {
        this.reservationName = reservationName;
    }

    public String getReservationTel() {
        return reservationTelephone;
    }

    public void setReservationTel(String reservationTel) {
        this.reservationTelephone = reservationTel;
    }

    public String getReservationEmail() {
        return reservationEmail;
    }

    public void setReservationEmail(String reservationEmail) {
        this.reservationEmail = reservationEmail;
    }

    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

    public int getCancelFlag() {
        return cancelFlag;
    }

    public void setCancelFlag(int cancelFlag) {
        this.cancelFlag = cancelFlag;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public DisplayInfo getDisplayInfo() {
        return displayInfo;
    }

    public void setDisplayInfo(DisplayInfo displayInfo) {
        this.displayInfo = displayInfo;
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
