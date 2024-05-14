package idh.java;

import java.util.ArrayList;
//import java.util.Arrays;
import java.util.Iterator;

public class AccountIterator implements Iterator<Account> {
//	Account[] accs;
//	.size method only applicable for Collections thus the ArrayList here instead of a simple array --> unless one overwrites their own size method
	ArrayList<Account> accs = new ArrayList<Account>(); // would have been better to set this to private and call it via
														// a constructor

//	Account accs2[] = new Account[5];
	int pos = 0;

//	//Constructor --> like this?
//	public AccountIterator(ArrayList<Account> accs, int pos) {
//		this.accs = accs;
//		pos = 0;
//	}
//	
	/**
	 * Checks if an Account Array has another account at the next index position.
	 * 
	 * @return <b>true</b> if another account exists, <br>
	 *         <b>false</b> if not.
	 */
	@Override
	public boolean hasNext() {
		return pos <= accs.size();
//		return pos < Arrays.asList(accs2).size(); //this version does not need a list
	}

	@Override
	public Account next() {
		pos++;
		return accs.get(pos);
//		return accs2[pos]; //throws OutOfBoundaryException
	}

}
