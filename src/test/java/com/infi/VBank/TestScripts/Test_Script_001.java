package com.infi.VBank.TestScripts;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.infi.VBank.Pages.LoginPage;
import com.infi.VBank.Utilities.ExcelConfig;
import com.infi.VBank.Utilities.Util_lib;
import com.infi.VBank.base.TestBase;

public class Test_Script_001 extends TestBase 
{
	LoginPage page;
	
	@BeforeTest
	public void setUp()
	{
		init_browser();
		page=new LoginPage();
	}
	
	@Test(priority = 1)
	public void validateusercredentials()
	{
		String actual_text=page.verifyUsercredentials();
		
		Assert.assertEquals(actual_text, "Username : Admin");
	}
	
	@Test(priority = 2, enabled = false)
	public void validateusercredentialsDisplay()
	{
		boolean flag=page.verifyUsercredentialsDisplay();
		
		Assert.assertTrue(flag);
	}
	
	@Test(priority = 3, enabled=false)
	public void validateLogin()
	{
		page.Login();
	}
	
	
	@Test(priority = 4, dataProvider = "DDF1",enabled = false)//Imp for I/W, how to use multiple datas for testing(by using Data Provider)
	public void validaeLoginDDF(String username, String password)
	{
		page.usernameTextbox.sendKeys(username);
		page.passwordTextbox.sendKeys(password);
		page.loginBtn.click();
		Assert.assertEquals(driver.getTitle(), "OrangeHRM"); 
		page.Welcomemsg.click();
		page.Logoutbtn.click();
		
		
		
	}
	
	@AfterTest
	public void tearDown()
	{
		Util_lib.closeWin();
	}
	
	@DataProvider(name="DDF1")
	public Object[][] getExcelData()
	{
		ExcelConfig con=new ExcelConfig(".\\src\\main\\java\\com\\infi\\VBank\\ExcelData\\DDF.xlsx");
		
		int row=con.getRowCount("Sheet2");
		
		int col=con.getColCount("Sheet2");
		
		Object[][] obj=new Object[row][col];
		
		for(int i=0; i<row; i++)
		{
			for(int j=0; j<col; j++)
			{
				obj[i][j]=con.getData("Sheet2", i, j);
			}
		}
		
		return obj;
	}

}
