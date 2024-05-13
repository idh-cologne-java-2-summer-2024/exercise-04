package idh.java;

import java.util.Iterator;



public class AccountIterator implements Iterator<Account>{


	   Bank bank;
	    int currentPosition = -1; // i

	    public AccountIterator(Bank bank) {
		this.bank = bank;
	    }

	    @Override
	    public boolean hasNext() {
		return currentPosition < bank.size() - 1;
	    }

	    @Override
	    public Account next() {
		currentPosition++;
		return bank.getAcc(currentPosition);
	    }

}
