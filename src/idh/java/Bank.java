package idh.java;

import java.util.Iterator;

public class Bank implements Iterable<Account>{

		Account[] accounts;
		
		public Bank(int size) {
			accounts = new Account[size];
			init();
		}

		public Bank() {
		accounts = new Account[100];
		init();
}
		
		@Override
		public Iterator<Account> iterator() {
			// TODO Auto-generated method stub
			return new AccountIterator(accounts);
		}
		
		
		
		
		//Bank bank = new Bank(250);
		//for(Account account : bank) {
			
		//}
		
		//Iterator<Account> iter1 = bank.iterator();
		
		//while(iter1.hasNext()) {
		//	Account a = iter1.next();
		//}
		
		public void init()		 {
			for(int i = 0; i < accounts.length; i++)	{
				accounts[i] = new Account(i, 100);
			}}
}
