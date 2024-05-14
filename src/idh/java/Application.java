package idh.java;

public class Application {
	public static void main(String[] args) {

		Account[] accArr = new Account[10];
		for (int i = 0; i < accArr.length; i++) {
			accArr[i] = new Account(i, 100);}

		AccountIterator iter = new AccountIterator(accArr);

		while (iter.hasNext()) {
			System.out.println(iter.next());}
		
		Bank bank = new Bank(250);

		for (Account account : bank) {
			System.out.println(account);}}}