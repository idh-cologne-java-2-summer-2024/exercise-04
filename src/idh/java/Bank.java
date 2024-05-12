package idh.java;

import java.util.Iterator;

public class Bank implements Iterable <Account>{
	
	String name;
	int number = 0;
	Account[] accounts = new Account[10];
	 
	 public Bank (String name) {
		 this.name = name;
	 }
	 
	 public int getSize() {
		 return accounts.length;
	 }
	 
	 public void addAccount(Account account) {
		 if (number < accounts.length) {
			 accounts[number] = account;
			 number++;
		 }
	 }
	 public Account getAccountBank(int number) {
		 return accounts[number];
	 }
		public Iterator<Account> iterator() {
			return new AccountIterator(this);
			}
}
