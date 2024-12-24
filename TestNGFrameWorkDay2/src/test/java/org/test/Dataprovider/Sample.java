package org.test.Dataprovider;

import org.test.Asserts.LoginPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.utility.baseclass.BaseClass;

//TestNg data provider integration in selenium

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
	@Test(dataProvider = "userData", dataProviderClass = Hello2.class)
	private void login(String userName,String passWord) {

		LoginPage loginPage=new LoginPage();
		loginPage.login(userName, passWord);
		
	}

}
