package idh.java;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Bank implements Iterable<Account> {
    private List<Account> accounts;

    public Bank() {
        accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public Account getAccountById(int id) {
        for (Account account : accounts) {
            if (account.getId() == id) {
                return account;
            }
        }
        return null; // Return null if account with given id is not found
    }

    @Override
    public Iterator<Account> iterator() {
        return accounts.iterator();
    }
}