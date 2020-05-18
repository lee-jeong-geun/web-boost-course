package kr.or.connect.reservation.dto;

public class ReservationInfoPrice {
    private int id;
    private int count;

    private ReservationInfo reservationInfo;
    private ProductPrice productPrice;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public ReservationInfo getReservationInfo() {
        return reservationInfo;
    }

    public void setReservationInfo(ReservationInfo reservationInfo) {
        this.reservationInfo = reservationInfo;
    }

    public ProductPrice getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(ProductPrice productPrice) {
        this.productPrice = productPrice;
    }

    @Override
    public String toString() {
        return "ReservationInfoPrice{" +
                "id=" + id +
                ", count=" + count +
                ", reservationInfo=" + reservationInfo +
                ", productPrice=" + productPrice +
                '}';
    }
}
