package idh.java;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

public class Bank implements Iterable<Account> {
    private Account[] accounts;

    public Bank(int numberOfAccounts) {
        accounts = new Account[numberOfAccounts];
        Random random = new Random();
        for (int i = 0; i < accounts.length; i++) {
            accounts[i] = new Account(i, random.nextInt(1000));
        }
    }

    @Override
    public Iterator<Account> iterator() {
        return new AccountIterator();
    }

    private class AccountIterator implements Iterator<Account> {
        private int position = 0;

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

    public Account getAccount(int id) {
        for (Account account : this) {
            if (account.getId() == id) {
                return account;
            }
        }
        return null;
    }
}
