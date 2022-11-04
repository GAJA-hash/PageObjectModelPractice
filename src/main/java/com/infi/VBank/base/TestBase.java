package com.infi.VBank.base;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.infi.VBank.Utilities.Util_lib;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase 
{
	File f;
	
	FileInputStream fis;
	
	public static Properties pro;
	
	public static WebDriver driver;
	
	public TestBase()//why constructor?
	{
		try
		{
			f=new File(".\\src\\main\\java\\com\\infi\\VBank\\config\\Configuration.properties");
		
			fis=new FileInputStream(f);
			
			pro=new Properties();
			
			pro.load(fis);
		
		}
		
		catch (Exception e) 
		{
			
			System.out.println(e.getMessage());
		}
	}
	
	public void init_browser()
	{
		String browsername=pro.getProperty("browser");//to get browser name from configuration.propeties
		
		if(browsername.equalsIgnoreCase("Firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			
			driver=new FirefoxDriver();
		}
		
		else if(browsername.equalsIgnoreCase("IE"))
		{
			WebDriverManager.iedriver().setup();
			
			driver=new InternetExplorerDriver();
		}
		
		else if(browsername.equalsIgnoreCase("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			
			driver=new ChromeDriver();
		}
		
		else
		{
			System.out.println("Given browser is wrong");
		}
		
		driver.get(pro.getProperty("url"));//to get url name from configuration.propeties
		
		Util_lib.maxWin();
		
		Util_lib.implicit_Wait(30);
		
		
		
		
		
	}

	

}
