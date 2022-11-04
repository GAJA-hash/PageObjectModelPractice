package com.infi.VBank.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.infi.VBank.Utilities.Util_lib;
import com.infi.VBank.base.TestBase;
/*Whatever pages we use in our project are converted to page class. All elements inside the page are identified and made it as a web element here.
Each element is identified by "@FindBy" annotation. Using "PageFactory.initElements" I initialize the value to the driver and start converting mehtods.
*/
public class LoginPage extends TestBase
{
	@FindBy(xpath="//p[text()='Username : Admin']")
	WebElement usercredentials;
	
	@FindBy(css="#logInPanelHeading")
	WebElement loginpanelHeading;
	
	@FindBy(css="#txtUsername")
	public WebElement usernameTextbox;
	
	@FindBy(css="#txtPassword")
	public WebElement passwordTextbox;
	
	@FindBy(name="Submit")
	public WebElement loginBtn;
	
	@FindBy(xpath="//a[text()='Forgot your password?']")
	WebElement forgotPassword;
	
	@FindBy(id="welcome")
	public WebElement Welcomemsg;
	
	
	@FindBy(xpath="//a[text()='Logout']")
	
	public WebElement Logoutbtn;
	
	
	
	public LoginPage()
	{
		super();
		
		PageFactory.initElements(driver, this);//To initialize the value to the driver 
	}

	
	public String verifyUsercredentials()//Storing user credentials as a String. This will be asserted in Test_Script.java
	{
		return Util_lib.getText(usercredentials);
	}
	
	public boolean verifyUsercredentialsDisplay()
	{
		return Util_lib.isDisplay(usercredentials);
	}
	
	public String verifyLoginPanelSpellcheck()
	{
		return Util_lib.getText(loginpanelHeading);
	}
	
	public boolean verifyLoginPanelDisplay()
	{
		return Util_lib.isDisplay(loginpanelHeading);
	}
	
	public void Login()
	{
		usernameTextbox.sendKeys(pro.getProperty("username"));//Important function that we don't use UN and Pwd directly, instead we use through config.properties
		
		passwordTextbox.sendKeys(pro.getProperty("password"));
		
		loginBtn.click();
	}
	
	
	
	
	
}
