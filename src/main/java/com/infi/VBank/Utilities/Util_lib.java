

package com.infi.VBank.Utilities;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.infi.VBank.base.TestBase;
/*
 * Common methods we use in our projects like, Dropdown handling, switch to Frames, Multiple window, Alert Popup,
 *  Taking screenshot etc., can be written 
 * in this java class. Whenever we need these classes we can use it.
 * 
 */
public class Util_lib extends TestBase
{
	static Select sel;
	
	public static void maxWin()//used in TestBase.java
	{
		driver.manage().window().maximize();
	}
	
	public static void implicit_Wait(int time)//used in TestBase.java
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
	}
	
	public static void closeWin()//not used in this framework
	{
		driver.close();
	}
	
	public static String getText(WebElement ele)//Used in Loginpage.java
	{
		return ele.getText();
	}
	
	public static boolean isDisplay(WebElement ele)//Used in Loginpage.java
	{
		return ele.isDisplayed();
	}
	
	public static boolean isSelect(WebElement ele)
	{
		return ele.isSelected();
	}

	public static boolean isEnable(WebElement ele)
	{
		return ele.isEnabled();
	}
	
	public static void selectByindex(WebElement ele, int index)//not used in this framework
	{
		sel=new Select(ele);
		
		sel.selectByIndex(index);
	}
	
	public static void selectByvalue(WebElement ele, String val)
	{
		sel=new Select(ele);
		
		sel.selectByValue(val);
	}
	
	public static void selectByvisibleText(WebElement ele, String val)
	{
		sel=new Select(ele);
		
		sel.selectByVisibleText(val);
	}
	


	public static void switchtoframeindex(int index)
	{
		driver.switchTo().frame(index);
	}
	
	public static void switchtoframeName(String name)
	{
		driver.switchTo().frame(name);
	}
	
	public static void switchtoframeWebElement(WebElement ele)
	{
		driver.switchTo().frame(ele);
	}


	
	
}
