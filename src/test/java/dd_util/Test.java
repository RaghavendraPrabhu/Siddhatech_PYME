package dd_util;

import dd_testCore.testCore;

public class Test extends testCore {
	

	static String Account = "";
	static String text = "";
	static String Expected_Account= "";
	
	public void testing() {
		
	if (config.getProperty("App").equalsIgnoreCase("Production")) {
			
			Expected_Account = object.getProperty("SavingsLuis");			
			System.out.println("Account Number Is " + Expected_Account);
			
		} else {
			
			Expected_Account = object.getProperty("SavingsMonitoreo3");			
			System.out.println("Account Number Is " + Expected_Account);
		}
	}

}
