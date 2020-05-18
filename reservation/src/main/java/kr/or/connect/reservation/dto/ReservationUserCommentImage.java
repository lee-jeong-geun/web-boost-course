package kr.or.connect.reservation.dto;

public class ReservationUserCommentImage {
    private int id;

    private ReservationInfo reservationInfo;
    private ReservationUserComment reservationUserComment;
    private FileInfo fileInfo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ReservationInfo getReservationInfo() {
        return reservationInfo;
    }

    public void setReservationInfo(ReservationInfo reservationInfo) {
        this.reservationInfo = reservationInfo;
    }

    public ReservationUserComment getReservationUserComment() {
        return reservationUserComment;
    }

    public void setReservationUserComment(ReservationUserComment reservationUserComment) {
        this.reservationUserComment = reservationUserComment;
    }

    public FileInfo getFileInfo() {
        return fileInfo;
    }

    public void setFileInfo(FileInfo fileInfo) {
        this.fileInfo = fileInfo;
    }

    @Override
    public String toString() {
        return "ReservationUserCommentImage{" +
                "id=" + id +
                ", reservationInfo=" + reservationInfo +
                ", reservationUserComment=" + reservationUserComment +
                ", fileInfo=" + fileInfo +
                '}';
    }
}
