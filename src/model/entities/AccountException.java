package model.entities;

import model.exceptions.DomainException;

public class AccountException {
	
	private Integer number;
	private String holder;
	private Double withdrawLimit;
	private Double balance;
	
	public AccountException(){
	}

	public AccountException(Integer number, String holder, Double withdraw, Double balance) {
		super();
		this.number = number;
		this.holder = holder;
		this.withdrawLimit = withdraw;
		this.balance = balance;
	}

	public Integer getnumber() {
		return number;
	}

	public void setnumber(Integer number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}

	public void setWithdrawLimit(Double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}
		
	public void withdraw(double amount) throws RuntimeException{
		if (amount > withdrawLimit) {
			throw new DomainException("The amount exceeds withdraw limit");
		} 
		else {
			if (amount > balance){
				throw new DomainException("Not enough balance");
			}
			
		}
	}
	
	public void balance(double amount) throws RuntimeException{
		balance -= amount;
	}
	
	public String toString() {
		return "New balance: " + String.format("%.2f", balance);
	}
}
