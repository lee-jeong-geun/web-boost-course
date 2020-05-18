package kr.or.connect.reservation.dto;

import java.util.Date;

public class ReservationUserComment {
    private int id;
    private double score;
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

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
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
