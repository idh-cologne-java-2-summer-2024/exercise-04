package idh.java;

import java.util.Iterator;
import java.util.Random;

public class Bank implements Iterable<Account> {

    Account[] accounts;

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
        private int currentIndex;

        public AccountIterator() {
            currentIndex = 0;
        }

        @Override
        public boolean hasNext() {
            return currentIndex < accounts.length && accounts[currentIndex] != null;
        }

        @Override
        public Account next() {
            return accounts[currentIndex++];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("remove() is not supported for AccountIterator");
        }
    }
}
