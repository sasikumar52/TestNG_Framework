package org.test.testNGbasic;

import org.testng.annotations.Test;

public class Sample {
	
	@Test(priority = -12)
	private void loginn() {

	}
	@Test(priority = -1,enabled = false)
	private void searchProduct() {

	}
	@Test(invocationCount = 4)
	private void searchListingProduct() {

	}
	@Test(priority = 12)
	private void myCartPage() {

	}
	@Test(priority = 18)
	private void orderConfirmationPage() {

	}

}
