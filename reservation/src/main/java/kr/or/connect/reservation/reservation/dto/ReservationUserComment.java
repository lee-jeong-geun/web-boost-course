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

    public int getScore() {
        return score;
    }

    public String getComment() {
        return comment;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public Date getModify_date() {
        return modify_date;
    }

    public Product getProduct() {
        return product;
    }

    public ReservationInfo getReservationInfo() {
        return reservationInfo;
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
