package com.uks.varad.jdbc.day02.assignment2;

/**
 * @author: Varad Paralikar
 *  Created Date:2019/07/24
 *  Assignment: Day 2 assignment2
 *  Task: JDBC
 */

/*
 * Class SalesByCatData contains fields and methods required to implement table data returned from procedure
 * execution.
 *
 * @author: Varad Parlikar
 * Created Date: 2019/07/24
 */
public class SalesByCatData {
	private String productName;
	private Double totalPurchase;

	//parameterised constructor
	public SalesByCatData(String productName, String totalPurchase) {
		this.productName = productName;

		if(totalPurchase == null){
			this.totalPurchase = (double) 0;
		}
		else{
			this.totalPurchase = Double.parseDouble(totalPurchase);
		}

	}

	/*
	 * method getProductName returns productName.
	 * return type : String
	 */
	public String getProductName() {
		return productName;
	}

	/*
	 * method setProductName sets productName.
	 * @String productName which is to be set
	 * return type : void
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/*
	 * method getTotalPurchase returns totalPurchase.
	 * return type : Double
	 */
	public Double getTotalPurchase() {
		return totalPurchase;
	}

	/*
	 * method setTotalPurchase sets totalPurchase.
	 * @String totalPurchase which is to be set
	 * return type : void
	 */
	public void setTotalPurchase(Double totalPurchase) {
		this.totalPurchase = totalPurchase;
	}

}
