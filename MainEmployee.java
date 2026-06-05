package Assessment2;
import java.util.Scanner;
class Employee{
	int employeeId;
	String name;
	String designation;
	double salary;
	Employee(int employeeId, String name, String designation, double salary){
		this.employeeId = employeeId;
		this.name = name;
		this.designation = designation;
		this.salary = salary;
	}
	public void displayInfo(){
		System.out.println("Employee Id : "+employeeId);
		System.out.println("Employee Name : "+name);
		System.out.println("Employee Designation : "+designation);
		System.out.println("Employee Salary : "+salary);
	}
	public void increaseSalary(double percentage) {
		double increased_salary = salary+(salary*(percentage/100));
		System.out.println("Salary after increasing is "+increased_salary);
	}
	public void increaseSalary(double percentage, double bonus) {
		double increased_salary = salary+salary*(percentage/100)+bonus;
		System.out.println("Salary after increased with bonus is "+increased_salary);
	}
}
public class MainEmployee {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Employee ID : ");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.print("Enter Employee Name : ");
		String name = sc.nextLine();
		System.out.print("Enter Employee Designation : ");
		String designation = sc.nextLine();
		System.out.print("Enter Employee Salary : ");
		double salary = sc.nextDouble();
		Employee e = new Employee(id, name, designation, salary);
		e.displayInfo();
		System.out.print("Enter a increased salary percentage : ");
		double percentage = sc.nextDouble();
		e.increaseSalary(percentage);
		System.out.print("Enter the bonus : ");
		double bonus = sc.nextDouble();
		e.increaseSalary(percentage, bonus);
	}

}
