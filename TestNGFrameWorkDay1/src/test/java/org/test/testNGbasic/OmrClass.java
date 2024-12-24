package org.test.testNGbasic;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.utility.baseclass.BaseClass;

public class OmrClass extends BaseClass {
	@BeforeClass
	private void beforeClass() {
		chromeBrowserLaunch();
		maximizeWindow();
		enterApplnUrl("https://omrbranch.com/");
		implicitWait();
	}
	@AfterClass
	private void afterClass() {
		closeBrowser();
	}
	@BeforeMethod
	private void beforeMethod() {

		System.out.println("Start time:"+System.currentTimeMillis());
	}
	@AfterMethod
	private void aftermethod() {
		System.out.println("End time:"+System.currentTimeMillis());
	}
	@Test
	private void login() {
		LoginPage loginPage=new LoginPage();
		loginPage.login("sasimathiru97@gmail.com", "Sasi@123");

	}

}
