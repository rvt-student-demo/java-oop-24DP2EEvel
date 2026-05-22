package rvt;

import java.util.HashMap;

public class IOU {
    private HashMap<String, Double> register;

    public IOU() {
        this.register = new HashMap<>();
    }

    public void setSum(String toWhom, double amount) {
        if (!isThereYet(toWhom)) {
            this.register.put(toWhom, amount);
        }
    }

    public boolean isThereYet(String toWhom) {
        return this.register.containsKey(toWhom);
    }

    public double howMuchDoIOweTo(String toWhom) {
        return this.register.getOrDefault(toWhom, 0.0);
    }
}
