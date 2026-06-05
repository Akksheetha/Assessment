package Assessment2;

class Account{
	int accountId;
	double balance;
	Customer c;
	Account(int accountId, Customer c, double balance){
		this.accountId = accountId;
		this.c = c;
		this.balance = balance;
	}
	void displayAccount() {
		System.out.println("ACCOUNT_ID : "+accountId);
		c.displayCustomer();
		System.out.println("ACCOUNT_BALANCE : "+balance);
	}
}
public class Details {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
}
