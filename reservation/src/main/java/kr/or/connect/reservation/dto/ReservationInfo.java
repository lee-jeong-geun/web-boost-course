package kr.or.connect.reservation.dto;

import java.util.Date;

public class ReservationInfo {
    private int id;
    private String reservation_name;
    private String reservation_tel;
    private String reservation_email;
    private Date reservation_date;
    private int cancel_flag;
    private Date create_date;
    private Date modify_date;

    private Product product;
    private DisplayInfo displayInfo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReservation_name() {
        return reservation_name;
    }

    public void setReservation_name(String reservation_name) {
        this.reservation_name = reservation_name;
    }

    public String getReservation_tel() {
        return reservation_tel;
    }

    public void setReservation_tel(String reservation_tel) {
        this.reservation_tel = reservation_tel;
    }

    public String getReservation_email() {
        return reservation_email;
    }

    public void setReservation_email(String reservation_email) {
        this.reservation_email = reservation_email;
    }

    public Date getReservation_date() {
        return reservation_date;
    }

    public void setReservation_date(Date reservation_date) {
        this.reservation_date = reservation_date;
    }

    public int getCancel_flag() {
        return cancel_flag;
    }

    public void setCancel_flag(int cancel_flag) {
        this.cancel_flag = cancel_flag;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public Date getModify_date() {
        return modify_date;
    }

    public void setModify_date(Date modify_date) {
        this.modify_date = modify_date;
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
                ", reservation_name='" + reservation_name + '\'' +
                ", reservation_tel='" + reservation_tel + '\'' +
                ", reservation_email='" + reservation_email + '\'' +
                ", reservation_date=" + reservation_date +
                ", cancel_flag=" + cancel_flag +
                ", create_date=" + create_date +
                ", modify_date=" + modify_date +
                ", product=" + product +
                ", displayInfo=" + displayInfo +
                '}';
    }
}
