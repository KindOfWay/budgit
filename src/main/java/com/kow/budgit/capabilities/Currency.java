package com.kow.budgit.capabilities;

public class Currency implements ICurrency {
	private Integer amount;

	@Override
	public void set(int rhs) {
		amount = rhs;
	}

	@Override
	public int get() {
		return amount;
	}
	

}
