package idh.java;

import java.util.Iterator;

public class AccountIterator implements Iterator<Account>{
	Bank bank;
	int currentPosition = -1;
	
	public AccountIterator(Bank bank) {
		this.bank = bank;
	}
	
	public boolean hasNext() {
		return currentPosition < bank.getSize() - 1;
	}
	public Account next() {
		currentPosition++;
		return bank.getAccountBank(currentPosition);
	}
}
