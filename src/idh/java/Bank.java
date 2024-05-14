package idh.java;

import java.util.Iterator;


public class Bank extends AccountIterator implements Iterable<Account> {

	public Bank(Account account) {
		super(account);
		
	}



	Account[] accountspeicher;												//die Konsole gibt natürlich immer noch nur Fehler aus aber das war jetzt mein blinder Versuch an Aufgabe 2
	
	int nextposition = 0;
	
	
	
	public Iterator<Account> iterator() {
		
		for (Account account : accountspeicher) {
		    getAccount(account.getId());
		    
		}
	
		return new AccountIterator(account);
}}


