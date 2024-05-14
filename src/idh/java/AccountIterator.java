package idh.java;
import java.util.Iterator;

public class AccountIterator implements Iterator<Account> {

	
	public Account [] accounts;
	int currentPosition;
	
	public AccountIterator(Account[] accounts) {
		this.accounts = accounts;
		int currentPosition = 0;
	}
	



	@Override
	public boolean hasNext() {
		return currentPosition < accounts.length;
	}

	@Override
	public Account next() {
		Account returnAccount = accounts[currentPosition];
		return null;
	}

	
	
}
