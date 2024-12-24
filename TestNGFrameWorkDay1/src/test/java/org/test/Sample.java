package org.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.utility.baseclass.BaseClass;

public class Sample extends BaseClass {
	@BeforeClass
	private void beforeClass() {
		chromeBrowserLaunch();
		maximizeWindow();
		enterApplnUrl("https://omrbranch.com/");
		implicitWait();
	}
	@AfterClass
	private void afterClasss() {
		closeBrowser();
	}	
	
	@Parameters({"userName","passWord"})
	@Test
	private void login(String username,String password) {
		LoginPage loginPage=new LoginPage();
		loginPage.login(username,password);
		
	}

}
