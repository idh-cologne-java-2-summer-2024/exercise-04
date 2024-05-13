package idh.java;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;

public class Bank implements Iterable<Account> {
    private List<Account> accounts;

    public Bank() {
        this.accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    @Override
    public Iterator<Account> iterator() {
        return new AccountIterator();
    }

    private class AccountIterator implements Iterator<Account> {
        private int currentIndex;

        public AccountIterator() {
            this.currentIndex = 0;
        }

        
        @Override
        public boolean hasNext() {
            return currentIndex < accounts.size();
        }

        
        @Override
        public Account next() {
            return accounts.get(currentIndex++);
        }
    }
}

