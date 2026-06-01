package rvt.OnlineShop;

public class Items {
    private String name;
    private int quantity;
    private int unitPrice;

    public Items(String product, int qty, int unitPrice) {
        this.name = product;
        this.quantity = qty;
        this.unitPrice = unitPrice;
    }

    public int price() {
        return this.quantity * this.unitPrice;
    }

    public void increaseQuantity() {
        this.quantity++;
    }

    @Override
    public String toString() {
        return this.name + ": " + this.quantity;
    }
}
