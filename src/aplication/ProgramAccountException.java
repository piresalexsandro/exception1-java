package aplication;

import java.util.Locale;
import java.util.Scanner;

import model.entities.AccountException;
import model.exceptions.DomainException;

public class ProgramAccountException {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("Enter account data");
			System.out.print("Number.........: ");
			Integer number = sc.nextInt();
			System.out.print("Holder.........: ");
			String holder = sc.next();
			System.out.print("Initial balance: ");
			Double balance = sc.nextDouble(); 
			System.out.print("Withdraw limit.: ");		
			Double withdrawLimit = sc.nextDouble();
			System.out.println();
			System.out.print("Enter amount for withdraw: ");
			Double amount = sc.nextDouble();
			
			AccountException acex = new AccountException(number, holder, withdrawLimit, balance);
			acex.withdraw(amount);
			acex.balance(amount);
			System.out.println(acex);
		}	
		catch(DomainException e) {
			System.out.println("Withdraw error: " + e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("Unexpected error");
		}
	}
}
