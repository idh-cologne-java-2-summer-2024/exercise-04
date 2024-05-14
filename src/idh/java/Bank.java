package idh.java;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Bank implements Iterable<Account>{
    private List<Account> accounts;

    public Bank() {
        this.accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public List<Account> getAccounts() {
        return accounts;
    }
    
    @Override
    public Iterator<Account> iterator() {
    	return accounts.iterator();
    }
}
