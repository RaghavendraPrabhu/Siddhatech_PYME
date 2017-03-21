package dd_util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;

import dd_testCore.testCore;
import io.appium.java_client.MobileElement;

public class Test2 extends testCore  {

	static String Account = "";
	static String text = "";
	static String Expected_Account= "";
	
	public static void main(String[] args) throws IOException {
			
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\java\\dd_properties\\config.properties");
		config.load(fis);
		app_logs.debug("Loading the Config Propeties File");

		fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\dd_properties\\object.properties");
		object.load(fis);
		app_logs.debug("Loading the Object Propeties File Succesfully");
					
		fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\java\\dd_properties\\users.properties");
		users.load(fis);
		app_logs.debug("Loading the Dev Users Propeties File");
			
			
			if (users.getProperty("User").equalsIgnoreCase("ProdUser")) {
				
				Expected_Account = users.getProperty("Savings");			
				System.out.println("Account Number Prod " + Expected_Account);
				
			} else if (users.getProperty("User").equalsIgnoreCase("DevUser")) {
				
				Expected_Account = users.getProperty("Savings");			
				System.out.println("Account Number Dev " + Expected_Account);;
				
			}	
	

	}

}
