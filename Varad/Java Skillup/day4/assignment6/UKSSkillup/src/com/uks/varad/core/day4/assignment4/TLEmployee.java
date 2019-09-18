package com.uks.varad.core.day4.assignment4;

public class TLEmployee extends PLEmployee{
	TLEmployee(String fN, String lN) {
		super(fN, lN);
	}
	@Override public void doWork() { assignTaskToJunior(); collectReportFromJunior(); reportToSenior();  }

	private void assignTaskToJunior(){ System.out.println("TL Employee Assigning task to junior");}
	private void collectReportFromJunior(){ System.out.println("TL Employee Collect Report From Junior");}
	public void reportToSenior(){ System.out.println("TL Employee Report To Senior " + firstName +" "+lastName);}

}
