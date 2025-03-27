import java.text.DecimalFormat;
// Base class representing a Product
class Product {
private String name;
protected double price;
public Product(String name, double price) {
this.name = name;
this.price = price;
}
// Method to calculate and apply discounts
public void applyDiscount() {
// Default discount behavior (no discount)
System.out.println("No discount applied.");
}
// Method to display product details
public void displayProductDetails() {
DecimalFormat df = new DecimalFormat("#.##");
System.out.println("Product Name: " + name);
System.out.println("Price: $" + df.format(price));
}
}
// Subclass representing an Electronics Product
class ElectronicsProduct extends Product {
private double discountPercentage;
public ElectronicsProduct(String name, double price, double discountPercentage) {
super(name, price);
this.discountPercentage = discountPercentage;
}
// Override the applyDiscount method to calculate electronics discount
@Override
public void applyDiscount() {
double discountAmount = price * discountPercentage / 100;
price -= discountAmount;
System.out.println("Discount applied: $" + discountAmount);
}
// Override the displayProductDetails method to include discount percentage
@Override
public void displayProductDetails() {
super.displayProductDetails();
System.out.println("Discount Percentage: " + discountPercentage + "%");
}
}
// Subclass representing a Clothing Product
class ClothingProduct extends Product {
private int quantity;
public ClothingProduct(String name, double price, int quantity) {
super(name, price);
this.quantity = quantity;
}
// Override the applyDiscount method to calculate clothing discount
@Override
public void applyDiscount() {
// Clothing products get a discount of $5 per item if quantity is 3 or more
if (quantity >= 3) {
double discountAmount = 5 * quantity;
price -= discountAmount;
System.out.println("Discount applied: $" + discountAmount);
} else {
System.out.println("No discount applied.");
}
}
// Override the displayProductDetails method to include quantity
@Override
public void displayProductDetails() {
super.displayProductDetails();
System.out.println("Quantity: " + quantity);
}
}
public class ECommerceSystem {
public static void main(String[] args) {
// Create an electronics product and a clothing product
ElectronicsProduct laptop = new ElectronicsProduct("Laptop", 800.0, 10.0);
ClothingProduct tShirt = new ClothingProduct("T-Shirt", 20.0, 5);
// Apply discounts to the products
laptop.applyDiscount();
tShirt.applyDiscount();
// Display product details
System.out.println("Product Details:");
laptop.displayProductDetails();
tShirt.displayProductDetails();
}
}
