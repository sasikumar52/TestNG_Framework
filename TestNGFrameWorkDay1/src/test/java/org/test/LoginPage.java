package org.test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.utility.baseclass.BaseClass;

public class LoginPage extends BaseClass {
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "email")
	private WebElement txtEmail;
	
	@FindBy(id = "pass")
	private WebElement txtPassWord;
	
	@FindBy(xpath = "//button[@type='submit']")
    private	WebElement btnLogin;

	public WebElement getTxtEmail() {
		return txtEmail;
	}

	public WebElement getTxtPassWord() {
		return txtPassWord;
	}

	public WebElement getBtnLogin() {
		return btnLogin;
	}
	
	public void login(String emailId,String password)
	{
		elementSendKeys(txtEmail, emailId);
		elementSendKeys(txtPassWord, password);
		elementClick(btnLogin);
	}

}
