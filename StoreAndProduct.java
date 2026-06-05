package questions;
import java.util.*;
public class StoreAndProduct {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		 ArrayList<Product> list = new ArrayList<>();
	        list.add(new Product(101, "iphone10", "Mobile", 20000, 0.2, 2));
	        list.add(new Product(103, "iphone13", "Mobile", 10000, 0.5, 1));
	        list.add(new Product(105, "iphone12", "Mobile", 50000, 0.5, 6));
	        list.add(new Product(102, "Dell", "Laptop", 20000, 0.3, 4));
	        list.add(new Product(104, "Lenovo", "Laptop", 70000, 0.8, 3));
	        while (true) {
	            System.out.println("\n1. Sort by Id");
	            System.out.println("2. List Devices with price more than 40000");
	            System.out.println("3. Exit");
	            System.out.print("Enter option: ");
	            int choice = sc.nextInt();
	            switch (choice) {
	                case 1:
	                    Collections.sort(list);
	                    for (Product p : list) {
	                        p.display();
	                    }
	                    break;
	                case 2:
	                    for (Product p : list) {
	                        if (p.productPrice > 40000) {
	                            p.display();
	                        }
	                    }
	                    break;
	                case 3:
	                    System.out.println("Exiting...");
	                    return;
	}
	        }
	}
}

class Product implements Comparable<Product> {
    int productId;
    String productName;
    String productCategory;
    double productPrice;
    double productDiscount;
    int productQuantity;
    Product(int id, String name, String category, double price, double discount, int quantity) {
        this.productId = id;
        this.productName = name;
        this.productCategory = category;
        this.productPrice = price;
        this.productDiscount = discount;
        this.productQuantity = quantity;
    }
    public int compareTo(Product p) {
        return this.productId-p.productId;
    }
    public void display() {
        System.out.println(productId + " | " + productName + " | " + productCategory + " | " + productPrice + " | " + productDiscount + " | " + productQuantity);
    }
}
