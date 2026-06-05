package Assessment2;
import java.util.Scanner;
abstract class Product{
	int productId;
	String productName;
	double price;
	Product(int productId, String productName, double price){
		this.productId =  productId;
		this.productName = productName;
		this.price = price;
	}
	
	abstract void displayInfo();
}
class ElectronicProduct extends Product{
	int warrantyPeriod;
	ElectronicProduct(int productId, String productName, double price, int warrantyPeriod){
		super(productId, productName, price);
		this.warrantyPeriod = warrantyPeriod;
	}
	public int getWarrantyPeriod() {
		return warrantyPeriod;
	}
	public void displayInfo() {
		System.out.println("ELECTRONIC PRODUCT INFORMATION");
		System.out.println("Product ID : "+productId);
		System.out.println("Product Name : "+productName);
		System.out.println("Product Price : "+price);
		System.out.println("Product Warranty Period : "+warrantyPeriod);
	}
	
}
class ClothingProduct extends Product{
	char size;
	String material;
	ClothingProduct(int productId, String productName, double price, char size, String material) {
		super(productId, productName, price);
		// TODO Auto-generated constructor stub
		this.size = size;
		this.material = material;
	}
	public int getSize() {
		return size;
	}
	public String getMaterial() {
		return material;
	}
	public void displayInfo() {
		System.out.println("CLOTHING PRODUCT INFORMATION");
		System.out.println("Product ID : "+productId);
		System.out.println("Product Name : "+productName);
		System.out.println("Product Price : "+price);
		System.out.println("Size : "+size);
		System.out.println("Material : "+material);
	}
}
public class MainProduct {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Product p;
		System.out.println("Electronic Product");
		System.out.print("Enter Product ID : ");
		int id1 = sc.nextInt();
		sc.nextLine();
		System.out.print("Enter Product Name : ");
		String name1 = sc.nextLine();
		System.out.print("Enter Price : ");
		double price1 = sc.nextDouble();
		System.out.println("Enter Warranty period : ");
		int wp = sc.nextInt();
		p = new ElectronicProduct(id1,name1, price1, wp);
		System.out.println("Clothing Product");
		System.out.print("Enter Product ID : ");
		int id2 = sc.nextInt();
		sc.nextLine();
		System.out.print("Enter Product Name : ");
		String name2 = sc.nextLine();
		System.out.print("Enter Price : ");
		double price2 = sc.nextDouble();
		System.out.print("Enter Size : ");
		char size = sc.next().charAt(0);
		sc.nextLine();
		System.out.print("Enter Material : ");
		String material = sc.nextLine();
		Product obj;
		obj = new ClothingProduct(id2, name2, price2, size, material);
		p.displayInfo();
		obj.displayInfo();
	}

}

//modifying...
