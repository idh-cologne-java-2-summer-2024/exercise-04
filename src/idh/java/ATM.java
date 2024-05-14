package idh.java;

import java.io.BufferedReader;
import java.util.Iterator;
import java.io.InputStreamReader;
import java.util.Random;

public class ATM {

    // initial cash in the ATM
    int cash = 100;
    Bank[] bankNetwork=new Bank[4];
    Bank atmBank;

   
    public ATM(int bankId) {
    	Account[] bankAccounts= new Account[4];
		bankAccounts[0]=  new Account(1234, 5000); 
	    bankAccounts[1] = new Account(9876, 20000); 
		bankAccounts[2] = new Account(7654, 50); 
		bankAccounts[3] = new Account(4321, 966745656);
	    
		bankNetwork[0]= new Bank(3412, bankAccounts);
		bankNetwork[1]= new Bank(1204, bankAccounts);
		bankNetwork[2]= new Bank(1254, bankAccounts);
		bankNetwork[3]= new Bank(1234, bankAccounts);
    	
    	
    	for(int i=0; i<bankNetwork.length; i++) {
    		if (bankId==bankNetwork[i].bankID) {
    			this.atmBank=bankNetwork[i];
    		}
    	}
    }
    	


    
    /**
     * Main command loop of the ATM Asks the user to enter a number, and passes this
     * number to the function cashout(...) which actually does the calculation and
     * produces money. If the user enters anything else than an integer number, the
     * loop breaks and the program exists
     */
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
	// check for cash in the ATM
	if (amount > cash) {
	    System.out.println("Sorry, not enough cash left.");
	    return;
	}
			
	for (Account account:this.atmBank) {
		
		if( accountNumber== account.getId()) {}
			if (amount > account.getBalance()) {
			    System.out.println("Sorry, you're out of money.");
			    return;
			}
		    else {
			    account.withdraw(amount);
				cash += amount;
				System.out.println("Ok, here is your money, enjoy!");
				return;
		    }
		}		
				
		System.out.println("Sorry, this account does not exists.");
		return; 
	}

    /**
     * Launches the ATM
     */
    public static void main(String[] args) {
    	
	
	ATM atm = new ATM(1234);
	atm.run();
	 
			
		}
    }

