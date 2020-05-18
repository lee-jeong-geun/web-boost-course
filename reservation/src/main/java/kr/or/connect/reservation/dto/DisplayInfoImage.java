package kr.or.connect.reservation.dto;

public class DisplayInfoImage {
    private int id;

    private DisplayInfo displayInfo;
    private FileInfo fileInfo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DisplayInfo getDisplayInfo() {
        return displayInfo;
    }

    public void setDisplayInfo(DisplayInfo displayInfo) {
        this.displayInfo = displayInfo;
    }

    public FileInfo getFileInfo() {
        return fileInfo;
    }

    public void setFileInfo(FileInfo fileInfo) {
        this.fileInfo = fileInfo;
    }

    @Override
    public String toString() {
        return "DisplayInfoImage{" +
                "id=" + id +
                ", displayInfo=" + displayInfo +
                ", fileInfo=" + fileInfo +
                '}';
    }
}
