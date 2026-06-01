package rvt.OnlineShop;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();

        warehouse.addProduct("produkts1", 2, 5);
        warehouse.addProduct("produkts2", 9999, 341343);
        warehouse.addProduct("lidmasina", 1, 554334);

        Scanner scanner = new Scanner(System.in);
        Store store = new Store(warehouse, scanner);

        store.shop("testtttttt");
    }
}

