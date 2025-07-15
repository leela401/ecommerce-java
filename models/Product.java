package models;

public class Product {
    private static int idCounter = 1;
    private int id;
    private String name;
    private double price;
    private String category;

    public Product(String name, double price, String category) {
        this.id = idCounter++;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public String getCategory() { return category; }

    public void setName(String name) { this.name = name; }
    public void setPrice(double price) { this.price = price; }
    public void setCategory(String category) { this.category = category; }

    public String toString() {
        return id + ". " + name + " - ₹" + price + " [" + category + "]";
    }
}
