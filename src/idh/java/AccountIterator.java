package idh.java;
import java.util.Iterator;

public class AccountIterator implements Iterator<Account>{

	private int currentIndex;
	private Account[] accounts;

	public AccountIterator(Account[] accounts) {
		this.accounts = accounts;
		this.currentIndex = 0;
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Account next() {
		// TODO Auto-generated method stub
		return null;
	}

}
