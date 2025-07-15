package services;

import models.Product;
import models.CartItem;
import java.util.*;

public class CartService {
    private List<CartItem> cart = new ArrayList<>();

    public void addToCart(Product product, int quantity) {
        for (CartItem item : cart) {
            if (item.getProduct().getId() == product.getId()) {
                item.setQuantity(item.getQuantity() + quantity);
                return;
            }
        }
        cart.add(new CartItem(product, quantity));
    }

    public List<CartItem> getCartItems() { return cart; }

    public double getCartTotal() {
        double total = 0;
        for (CartItem item : cart) {
            total += item.getTotalPrice();
        }
        return total;
    }

    public void clearCart() { cart.clear(); }

    public boolean removeItem(int productId) {
        return cart.removeIf(item -> item.getProduct().getId() == productId);
    }
}
