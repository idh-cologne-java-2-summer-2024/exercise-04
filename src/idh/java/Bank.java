package idh.java;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Class representing a bank. (WiP)
 * Each bank-object should come with a name and a (Array-)list of accounts.
 * @apiNote The Class also contains an Iterator for accounts belonging to the bank to iterate over user accounts, though I am unsure of how to make use of that.
 */
public class Bank implements Iterable<Account>{
	String name;
	ArrayList <Account>accs = new ArrayList<Account>();
	Iterator<Account> bIt = accs.iterator();
	
	public Bank(String name, ArrayList <Account>accs) {
		this.name = name;
		int j = 0;
		while(bIt.hasNext() && j<=5) {
			accs.add(j,accs.get(j));
			j++;
		}
	}

	/**
	 * Bank Class method which returns an <b>Account</b>-iterator
	 * to iterate over accounts of one specific bank.
	 */
	@Override
	public Iterator<Account> iterator() {
		// TODO Auto-generated method stub
		return accs.iterator();
	}



}
