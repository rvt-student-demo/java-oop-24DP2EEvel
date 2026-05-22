package rvt;

import java.util.ArrayList;

public class Box implements packable {
    private double capacity;
    private ArrayList<packable> items;

    public Box(double capacity) {
        this.capacity = capacity;
        this.items = new ArrayList<>();
    }

    public void add(packable item) {
        if (this.weight() + item.weight() <= this.capacity) {
            this.items.add(item);
        }
    }

    @Override
    public double weight() {
        double totalWeight = 0;

        for (packable item : this.items) {
            totalWeight = totalWeight + item.weight();
        }

        return totalWeight;
    }

    @Override
    public String toString() {
        return "Box: " + this.items.size() + " items, total weight " + this.weight() + " kg";
    }
}
