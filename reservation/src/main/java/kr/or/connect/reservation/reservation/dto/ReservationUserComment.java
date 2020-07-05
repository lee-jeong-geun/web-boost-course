package kr.or.connect.reservation.reservation.dto;

import kr.or.connect.reservation.product.dto.Product;
import kr.or.connect.reservation.reservation.dto.ReservationInfo;

import java.util.Date;

public class ReservationUserComment {
    private int id;
    private int score;
    private String comment;
    private Date create_date;
    private Date modify_date;

    private Product product;
    private ReservationInfo reservationInfo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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

    public ReservationInfo getReservationInfo() {
        return reservationInfo;
    }

    public void setReservationInfo(ReservationInfo reservationInfo) {
        this.reservationInfo = reservationInfo;
    }

    @Override
    public String toString() {
        return "ReservationUserComment{" +
                "id=" + id +
                ", score=" + score +
                ", comment='" + comment + '\'' +
                ", create_date=" + create_date +
                ", modify_date=" + modify_date +
                ", product=" + product +
                ", reservationInfo=" + reservationInfo +
                '}';
    }
}
