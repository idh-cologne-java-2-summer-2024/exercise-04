package idh.java;

public class AccountIterator implements Iterator<Accounts> {
	
	private Account[] accounts; 
	private int position; 
	
	public AccountInterator(Account[] accounts ) {
		this.accounts = accounts;
		position= 0; 
	}

	public boolean hasNext () {
		
		return position < accounts.length; 
		
	}
	
	public Account next () {
		Account returnAccount = accounts [position]; 
		position++; 
		
		return returnAccount ;
				
	
	}}


