package idh.java;

import java.util.Iterator;

public class AccountIterator implements Iterator<Account> {

	private Account[] accounts;

	private int pos;

	public AccountIterator(Account[] accounts) {
		this.accounts = accounts;
		pos = 0;}

	public boolean hasNext() {
		return pos < accounts.length;}

	public Account next() {
		Account returnAccount = accounts[pos];
		pos++;
		return returnAccount;}}