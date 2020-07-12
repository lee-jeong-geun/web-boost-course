package kr.or.connect.reservation.product.dto;

import kr.or.connect.reservation.category.dto.Category;

import java.util.Date;

public class Product {
    private int id;
    private String description;
    private String content;
    private Date create_date;
    private Date modify_date;

    private Category category;

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getContent() {
        return content;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public Date getModify_date() {
        return modify_date;
    }

    public Category getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", content='" + content + '\'' +
                ", create_date=" + create_date +
                ", modify_date=" + modify_date +
                ", category=" + category +
                '}';
    }
}
