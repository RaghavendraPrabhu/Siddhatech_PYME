package dd_pins;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import dd_testCore.testCore;
import dd_util.SendAlertMailTest;
import dd_util.TestUtil;
import io.appium.java_client.MobileElement;

public class Createpinscenarios extends testCore{
	
	@Test
	public void CreatePin_WelcomeText() {
		
		app_logs.debug("Verify The Welcome Wish Message.");
		logger = extent.startTest("TEST CASE- Verify The Welcome Wish Message.");
			
	    TestUtil.VerifyWish();
		        
		try{
		Assert.assertEquals(timeinstance, driver.findElement(By.id("com.popular.app.corp:id/txtNombre")).getText());
		
		logger.log(LogStatus.INFO, "CreatePin", "User Verfies The Text - " + driver.findElement(By.id("com.popular.app.corp:id/txtNombre")).getText());	
		
		System.out.println("WelCome Text Matches: " + driver.findElement(By.id("com.popular.app.corp:id/txtNombre")).getText() );
		
		testresultdata.put(object.getProperty("CreatePinWelcomeText"),
				new Object[] {   "CreatePin  WelCome Message.",
								 "User Verifies The WelCome Message.",
								 "WelCome Message Should Be : " + timeinstance, 
								 "WelCome Message Is : " + driver.findElement(By.id("com.popular.app.corp:id/txtNombre")).getText(),  
								 "Success",
								 "Pass", 
								 "NA", 
								 "NA", 
								 "NA", });	
			
		} catch(AssertionError e) {
		        	
		System.out.println("WelCome Text Does Not Matches: " + driver.findElement(By.id("com.popular.app.corp:id/txtNombre")).getText() );
		
		logger.log(LogStatus.FAIL, "CreatePin", "Test Verification Fail - Present Text Is - " + driver.findElement(By.id("com.popular.app.corp:id/txtNombre")).getText());	
		
		testresultdata.put(object.getProperty("CreatePinWelcomeText"),
				new Object[] {   "CreatePin WelCome Message.",
								 "User Verifies The WelCome Message.",
								 "WelCome Message Should Be : " + timeinstance, 
								 "WelCome Message Is : " + driver.findElement(By.id("com.popular.app.corp:id/txtNombre")).getText(),  
								 "UnSucess",
								 "Fail", 
								 "NA", 
								 "NA", 
								 "NA", });		
		}
		        
		}
 
	//@Test(priority=1)
	public void InvalidPins() throws InterruptedException {
				
		app_logs.debug("InValid Pin Attempts ");
		logger = extent.startTest("TEST CASE-CreatePin : User Enters InValid Pins.");		
		Assert.assertEquals("PIN:", driver.findElement(By.id("com.popular.app.corp:id/textView4")).getText());

		System.out.println("TEST CASE-CreatePin : User Enters InValid Pins.");
		logger.log(LogStatus.INFO, "Start Creating Pins:","Start Entering Create Invalid Pins.");
		
		for (int i = 1; i <=4; i++) {			
			driver.sendKeyEvent(8);
			String screenshot_Path = TestUtil.captureScreenShot_Other(driver, "Pin_" + i);
			String image = logger.addScreenCapture(screenshot_Path);
			System.out.println("Entered Pin :" + i);
			logger.log(LogStatus.INFO, "User Enters Pin ", "Entered Pin :" + i + "" + image);
		}		
		for (int j = 11; j <=14; j++) {	
			driver.sendKeyEvent(9);
			String screenshot_Path = TestUtil.captureScreenShot_Other(driver, "Pin_" + j);
			String image = logger.addScreenCapture(screenshot_Path);
			System.out.println("Entered Pin :" + j);
			logger.log(LogStatus.INFO, "User Enters Pin ", "Entered Pin :" + j + "" + image);
		}
		logger.log(LogStatus.INFO, "Stop Creating Pins:","Stop Entering Create Invalid Pins.");
		
		Thread.sleep(5000);
		System.out.println("Testing1");
				
		long start = System.currentTimeMillis();
		String StartTime = time_formatter.format(System.currentTimeMillis());
		
		String screenshot_Path = TestUtil.captureScreenShot(driver, "InvalidCreatePins");
		String image = logger.addScreenCapture(screenshot_Path);

		 try{	
		    System.out.println("Testing2");
			Assert.assertEquals("Continuar",driver.findElement(By.id("android:id/button1")).getText());
			System.out.println("Testing3");
			
					long finish = System.currentTimeMillis();
					long total =  finish - start;
					String totalTime = String.format("%.2f", total / 1000.0);
					String EndTime =  time_formatter.format(System.currentTimeMillis());
									
					testresultdata.put(object.getProperty("InValidPins"),
							new Object[] {  "Create Pins-InValidPins Attempt",
									 		"User Enters Invalid Pins.",
									 		"Error Alert- Código secreto no coincide. Por favor verifica y digítalo nuevamente - Should Get Displayed", 
									 		"Correct Error Alert- " + driver.findElement(By.id("android:id/message")).getText() + " Is Displayed",  
									 		"Success",
									 		"Pass", 
									 		StartTime, 
									 		EndTime,
									 		totalTime + " seconds."});	
					
					screenshot_Path = TestUtil.captureScreenShot(driver, "InvalidCreatePin");
					image = logger.addScreenCapture(screenshot_Path);				
					logger.log(LogStatus.INFO, "Error Alert PopUp", "User Clicks On Continuar Button On Alert Pop Up" + image);	
					
					System.out.println("Error Message Content Is : "+ driver.findElement(By.id("android:id/message")).getText());	
											
					MobileElement Continuar = driver.findElement(By.id("android:id/button1"));
					Thread.sleep(1000);
					Continuar.click();
					//Continuar.click();
					System.out.println("Testing4");
				 
			 } catch(Exception e) {
				 
					logger.log(LogStatus.ERROR, "Error Trace Is : ", ExceptionUtils.getStackTrace(e));
					
					System.out.println("InValidPins Pin Scenario Failed ");
					
					long finish = System.currentTimeMillis();
					long total =  finish - start;
					String totalTime = String.format("%.2f", total / 1000.0);
					String EndTime =  time_formatter.format(System.currentTimeMillis());
					
					testresultdata.put(object.getProperty("InValidPins"),
							new Object[] { "Create Pins-InValidPins Attempt",
									 		"User Enters InValid Pins.",
									 		"Error Alert- " + driver.findElement(By.id(object.getProperty("AlertMessage"))).getText() + " Should Get Displayed", 
									 		"Error Alert- " + driver.findElement(By.id(object.getProperty("AlertMessage"))).getText() + " Is Displayed",  
									 		"UnSuccess",
									 		"Fail", 
									 		StartTime, 
									 		EndTime,
									 		totalTime + " seconds."});				 
			 }
		
	}

	//@Test(priority=2, dependsOnMethods="InvalidPins")
	@Test(priority=1)
	public void ValidPin() throws InterruptedException{
		
		app_logs.debug("Valid Pin Attempts ");

		logger = extent.startTest("TEST CASE-CreatePin : User Enters Valid Pins.");
		
		Assert.assertEquals("PIN:", driver.findElement(By.id("com.popular.app.corp:id/textView4")).getText());

		System.out.println("TEST CASE-CreatePin : User Enters Valid Pins.");

		logger.log(LogStatus.INFO, "Start To Create Pins:", "Start Entering Create Pin.");

		try{
			
			for (int i = 1; i < 9; i++) {
				
				driver.sendKeyEvent(8);

				String screenshot_Path = TestUtil.captureScreenShot_Other(driver, "Pin_" + i);
				String image = logger.addScreenCapture(screenshot_Path);
				logger.log(LogStatus.INFO, "User Enters Pin ", "Entered Pin :" + i + "" + image);

				Thread.sleep(75l);
			}
			
		}catch(Exception e){
			
			logger.log(LogStatus.INFO, "Pin Entering Error","Entering Pin Went Wrong. Recheck");
			
		}
		
		logger.log(LogStatus.INFO, "Stop Creating Pins:","Stop Entering Create Pin.");
				
		long start = System.currentTimeMillis();
		String StartTime = time_formatter.format(System.currentTimeMillis());

		try {
			Assert.assertEquals("INGRESA TU CÓDIGO SECRETO", driver.findElement(By.id("com.popular.app.corp:id/textView4")).getText());

			long finish = System.currentTimeMillis();
			long total = finish - start;
			String totalTime = String.format("%.2f", total / 1000.0);
			String EndTime =  time_formatter.format(System.currentTimeMillis());
	
			logger.log(LogStatus.INFO, "Pin Confirm Screen:","Total Time Required To Display Pin Confirm Screen : " + totalTime + " seconds.");
					
			testresultdata.put(object.getProperty("ValidPins"),
					new Object[] {  "Create Pins-ValidPins Attempt",
							 		"User Enters Valid Pins",
							 		"Confirm Pin Screen Should Be Displayed.",
							 		"Confirm Pin Screen Is Displayed.",
							 		"Success",
							 		"Pass", 
							 		StartTime, 
							 		EndTime,
							 		totalTime + " seconds."});	
			
		} catch (Exception e) {

			long finish = System.currentTimeMillis();
			long total = finish - start;
			String totalTime = String.format("%.2f", total / 1000.0);
			String EndTime =  time_formatter.format(System.currentTimeMillis());
			
			logger.log(LogStatus.ERROR, "Error Trace Is : ", ExceptionUtils.getStackTrace(e));
								
			testresultdata.put(object.getProperty("ValidPins"),
					new Object[] {  "Create Pins-ValidPins Attempt",
							 		"User Enters Valid Pins.",
							 		"Confirm Pin Screen Should Be Displayed.",
							 		"Confirm Pin Screen Is Not Displayed.",
							 		"UnSucess",
							 		"Fail", 
							 		StartTime, 
							 		EndTime,
							 		totalTime + " seconds."});	
			
			ReAttemptCreatePins();

		}

		logger.log(LogStatus.INFO, "Confirm Pin Screen Confirmation:","Expected-Confirm Pin Screen Should Be Displayed.");
		Assert.assertEquals("INGRESA TU CÓDIGO SECRETO", driver.findElement(By.id("com.popular.app.corp:id/textView4")).getText());
		logger.log(LogStatus.PASS, "Confirm Pin Screen Confirmation:","Actual-Confirm Pin Screen Is Displayed.");
	}
			
	public void ReAttemptCreatePins() throws InterruptedException{
				
		try {	
			
			ValidPin();
																			
		} catch(Exception e) {
			
			System.out.println("Create Pins Failed");					
			String screenshot_Path = TestUtil.captureScreenShot(driver, "CreatePinsFailed");
			String image = logger.addScreenCapture(screenshot_Path);
			
			//SENDS ALERT MAIL ON FAIL
			String Message = "<b>Error Alert : </b> Create Pin ReAttempt Fail." + "<br>"
					+ "<b>Error Message Is : </b>" + driver.findElement(By.id("android:id/message")).getText() + "<br>"
					+ "Check The Error Stacktrace & Attached Error ScreenShot.</b><br><br>";
			SendAlertMailTest.SendDetail(From, Password , TO, CC, "BPD Application Alert : Create Pin ReAttempt Fail- " + formattedDate, 
			Message + ExceptionUtils.getStackTrace(e));
			System.out.println("Alert Send Via Mail For Login Access Fail");
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			logger.log(LogStatus.FAIL, "Expected Screen Verification Fail", image);						
			extent.endTest(logger);
			extent.flush();				
			setupAfterSuite();				
			driver.quit();							
		}				
	}
	
	
}
