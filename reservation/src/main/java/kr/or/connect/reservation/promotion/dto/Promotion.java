package kr.or.connect.reservation.promotion.dto;

import kr.or.connect.reservation.product.dto.Product;

public class Promotion {
    private int id;

    private Product product;

    public int getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    @Override
    public String toString() {
        return "Promotion{" +
                "id=" + id +
                ", product=" + product +
                '}';
    }
}
