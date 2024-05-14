package idh.java;

import java.util.Iterator;

public class AccountIterator implements Iterator<Account>{

	    	Bank bank; 
	    	int c=0;
	    	
			AccountIterator(Bank bank) {
				this.bank=bank; 
			}
			
			public boolean hasNext() {
		
					return c< bank.size()-1; 	
			}

			public Account next() {
				c++;
				return bank.getAccount(c) ;
			}
	    	
	    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
