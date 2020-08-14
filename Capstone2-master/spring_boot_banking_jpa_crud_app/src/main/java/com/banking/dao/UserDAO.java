package com.banking.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banking.model.SavingsAccount;
import com.banking.model.User;
@Repository
public interface UserDAO extends JpaRepository<User, Integer>{
	
	public User findByUsername(String username);
	
	public User findBySavingsAccount(SavingsAccount savingsAccount);
 

}
