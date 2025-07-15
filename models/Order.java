package models;

import java.util.List;

public class Order {
    private static int idCounter = 1;
    private int orderId;
    private List<CartItem> items;
    private double total;

    public Order(List<CartItem> items, double total) {
        this.orderId = idCounter++;
        this.items = items;
        this.total = total;
    }

    public int getOrderId() { return orderId; }
    public List<CartItem> getItems() { return items; }
    public double getTotal() { return total; }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("🧾 Order #" + orderId + "\n");
        for (CartItem item : items) {
            sb.append("  ").append(item).append("\n");
        }
        sb.append("  Total: ₹").append(total).append("\n");
        return sb.toString();
    }
}
