package com.monkata.users.Entity;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.Data;

@Data
public class Loans implements Serializable {
	
	  private Long id;
	  private Long customerId;
	  private String type_loan;
	  private double somme;
	  private LocalDate date_created;

}
