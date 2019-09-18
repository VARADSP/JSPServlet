package com.uks.varad.core.day4.assignment4;

public class PLEmployee extends BaseEmployee {
	String mobileNumber;
	PLEmployee(String fN,String lN) { firstName = fN; lastName = lN; empType = "PL"; mobileNumber = "+918830468766"; }

	@Override public void doWork() { assignTaskToJunior(); collectReportFromJunior(); reportToSenior();  }

	private void assignTaskToJunior(){ System.out.println("Assigning task to junior");}
	private void collectReportFromJunior(){ System.out.println("Collect Report From Junior");}
	public void reportToSenior(){ System.out.println("Report To Senior " + firstName +" "+lastName);}
}