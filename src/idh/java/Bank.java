package idh.java;

import java.util.Random;
import java.util.Iterator;

public class Bank implements Iterable<Account>{
	
	Account[] accounts;
	 int nextPosition = 0;
	 
	 public Bank(int numberOfAccounts) 
	 {
		 
	 this.accounts = new Account[numberOfAccounts];
	 Random random = new Random();
	 for (int i = 0; i < accounts.length; i++) 
	 {
			
    accounts[i] = new Account(i, random.nextInt(1000));
	 
	 }
	 }
	 
	 public Account[] getAccounts()
	 {
		 return accounts;
	 }
	 
	 public int size() 
	 {
	 return accounts.length;
	 }

	 public Account getAcc(int account) {
	 return accounts[account];
	 }
     
	 
	       
	    
      public void addAccount(int id, int status) throws Exception {
	  if (nextPosition < accounts.length)
	    	
	  accounts[nextPosition++] = new Account(id,status);
	    	else
	    	    throw new Exception("Class full");
	        }
	 public String getDescription() {
	    	StringBuilder buf = new StringBuilder();
	    	buf.append(("ATM Management "+'\n'));
	    	    buf.append('-');
	    	buf.append('\n');
	    	buf.append("Accounts: ");
	    	buf.append(accounts);
	    	buf.append('\n');
	    	return buf.toString();
	        }
	 
	 


	@Override
	public Iterator<Account> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
}


