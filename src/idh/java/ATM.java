package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class ATM {
    int cash = 100;
    Account[] accounts = new Account[5];

    public ATM() {
        Random random = new Random();
        for (int i = 0; i < accounts.length; i++) {
            accounts[i] = new Account(i, random.nextInt(1000));
        }
    }

    public void run() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                System.out.print("Enter your account number: ");
                int accountNumber = Integer.parseInt(br.readLine());
                System.out.print("Enter the amount to withdraw: ");
                int amount = Integer.parseInt(br.readLine());
                cashout(accountNumber, amount);
            } catch (Exception e) {
                e.printStackTrace();
                break;
            }
        }
    }

    public void cashout(int accountNumber, int amount) {
        if (amount > cash) {
            System.out.println("Sorry, not enough cash left.");
            return;
        }

        Account account = getAccount(accountNumber);
        if (account == null) {
            System.out.println("Sorry, this account doesn't exist.");
            return;
        }

        if (amount > account.getBalance()) {
            System.out.println("Sorry, you're out of money.");
            return;
        }

        account.withdraw(amount);
        cash -= amount;
        System.out.println("Ok, here is your money, enjoy!");
    }

    protected Account getAccount(int id) {
        AccountIterator iterator = new AccountIterator(accounts);
        while (iterator.hasNext()) {
            Account account = iterator.next();
            if (account.getId() == id) {
                return account;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.run();
    }
}