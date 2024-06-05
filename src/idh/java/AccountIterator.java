package idh.java;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class AccountIterator implements Iterator<Account> {
    private Account[] accounts;
    private int position = 0;

    public AccountIterator(Account[] accounts) {
        this.accounts = accounts;
    }

    @Override
    public boolean hasNext() {
        return position < accounts.length && accounts[position] != null;
    }

    @Override
    public Account next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return accounts[position++];
    }
}
