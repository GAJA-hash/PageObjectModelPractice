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
	
	@Test(priority = 1, enabled = true)
	public void validateusercredentials()
	{
		String actual_text=page.verifyUsercredentials();
		
		Assert.assertEquals(actual_text, "Username : Admin");
	}
	
	@Test(priority = 2, enabled = true)
	public void validateusercredentialsDisplay()
	{
		boolean flag=page.verifyUsercredentialsDisplay();
		
		Assert.assertTrue(flag);
	}
	
	@Test(priority = 3, enabled = true)
	public void validateLoginPanelSpellcheck()
	{
		String actual_text=page.verifyLoginPanelSpellcheck();
		
		Assert.assertEquals(actual_text, "Login");
	}
	
	@Test(priority = 3)
	public void validateLoginPanelDisplay()
	{
		boolean flag = page.verifyLoginPanelDisplay();
		
		Assert.assertTrue(flag);
	}
	
	@Test(priority = 4, enabled=true)
	public void validateLogin()
	{
		page.Login();
	}
	
	@Test (priority = 5)
	public void validateLogout() {
		page.Logout();
	}
	@Test(priority = 6, dataProvider = "DDF1",enabled = true)//(SEE BELOW->@Data Provider)Imp for I/W, how to use multiple datas for testing(by using Data Provider)
	public void validateLoginDDF(String username, String password)
	{
		page.usernameTextbox.sendKeys(username);
		page.passwordTextbox.sendKeys(password);
		page.loginBtn.click();
		Assert.assertEquals(driver.getTitle(), "OrangeHRM"); 
//		page.Welcomemsg.click();
		page.Logout();
		
		
		
	}
	
	@AfterTest(enabled = true)
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
