package kr.or.connect.reservation.category.dto;

public class CategoryDto {
    private int id;
    private String name;
    private int count;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + id +
                ", name='" + name + '\'' +
                ", count='" + count + '\'' +
                '}';
    }
}
