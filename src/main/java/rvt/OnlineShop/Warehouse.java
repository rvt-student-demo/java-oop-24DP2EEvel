package rvt.OnlineShop;

import java.util.*;

public class Warehouse {
    private Map<String, Integer> prices;
    private Map<String, Integer> stocks;

    public Warehouse() {
        this.prices = new HashMap<>();
        this.stocks = new HashMap<>();
    }

    public void addProduct(String product, int price, int stock) {
        this.prices.put(product, price);
        this.stocks.put(product, stock);
    }

    public int price(String product) {
       // labs alternativs ar GetOrDeafault, jo nav japielieto if/else.
        return this.prices.getOrDefault(product, -99);
    }

    public int stock(String product) {
        // labs alternativs ar GetOrDeafault, jo nav japielieto if/else.
        return this.stocks.getOrDefault(product, 0);
    }

    public boolean take(String product) {
        if (this.stock(product) > 0) {
            this.stocks.put(product, this.stocks.get(product) - 1);
            return true;
        }
        return false;
    }

    public Set<String> products() {
        return this.stocks.keySet();
    }
}
