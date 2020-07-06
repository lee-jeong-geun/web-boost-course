package kr.or.connect.reservation.reservation.dto;

import java.util.Date;
import java.util.List;

public class ReservationUserCommentDto {
    private int commentId;
    private int productId;
    private int reservationInfoId;
    private int score;
    private String comment;
    private String reservationName;
    private String reservationTelephone;
    private String reservationEmail;
    private String reservationDate;
    private Date create_date;
    private Date modify_date;
    private List<ReservationUserCommentImageDto> commentImages;

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getReservationInfoId() {
        return reservationInfoId;
    }

    public void setReservationInfoId(int reservationInfoId) {
        this.reservationInfoId = reservationInfoId;
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

    public String getReservationName() {
        return reservationName;
    }

    public void setReservationName(String reservationName) {
        this.reservationName = reservationName;
    }

    public String getReservationTelephone() {
        return reservationTelephone;
    }

    public void setReservationTelephone(String reservationTelephone) {
        this.reservationTelephone = reservationTelephone;
    }

    public String getReservationEmail() {
        return reservationEmail;
    }

    public void setReservationEmail(String reservationEmail) {
        this.reservationEmail = reservationEmail;
    }

    public String getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(String reservationDate) {
        this.reservationDate = reservationDate;
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

    public List<ReservationUserCommentImageDto> getCommentImages() {
        return commentImages;
    }

    public void setCommentImages(List<ReservationUserCommentImageDto> commentImages) {
        this.commentImages = commentImages;
    }

    @Override
    public String toString() {
        return "ReservationUserCommentDto{" +
                "commentId=" + commentId +
                ", productId=" + productId +
                ", reservationInfoId=" + reservationInfoId +
                ", score=" + score +
                ", comment='" + comment + '\'' +
                ", reservationName='" + reservationName + '\'' +
                ", reservationTelephone='" + reservationTelephone + '\'' +
                ", reservationEmail='" + reservationEmail + '\'' +
                ", reservationDate='" + reservationDate + '\'' +
                ", create_date=" + create_date +
                ", modify_date=" + modify_date +
                ", commentImages=" + commentImages +
                '}';
    }
}
