package kr.or.connect.reservation.reservation.dto;

import java.util.Date;

public class ReservationUserCommentImageDto {
    private int imageId;
    private int reservationInfoId;
    private int reservationUserCommentId;
    private int fileId;
    private String fileName;
    private String saveFileName;
    private int deleteFlag;
    private Date createDate;
    private Date modifyDate;

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public int getReservationInfoId() {
        return reservationInfoId;
    }

    public void setReservationInfoId(int reservationInfoId) {
        this.reservationInfoId = reservationInfoId;
    }

    public int getReservationUserCommentId() {
        return reservationUserCommentId;
    }

    public void setReservationUserCommentId(int reservationUserCommentId) {
        this.reservationUserCommentId = reservationUserCommentId;
    }

    public int getFileId() {
        return fileId;
    }

    public void setFileId(int fileId) {
        this.fileId = fileId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getSaveFileName() {
        return saveFileName;
    }

    public void setSaveFileName(String saveFileName) {
        this.saveFileName = saveFileName;
    }

    public int getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(int deleteFlag) {
        this.deleteFlag = deleteFlag;
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

    @Override
    public String toString() {
        return "ReservationUserCommentImageDto{" +
                "imageId=" + imageId +
                ", reservationInfoId=" + reservationInfoId +
                ", reservationUserCommentId=" + reservationUserCommentId +
                ", fileId=" + fileId +
                ", fileName='" + fileName + '\'' +
                ", saveFileName='" + saveFileName + '\'' +
                ", deleteFlag=" + deleteFlag +
                ", createDate=" + createDate +
                ", modifyDate=" + modifyDate +
                '}';
    }
}
