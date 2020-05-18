package kr.or.connect.reservation.dto;

import java.util.Date;

public class ProductPrice {
    private int id;
    private String price_type_name;
    private int price;
    private double discount_rate;
    private Date create_date;
    private Date modify_date;

    private Product product;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrice_type_name() {
        return price_type_name;
    }

    public void setPrice_type_name(String price_type_name) {
        this.price_type_name = price_type_name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getDiscount_rate() {
        return discount_rate;
    }

    public void setDiscount_rate(double discount_rate) {
        this.discount_rate = discount_rate;
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "ProductPrice{" +
                "id=" + id +
                ", price_type_name='" + price_type_name + '\'' +
                ", price=" + price +
                ", discount_rate=" + discount_rate +
                ", create_date=" + create_date +
                ", modify_date=" + modify_date +
                ", product=" + product +
                '}';
    }
}
