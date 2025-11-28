package com.mphasis;

public class NetBanking implements Payment {

private CashPayment cash = new CashPayment();
	
	@Override
	public void pay(double amount) {	
		System.out.println("User validated and authenticated");
		System.out.println("otp verification successfull");
		System.out.println("payment Successfull");
		cash.pay(amount);
	}

}
