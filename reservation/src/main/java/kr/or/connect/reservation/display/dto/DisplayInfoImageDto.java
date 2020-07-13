package kr.or.connect.reservation.display.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class DisplayInfoImageDto {
    private int displayInfoImageId;
    private int displayInfoId;
    private int fileId;
    private String fileName;
    private String saveFileName;
    private String contentType;
    private boolean deleteFlag;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime createDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime modifyDate;

    public int getDisplayInfoImageId() {
        return displayInfoImageId;
    }

    public void setDisplayInfoImageId(int displayInfoImageId) {
        this.displayInfoImageId = displayInfoImageId;
    }

    public int getDisplayInfoId() {
        return displayInfoId;
    }

    public void setDisplayInfoId(int displayInfoId) {
        this.displayInfoId = displayInfoId;
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

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public boolean isDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
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

    @Override
    public String toString() {
        return "DisplayInfoImageDto{" +
                "displayInfoImageId=" + displayInfoImageId +
                ", displayInfoId=" + displayInfoId +
                ", fileId=" + fileId +
                ", fileName='" + fileName + '\'' +
                ", saveFileName='" + saveFileName + '\'' +
                ", contentType='" + contentType + '\'' +
                ", deleteFlag=" + deleteFlag +
                ", createDate=" + createDate +
                ", modifyDate=" + modifyDate +
                '}';
    }
}
