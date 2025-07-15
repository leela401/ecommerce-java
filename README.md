# 🛒 Simple E-commerce Console App in Java

This is a **console-based e-commerce application** built in **Java**. It features basic functionalities for customers and admins, including product management, cart handling, order processing, and authentication.

---

## 📌 Features

### 👤 User Roles

* **Admin**

  * Add, update, delete, and view products
* **Customer**

  * Browse products
  * Add to cart, view cart, remove items
  * Place orders
  * View order history

### ✅ Authentication

* Register and login using email & password
* Role-based access (admin/customer)

### 🧱 Technologies Used

* Java (Core OOP Concepts)
* Java Collections (ArrayList, Scanner, etc.)
* Modular code (separate `models`, `services`, and main app logic)

---

## 📂 Folder Structure

```
📦 ecommerce-java
├── Main.java
├── models
│   ├── User.java
│   ├── Product.java
│   ├── CartItem.java
│   └── Order.java
├── services
│   ├── UserService.java
│   ├── ProductService.java
│   ├── CartService.java
│   └── OrderService.java


## 🚀 How to Run

1. Clone the repository:

```bash
git clone https://github.com/your-username/ecommerce-java.git
cd ecommerce-java
```

2. Compile the project:

```bash
javac Main.java models/*.java services/*.java
```

3. Run the app:

```bash
java Main
```

## 📝 Future Improvements

* File-based data persistence (save users/products/orders to disk)
* GUI using JavaFX or Swing
* Web version using Spring Boot + MySQL


## 🙋‍♂️ Author

**Bugga Leelavathi**
Email: lasyaleela2002@gmail.com



