package com.uks.varad.core.day4.assignment4;

interface IWork{
	void doWork();
}

interface IReport{
	void reportToSenior();
}

abstract class BaseEmployee implements IWork,IReport {
	 String firstName,lastName,empType,basicSalary;
	 public abstract void doWork();
	 public abstract void reportToSenior();

}