package idh.java;
import java.util.Iterator;

public class Bank implements Iterable <Account> {
	int bankID; 
	Account[] customers; 
	
	Bank(int id, Account[] customers){
		this.bankID=id; 
		this.customers=customers;
	}
	
	public Account getAccount(int position) {
		return this.customers[position];
	}
	
	public int getAccountId(int account) {
		return customers[account].id;
	}                            
	
	public int getBalance(int account) {
		return customers[account].balance;
	}                            
	
	public int size() {
		return this.customers.length;
	}

	public static void main(String[] args) {
		
	}



	@Override
	public Iterator<Account> iterator() {
		return new AccountIterator(this) ;
	}

}
