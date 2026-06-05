package questions;
import java.util.*;
public class BankingTransactionValidator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
abstract class BankTransactionException extends Exception {
	String message;
    int errorCode;

    public BankTransactionException(String message, int code) {
        this.message = message;
        this.errorCode = code;
    }

    public int getErrorCode() {
        return errorCode;
    }
}
class InsufficientFundsException extends BankTransactionException {

	double shortfall;

	public InsufficientFundsException(String message, int code, double shortfall) {
        super(message, code);
        this.shortfall = shortfall;
    }

}
