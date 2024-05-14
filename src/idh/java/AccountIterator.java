
	package idh.java;

	import java.util.Iterator;
	import java.util.NoSuchElementException;

	public class AccountIterator implements Iterator<Account> {
	    private Account[] accounts;
	    private int currentIndex = 0;

	    public AccountIterator(Account[] accounts) {
	        this.accounts = accounts;
	    }

	    @Override
	    public boolean hasNext() {
	        return currentIndex < accounts.length && accounts[currentIndex] != null;
	    }

	    @Override
	    public Account next() {
	        if (!hasNext()) {
	            throw new NoSuchElementException("No more accounts.");
	        }
	        return accounts[currentIndex++];
	    }

	    @Override
	    public void remove() {
	        throw new UnsupportedOperationException("Remove operation is not supported.");
	    }
	}

