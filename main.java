// === Main.java ===

import services.*;
import models.*;
import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static UserService userService = new UserService();
    static ProductService productService = new ProductService();

    public static void main(String[] args) {
        User loggedInUser = null;

        System.out.println("=== Welcome to Simple E-commerce ===");

        while (true) {
            System.out.println("\n1. Register\n2. Login\n3. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("Enter name: ");
                String name = sc.nextLine();
                System.out.print("Enter email: ");
                String email = sc.nextLine();
                System.out.print("Enter password: ");
                String password = sc.nextLine();
                System.out.print("Enter role (admin/customer): ");
                String role = sc.nextLine();

                if (userService.register(name, email, password, role)) {
                    System.out.println("✅ Registered successfully!");
                } else {
                    System.out.println("❌ Email already exists.");
                }

            } else if (choice == 2) {
                System.out.print("Enter email: ");
                String email = sc.nextLine();
                System.out.print("Enter password: ");
                String password = sc.nextLine();

                loggedInUser = userService.login(email, password);
                if (loggedInUser != null) {
                    System.out.println("✅ Login successful as " + loggedInUser.getRole());
                    break;
                } else {
                    System.out.println("❌ Invalid credentials.");
                }
            } else {
                System.out.println("👋 Exiting. Goodbye!");
                System.exit(0);
            }
        }

        if (loggedInUser.getRole().equalsIgnoreCase("admin")) {
            adminMenu();
        } else {
            customerMenu();
        }
    }

    public static void adminMenu() {
        while (true) {
            System.out.println("\n--- Admin Menu ---");
            System.out.println("1. Add Product");
            System.out.println("2. View Products");
            System.out.println("3. Update Product");
            System.out.println("4. Delete Product");
            System.out.println("5. Logout");
            System.out.print("Choose: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("Name: ");
                String name = sc.nextLine();
                System.out.print("Price: ");
                double price = sc.nextDouble();
                sc.nextLine();
                System.out.print("Category: ");
                String cat = sc.nextLine();
                productService.addProduct(name, price, cat);
                System.out.println("✅ Product added.");
            } else if (choice == 2) {
                System.out.println("--- Products ---");
                for (Product p : productService.getAllProducts()) {
                    System.out.println(p);
                }
            } else if (choice == 3) {
                System.out.print("Enter product ID to update: ");
                int id = sc.nextInt(); sc.nextLine();
                System.out.print("New Name: ");
                String name = sc.nextLine();
                System.out.print("New Price: ");
                double price = sc.nextDouble(); sc.nextLine();
                System.out.print("New Category: ");
                String cat = sc.nextLine();

                if (productService.updateProduct(id, name, price, cat)) {
                    System.out.println("✅ Updated.");
                } else {
                    System.out.println("❌ Product not found.");
                }
            } else if (choice == 4) {
                System.out.print("Enter product ID to delete: ");
                int id = sc.nextInt();
                if (productService.deleteProduct(id)) {
                    System.out.println("🗑️ Product deleted.");
                } else {
                    System.out.println("❌ Product not found.");
                }
            } else {
                System.out.println("🔓 Logging out...");
                break;
            }
        }
    }

    public static void customerMenu() {
        CartService cartService = new CartService();
        OrderService orderService = new OrderService();

        while (true) {
            System.out.println("\n--- Customer Menu ---");
            System.out.println("1. View Products");
            System.out.println("2. Add to Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Remove Item from Cart");
            System.out.println("5. Place Order");
            System.out.println("6. View Order History");
            System.out.println("7. Logout");
            System.out.print("Choose: ");
            int choice = sc.nextInt(); sc.nextLine();

            if (choice == 1) {
                for (Product p : productService.getAllProducts()) {
                    System.out.println(p);
                }
            } else if (choice == 2) {
                System.out.print("Enter product ID: ");
                int id = sc.nextInt();
                System.out.print("Quantity: ");
                int qty = sc.nextInt();
                Product product = productService.getProductById(id);
                if (product != null) {
                    cartService.addToCart(product, qty);
                    System.out.println("✅ Added to cart.");
                } else {
                    System.out.println("❌ Product not found.");
                }
            } else if (choice == 3) {
                System.out.println("--- Your Cart ---");
                for (CartItem item : cartService.getCartItems()) {
                    System.out.println(item);
                }
                System.out.println("Total: ₹" + cartService.getCartTotal());
            } else if (choice == 4) {
                System.out.print("Enter product ID to remove: ");
                int pid = sc.nextInt();
                if (cartService.removeItem(pid)) {
                    System.out.println("🗑️ Item removed.");
                } else {
                    System.out.println("❌ Item not in cart.");
                }
            } else if (choice == 5) {
                if (cartService.getCartItems().isEmpty()) {
                    System.out.println("🛒 Your cart is empty!");
                } else {
                    orderService.placeOrder(cartService.getCartItems(), cartService.getCartTotal());
                    System.out.println("✅ Order placed successfully!");
                    System.out.println("Total Paid: ₹" + cartService.getCartTotal());
                    cartService.clearCart();
                }
            } else if (choice == 6) {
                List<Order> orders = orderService.getAllOrders();
                if (orders.isEmpty()) {
                    System.out.println("📭 No orders yet.");
                } else {
                    for (Order o : orders) {
                        System.out.println(o);
                    }
                }
            } else {
                System.out.println("🔓 Logging out...");
                break;
            }
        }
    }
}