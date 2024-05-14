package idh.java;

import java.util.Iterator;


public class AccountIterator implements Iterator<Account> {

    private Account[] accounts;
    private int currentIndex;

    public AccountIterator(Account[] accounts) {
        this.accounts = accounts;
        this.currentIndex = 0;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < accounts.length;
    }

    @Override
    public Account next() {
        return accounts[currentIndex++];
    }

}