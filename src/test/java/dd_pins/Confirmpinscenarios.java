package dd_pins;

import java.awt.AWTException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.mail.MessagingException;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import dd_testCore.testCore;
import dd_util.SendAlertMailTest;
import dd_util.TestUtil;
import io.appium.java_client.MobileElement;


public class Confirmpinscenarios extends testCore {
	
	@Test
	public void ConfirmPin_WelcomeText() {
		
		app_logs.debug("Verify The Welcome Wish Message.");
		logger = extent.startTest("TEST CASE- Verify The Welcome Wish Message.");
			
	    TestUtil.VerifyWish();
		        
		try{
		Assert.assertEquals(timeinstance, driver.findElement(By.id("com.popular.app.corp:id/txtNombre")).getText());
		
		logger.log(LogStatus.INFO, "ConfirmPin", "User Verfies The Text - " + driver.findElement(By.id("com.popular.app.corp:id/txtNombre")).getText());	
		
		System.out.println("WelCome Text Matches: " + driver.findElement(By.id("com.popular.app.corp:id/txtNombre")).getText() );
		
		testresultdata.put(object.getProperty("ConfirmPinWelcomeText"),
				new Object[] {   "ConfirmPin  WelCome Message.",
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
		
		logger.log(LogStatus.FAIL, "ConfirmPin", "Test Verification Fail - Present Text Is - " + driver.findElement(By.id("com.popular.app.corp:id/txtTitle")).getText());	
		
		testresultdata.put(object.getProperty("ConfirmPinWelcomeText"),
				new Object[] {   "ConfirmPin WelCome Message.",
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
		
	//@Test(priority = 1)
	public void ConfirmPinInValid() throws InterruptedException {
		
		app_logs.debug("InValid ConfirmPin Attempts.");
		
		logger = extent.startTest("TEST CASE-InConfirmPin: User Enters Invalid Confirm Pins.");
		
		Assert.assertEquals("INGRESA TU CÓDIGO SECRETO", driver.findElement(By.id("com.popular.app.corp:id/textView4")).getText());
		
		System.out.println("TEST CASE-InConfirmPin: User Enters Invalid Confirm Pins.");
			
		logger.log(LogStatus.INFO, "InValidConfirmPins:","Start Entering InValid Pins.");
		
		
		for (int i = 1; i < 5; i++) {
					
			MobileElement ConfirmPin = driver.findElement(By.id("com.popular.app.corp:id/pinText"+i));		
			ConfirmPin.click();			
			driver.sendKeyEvent(9);			
			String screenshot_Path = TestUtil.captureScreenShot_Other(driver, "ConfirmPinInvalid");
			String image = logger.addScreenCapture(screenshot_Path);				
			logger.log(LogStatus.INFO, "ConfirmedPin : ", image);
			
			Thread.sleep(100l);
		}
		
		logger.log(LogStatus.INFO, "InValidConfirmPins:","Stop Entering InValid Pins.");
		
		long start = System.currentTimeMillis();
		String StartTime = time_formatter.format(System.currentTimeMillis());
		
		try{					 
			Assert.assertEquals("Error",driver.findElement(By.id("android:id/alertTitle")).getText());
					
			long finish = System.currentTimeMillis();
			long total =  finish - start;
			String totalTime = String.format("%.2f", total / 1000.0);
			String EndTime =  time_formatter.format(System.currentTimeMillis());
									
			testresultdata.put(object.getProperty("ConfirmPinInvalid"),
					new Object[] {  "Confirm Pins-InValidPins Attempt",
									"User Enters InValidPins",
									"Error Alert- El código secreto digitado es incorrecto. Por favor verifica y digita nuevamente - Should Get Displayed", 
									"Correct Error Alert- " + driver.findElement(By.id("android:id/message")).getText() + " Is Displayed",  
									"Success",
									"Pass", 
									StartTime, 
									EndTime,
									totalTime + " seconds."});	
					
			String screenshot_Path = TestUtil.captureScreenShot(driver, "InvalidConfirmPins");
			String image = logger.addScreenCapture(screenshot_Path);	
					
		    logger.log(LogStatus.INFO, "Error Alert PopUp", "User Clicks On Continuar Button On Alert Pop Up" + image);	
				
		    System.out.println("Error Message Content Is : "+ driver.findElement(By.id("android:id/message")).getText());	
			System.out.println("User Clicks Error Window Continuar Button");
								
			MobileElement Continuar = driver.findElement(By.id("android:id/button1"));
			Thread.sleep(1000);
			Continuar.click();
				 
			 } catch(Exception e) {
				 
					logger.log(LogStatus.ERROR, "Error Trace Is : ", ExceptionUtils.getStackTrace(e));
					
					System.out.println("InValidConfirmPins Scenario Failed ");
					
					long finish = System.currentTimeMillis();
					long total =  finish - start;
					String totalTime = String.format("%.2f", total / 1000.0);
					String EndTime =  time_formatter.format(System.currentTimeMillis());
					
					
					testresultdata.put(object.getProperty("ConfirmPinInvalid"),
							new Object[] {  "Confirm Pins-InValidPins Attempt",
					 		"User Enters InValidConfirm Pins",
					 		"Error Alert- " + driver.findElement(By.id(object.getProperty("AlertMessage"))).getText() + " Should Get Displayed", 
					 		"Correct Error Alert- " + driver.findElement(By.id(object.getProperty("AlertMessage"))).getText() + " Is Displayed",  
					 		"UnSuccess",
					 		"Fail", 
					 		StartTime, 
					 		EndTime,
					 		totalTime + " seconds."});					 
			 }

	}
		
	//@Test(priority = 2, dependsOnMethods = "ConfirmPinInValid")
	@Test(priority = 1)
	public void ConfirmPinValid() throws InterruptedException, IOException, MessagingException, AWTException {
		
		app_logs.debug("Valid ConfirmPin Attempts.");
		
		logger = extent.startTest("TEST CASE-ConfirmPin: User Enters Confirm Pins.");
		
		Assert.assertEquals("INGRESA TU CÓDIGO SECRETO", driver.findElement(By.id("com.popular.app.corp:id/textView4")).getText());
		
		System.out.println("TEST CASE-ConfirmPin: User Enters Confirm Pins.");
	
		
		logger.log(LogStatus.INFO, "ConfirmPins:","Start Entering Confirm Pin.");
		
		for (int i = 1; i < 5; i++) {
			//driver.findElement(By.id(object.getProperty("Label"))).click();			
			MobileElement ConfirmPin = driver.findElement(By.id("com.popular.app.corp:id/pinText"+i));		
			ConfirmPin.click();			
			driver.sendKeyEvent(8);						
			String screenshot_Path = TestUtil.captureScreenShot_Other(driver, "ConfirmPin_"+i);
			String image = logger.addScreenCapture(screenshot_Path);				
			logger.log(LogStatus.INFO, "ConfirmedPin : ", image);

		}
		
		long start = System.currentTimeMillis();
		String StartTime = time_formatter.format(System.currentTimeMillis());
		
		logger.log(LogStatus.INFO, "ConfirmPins:","Stopped Entering Confirm Pin.");
		
		try{		
			Assert.assertEquals("Salir", driver.findElement(By.id("com.popular.app.corp:id/txtLogout")).getText());	
			
			long finish = System.currentTimeMillis();
			long total = finish - start;
			String totalTime = String.format("%.2f", total / 1000.0);
			String EndTime =  time_formatter.format(System.currentTimeMillis());
						
			testresultdata.put(object.getProperty("ConfirmPinValid"),
					new Object[] { 	"ConfirmPinValid-Valid Pins",
							 		"User Enters Valid Confirm Pins",
							 		"Account DashBoard Should Be Displayed.", 
							 		"Account DashBoard Is Displayed.", 
							 		"Success",
							 		"Pass", 
							 		StartTime, 
							 		EndTime,
							 		totalTime + " seconds."});	
			
		}catch (Throwable t) {
			
			long finish = System.currentTimeMillis();
			long total = finish - start;
			String totalTime = String.format("%.2f", total / 1000.0);
			String EndTime =  time_formatter.format(System.currentTimeMillis());
									
			testresultdata.put(object.getProperty("ConfirmPinValid"),
					new Object[] { 	"ConfirmPinValid-Valid Pins",
							 		"User Enters Valid Confirm Pins",
							 		"Account DashBoard Should Be Displayed.", 
							 		"Account DashBoard Is Not Displayed.", 
							 		"UnSucess",
							 		"Fail", 
							 		StartTime, 
							 		EndTime,
							 		totalTime + " seconds."});	
			
			logger.log(LogStatus.ERROR, "Error Trace Is : ", ExceptionUtils.getStackTrace(t));
			
			String screenshot_Path = TestUtil.captureScreenShot(driver, "ConfirmPinFail");
			String image = logger.addScreenCapture(screenshot_Path);		
			logger.log(LogStatus.INFO, "Create Pin Screen: ", "Confirm Pin Fail " + image);
			
			
			//SENDS ALERT MAIL ON FAIL
			String Message = "<b>Error Alert : </b> Confirm Pin Fail." + "<br>" + "Check The Error Stacktrace & Attached Error ScreenShot.</b><br><br>";
			SendAlertMailTest.SendDetail(From, Password , TO, CC, "BPD Application Alert : Login Access Fail " + formattedDate, 
			Message + ExceptionUtils.getStackTrace(t));
			System.out.println("Alert Send Via Mail For Codigo Validation Fail");
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
						
			Assert.assertEquals("Error", driver.findElement(By.id(object.getProperty("AlertTitle"))).getText());					
			System.out.println("User Clicks Error Window Continuar Button");
			driver.findElement(By.id(object.getProperty("Continuar"))).click();
			Thread.sleep(1500l);
			
			ConfirmPinFailScenario();	
			
		}
		
		logger.log(LogStatus.INFO, "Account Dashboard Verification:","Account Screen Should Get Displayed.");
		Assert.assertEquals("Salir", driver.findElement(By.id("com.popular.app.corp:id/txtLogout")).getText());	
		logger.log(LogStatus.PASS, "Account Dashboard Verification:","Account Screen Is Displayed.");
		
	}
	
	public void ConfirmPinFailScenario() throws InterruptedException, MessagingException, IOException, AWTException {
		
		try{
			logger.log(LogStatus.INFO, "Account Listing Verification:","Expected-User Account Listing Should Get Displayed.");
			Assert.assertEquals("Salir", driver.findElement(By.id(object.getProperty("Salir"))).getText());	
			logger.log(LogStatus.PASS, "Account Listing Verfication:","Actual-User Account Listing Is Displayed - : " + driver.findElement(By.id("com.popular.app.android:id/txtnombre")).getText());		
			
		}catch(Exception e){
			
			String screenshot_Path = TestUtil.captureScreenShot(driver, "ConfirmPinFail");
			String image = logger.addScreenCapture(screenshot_Path);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			logger.log(LogStatus.FAIL, "Expected Screen Verification Fail", image);
						
			extent.endTest(logger);
			extent.flush();
			
			setupAfterSuite();		
			driver.quit();
			
		}
		
	}
		
	
	
}
