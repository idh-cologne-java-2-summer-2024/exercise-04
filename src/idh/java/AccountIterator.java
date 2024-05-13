package idh.java;
import java.util.Iterator;

public class AccountIterator implements Iterator<Account> {

	
	ATM atm;
	
	int currentPosition = -1;
	


	@Override
	public boolean hasNext() {
		return currentPosition < atm.size() - 1;
	}

	@Override
	public Account next() {
		currentPosition++;
		return atm.getAccount(currentPosition);
	}

	
	
}
