package idh.java;

import java.util.Iterator;

public class Bank implements Iterable<Account>{

	Account [] accounts;
	
	public Bank (int size) {
		accounts = new Account [size];
	}
	
	@Override
	public Iterator<Account> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
