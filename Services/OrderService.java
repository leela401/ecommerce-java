package services;

import models.Order;
import models.CartItem;
import java.util.*;

public class OrderService {
    private List<Order> orders = new ArrayList<>();

    public void placeOrder(List<CartItem> cartItems, double total) {
        List<CartItem> copy = new ArrayList<>();
        for (CartItem item : cartItems) {
            copy.add(new CartItem(item.getProduct(), item.getQuantity()));
        }
        orders.add(new Order(copy, total));
    }

    public List<Order> getAllOrders() {
        return orders;
    }
}
