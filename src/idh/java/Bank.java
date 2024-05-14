package idh.java;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Bank implements Iterable<Account> {
    private List<Account> accounts;

    public Bank() {
        this.accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void removeAccount(Account account) {
        accounts.remove(account);
    }

    @Override
    public Iterator<Account> iterator() {
        return new AccountIterator(accounts);
    }

    private class AccountIterator implements Iterator<Account> {
        private int currentIndex = 0;
        private List<Account> internalAccounts;

        public AccountIterator(List<Account> accounts) {
            this.internalAccounts = accounts;
        }

        public boolean hasNext() {
            return currentIndex < internalAccounts.size();
        }

       
        public Account next() {
            return internalAccounts.get(currentIndex++);
        }
    }
}