package com.app.pageexe;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.app.base.BaseClass;
import com.app.locators.LoginPageLocators;

public class LoginPageExe extends LoginPageLocators
{
	public static void close()
	{
		BaseClass.clickElement(BaseClass.findElementbyxpath(LoginPageLocators.closeX));
	}
	public static void fashion()
	{
		BaseClass.moveToEle(BaseClass.findElementbyxpath(LoginPageLocators.fashion));
	}
	public static void watAndAcc()
	{
		BaseClass.moveToEle(BaseClass.findElementbylinkText(LoginPageLocators.watAndAcc));
	}
	public static void menAndWomen()
	{
		BaseClass.moveToEleClick(BaseClass.findElementbylinkText(LoginPageLocators.menAndWomen));
	}
	public static void men()
	{
		BaseClass.CurrentUrl();
		BaseClass.moveToEle(BaseClass.findElementbyxpath(LoginPageLocators.men));
	}
	public static void watches()
	{
		BaseClass.moveToEle(BaseClass.findElementbyxpath(LoginPageLocators.watches));	
	}
	public static void selectWatchModel(String model) 
	{
		System.out.println("model"+model);
			switch (model) 
			{
			
				case "Fasttrack":
				BaseClass.moveToEleClick(BaseClass.findElementbylinkText(LoginPageLocators.fasttrack));
				break;
				case "Casio":
				BaseClass.moveToEleClick(BaseClass.findElementbylinkText(LoginPageLocators.casio));
				break;
				case "Titan":
				BaseClass.moveToEleClick(BaseClass.findElementbylinkText(LoginPageLocators.titan));
				break;
				case "Fossil":
				BaseClass.moveToEleClick(BaseClass.findElementbylinkText(LoginPageLocators.fossil));
				break;
				case "Sonata":
				BaseClass.moveToEleClick(BaseClass.findElementbylinkText(LoginPageLocators.sonata));
				break;
			}
	}
	
}

