package idh.java;

import java.util.Iterator;														//Es kommen mehrfach zwei Fehlermeldungen in der Konsole für Zeile 20 in ATM und Zeile 16 in Account. Dadurch, dass ich keine Ausgabe in der Konsole habe kann ich nicht wirklich wissen was ich ändern muss und ich habe jetzt lange ohne zu Wissen was falsch ist rumprobiert ohne Erfolg. 

public class AccountIterator extends ATM implements Iterator<Account> {
	
	Account account;
	int currentPosition = -1;
	int accountamount = accounts.length;
	
	public AccountIterator(Account account) {
		this.account = account;
	}

	public boolean hasNext() {
	
		return currentPosition < accountamount -1;
	}

	public Account next() {
		currentPosition++;
		return account.getAccount(currentPosition);
	}
	
AccountIterator iter = new AccountIterator(accounts[currentPosition]);{
		
		while (iter.hasNext()) {
		    getAccount(currentPosition);
			
		}

}}

