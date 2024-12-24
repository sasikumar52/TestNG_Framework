package org.test.Asserts;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.utility.baseclass.BaseClass;

//Hard Asser
public class Assert1 extends BaseClass  {

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
		Assert.assertTrue(getApplnCurrentUrl().contains("branch"),"verify URL");
		Assert.assertEquals(getApplnTitle(),"Thoraipakkam OMR Branch", "Verify Tite");
		
		LoginPage page=new LoginPage();
		page.login("sasimathiru97@gmail.com", "Sasi@123");
		
	}
	
	
}
