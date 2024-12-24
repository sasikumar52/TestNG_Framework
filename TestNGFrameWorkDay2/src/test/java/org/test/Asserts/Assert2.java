package org.test.Asserts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.utility.baseclass.BaseClass;
//SOft Assert

public class Assert2 extends BaseClass {
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
	@Test
	private void loginn() {
		
		SoftAssert softAssert=new SoftAssert();
		
		softAssert.assertTrue(getApplnCurrentUrl().contains("braaaaanch"),"verify URL");
		softAssert.assertEquals(getApplnTitle(),"ThoraipakkamOMRBranchjjdjs", "Verify Tite");
		
		LoginPage page=new LoginPage();
		page.login("sasimathiru97@gmail.com", "Sasi@123");
		
		//To Highlight assert Failure
		softAssert.assertAll();
		
	}
	
}
