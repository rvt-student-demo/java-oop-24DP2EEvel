package rvt.OnlineShop;

import java.util.*;

public class ShoppingCart {
    private Map<String, Items> items;

    public ShoppingCart() {
        this.items = new HashMap<>();
    }

    public void add(String product, int price) {
        if (this.items.containsKey(product)) {
            this.items.get(product).increaseQuantity();
        } else {
            this.items.put(product, new Items(product, 1, price));
        }
    }

    public int price() {
        int totalPrice = 0;
        for (Items item : this.items.values()) {
            totalPrice += item.price();
        }
        return totalPrice;
    }

    public void print() {
        for (Items item : this.items.values()) {
            System.out.println(item.toString());
        }
    }
}
