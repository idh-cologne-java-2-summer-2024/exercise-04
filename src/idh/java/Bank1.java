package idh.java;

import java.util.Iterator;

public class Bank implements Iterable<Account> {
	private Account[] accounts;

	public Bank(int size) {
		accounts = new Account[size];
	}

	public Bank() {
		accounts = new Account[50];
	}

	public void init() {
		for (int i = 0; i < accounts.length; i++) {
			accounts[i] = new Account(i, 50);}}

	public Iterator<Account> iterator() {
		return new AccountIterator(accounts);}}