package kr.or.connect.reservation.dto;

import java.util.Date;

public class FileInfo {
    private int id;
    private String file_name;
    private String save_file_name;
    private String content_type;
    private String delete_flag;
    private Date create_date;
    private Date modify_date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public String getSave_file_name() {
        return save_file_name;
    }

    public void setSave_file_name(String save_file_name) {
        this.save_file_name = save_file_name;
    }

    public String getContent_type() {
        return content_type;
    }

    public void setContent_type(String content_type) {
        this.content_type = content_type;
    }

    public String getDelete_flag() {
        return delete_flag;
    }

    public void setDelete_flag(String delete_flag) {
        this.delete_flag = delete_flag;
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

    @Override
    public String toString() {
        return "FileInfo{" +
                "id=" + id +
                ", file_name='" + file_name + '\'' +
                ", save_file_name='" + save_file_name + '\'' +
                ", content_type='" + content_type + '\'' +
                ", delete_flag='" + delete_flag + '\'' +
                ", create_date=" + create_date +
                ", modify_date=" + modify_date +
                '}';
    }
}
