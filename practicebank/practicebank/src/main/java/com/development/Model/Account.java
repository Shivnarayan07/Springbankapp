package com.development.Model;

import java.util.Optional;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity

public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Acc_id;
	private int accountNumber;
	private Long balance;
	private Long u_Id;
	@OneToOne
	private User user;
	public Long getAcc_id() {
		return Acc_id;
	}
	public void setAcc_id(Long acc_id) {
		Acc_id = acc_id;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public Long getBalance() {
		return balance;
	}
	public void setBalance(Long balance) {
		this.balance = balance;
	}
	public Long getU_Id() {
		return u_Id;
	}
	public void setU_Id(Long u_Id) {
		this.u_Id = u_Id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public Account() {}
	public Account(Long acc_id, int accountNumber, Long balance, Long u_Id, User user) {
	
		Acc_id = acc_id;
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.u_Id = u_Id;
		this.user = user;
	}
	
	
	
}
