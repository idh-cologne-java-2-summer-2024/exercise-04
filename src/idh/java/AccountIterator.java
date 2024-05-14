
	package idh.java;

	import java.util.Iterator;
	import java.util.NoSuchElementException;

	public class AccountIterator implements Iterator<Account> {
	    private Account[] accounts;
	    private int currentIndex = 0;

	    public AccountIterator(Account[] accounts) {
	        this.accounts = accounts;
	    }

	   
	    public boolean hasNext() {
	        return currentIndex < accounts.length && accounts[currentIndex] != null;
	    }

	    
	    public Account next() {
	        if (!hasNext()) {
	            throw new NoSuchElementException("No more accounts.");
	        }
	        return accounts[currentIndex++];
	    }

	
	    public void remove() {
	        throw new UnsupportedOperationException("Remove operation is not supported.");
	    }
	}

