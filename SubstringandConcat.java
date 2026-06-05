package questions;
import java.util.Scanner;
public class SubstringandConcat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a String : ");
		String str = sc.nextLine();
		if(str.length()>2) {
			System.out.println((char)str.charAt(0)+(char)str.charAt(1));
		}
		else if(str.length()==2) {
			System.out.println(str.charAt(0));
		}
		else if(str.length()==1){
			System.out.println((char)str.charAt(0)+"@");
		}
		else {
			System.out.println("@@");
		}
	}

}
