package kr.or.connect.reservation.reservation.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime createDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime modifyDate;
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

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(LocalDateTime modifyDate) {
        this.modifyDate = modifyDate;
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
                ", createDate=" + createDate +
                ", modifyDate=" + modifyDate +
                ", commentImages=" + commentImages +
                '}';
    }
}
