package com.uks.varad.core.day4.assignment4;

public class TestTLEmployee {
	public static void main(String[] args) {
		IWork PL1 = null,TL1;
		IReport PL2,TL2;
		PLEmployee pLEmployee = new PLEmployee("Alex", "Richard");
		pLEmployee = (PLEmployee) PL1;
		new TLEmployee("Alex","Richard").doWork();
	}
}