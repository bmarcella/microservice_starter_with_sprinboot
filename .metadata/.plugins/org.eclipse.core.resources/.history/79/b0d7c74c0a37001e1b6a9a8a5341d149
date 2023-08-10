package com.monkata.loans.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.monkata.loans.Entity.Loans;
import com.monkata.loans.repository.LoanRepository;

import lombok.Data;

@Service
public class LoanService implements ILoanService{
    @Autowired 
    LoanRepository loanRepository;
	@Override
	public List<Loans> getLoansByCustomerId(Long id) {
		return loanRepository.findByCustomerId(id);
	}
	public Loans save(Loans l) {
		return loanRepository.save(l);
	}
	@Override
	public List<Loans> findAll() {
		// TODO Auto-generated method stub
		return (List<Loans>) loanRepository.findAll();
	}

}

