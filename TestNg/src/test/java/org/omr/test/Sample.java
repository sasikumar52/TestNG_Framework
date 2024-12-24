package org.omr.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Sample extends BaseClass {
	
	@BeforeClass
	private void beforeClasss() {
	
		chromeBrowserLaunch();
		maximizeWindow();
		enterApplnUrl("https://omrbranch.com/");
		implicitWait();

	}
	@AfterClass
	private void afterClasss() {

		//closeBrowser();
	}
	
	@Parameters({"userName","passWord"})
	@Test
	private void loginn(String username, String pass) {
		LoginPage loginPage=new LoginPage();
		loginPage.login(username, pass);

	}

}
