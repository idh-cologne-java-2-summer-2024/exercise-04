package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {
    int cash = 100;
    Bank bank;

    public ATM(Bank bank) {
        this.bank = bank;
    }

    public void cashout(int accountId, int amount) {
        // Zuerst überprüfen wir, ob das Konto existiert
        boolean accountFound = false;
        for (Account account : bank) {
            if (account.getId() == accountId) {
                accountFound = true;
                // Überprüfen, ob der angeforderte Betrag die maximale abhebbare Summe überschreitet
                if (amount > account.getMaxWithdrawal()) {
                    System.out.println("Sorry, you can't withdraw more than " + account.getMaxWithdrawal());
                    return;
                }
                // Überprüfen, ob der angeforderte Betrag die aktuelle Kontostands übersteigt
                if (amount > account.getBalance()) {
                    System.out.println("Sorry, you're out of money.");
                    return;
                }
                // Überprüfen, ob genügend Bargeld im Automaten verfügbar ist
                if (amount > cash) {
                    System.out.println("Sorry, not enough cash left.");
                    return;
                }
                // Abheben des Betrags vom Konto und vom Bargeld im Automaten
                account.withdraw(amount);
                cash -= amount;
                System.out.println("Ok, here is your money, enjoy!");
                return;
            }
        }
        // Falls das Konto nicht gefunden wurde
        if (!accountFound) {
            System.out.println("Sorry, this account doesn't exist.");
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

    public static void main(String[] args) {
        Bank bank = new Bank(); 
        bank.addAccount(new Account(1, 500, 500));
        bank.addAccount(new Account(2, 1000, 1000));

        ATM atm = new ATM(bank); 
        atm.run();
    }
}
