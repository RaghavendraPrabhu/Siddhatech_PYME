package dd_codigo;

import java.awt.AWTException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import javax.mail.MessagingException;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.itextpdf.text.DocumentException;
import com.relevantcodes.extentreports.LogStatus;
import dd_testCore.testCore;
import dd_util.SendAlertMailTest;
import dd_util.TestUtil;
import io.appium.java_client.MobileElement;

public class Codigoscenarios extends testCore {
	
	static String text = "";	
	int i=1;
	
	//@Test
	public void Codigo_WelcomeText() {
	
	app_logs.debug("Verify The Welcome Wish Message.");
	logger = extent.startTest("TEST CASE- Verify The Welcome Wish Message.");
		
    TestUtil.VerifyWish();
	        
	try{
	Assert.assertEquals(timeinstance, driver.findElement(By.id("com.popular.app.corp:id/txtTitle")).getText());
	
	logger.log(LogStatus.INFO, "CodigoPage", "User Verfies The Text - " + driver.findElement(By.id("com.popular.app.corp:id/txtTitle")).getText());	
	
	System.out.println("WelCome Text Matches: " + driver.findElement(By.id("com.popular.app.corp:id/txtTitle")).getText() );
	
	testresultdata.put(object.getProperty("CodigoWelcomeText"),
			new Object[] {   "CodigoScreen WelCome Message.",
							 "User Verifies The WelCome Message.",
							 "WelCome Message Should Be : " + timeinstance, 
							 "WelCome Message Is : " + driver.findElement(By.id("com.popular.app.corp:id/txtTitle")).getText(),  
							 "Success",
							 "Pass", 
							 "NA", 
							 "NA", 
							 "NA", });	
		
	} catch(AssertionError e) {
	        	
	System.out.println("WelCome Text Does Not Matches: " + driver.findElement(By.id("com.popular.app.corp:id/txtTitle")).getText() );
	
	logger.log(LogStatus.FAIL, "CodigoPage", "Test Verification Fail - Present Text Is - " + driver.findElement(By.id("com.popular.app.corp:id/txtTitle")).getText());	
	
	testresultdata.put(object.getProperty("CodigoWelcomeText"),
			new Object[] {   "CodigoScreen WelCome Message.",
							 "User Verifies The WelCome Message.",
							 "WelCome Message Should Be : " + timeinstance, 
							 "WelCome Message Is : " + driver.findElement(By.id("com.popular.app.corp:id/txtTitle")).getText(),  
							 "UnSucess",
							 "Fail", 
							 "NA", 
							 "NA", 
							 "NA", });		
	}
	        
	}

	
	//@Test(priority = 1)
	public void BlankCodigo() {
		
		System.out.println("TESTING1");
		app_logs.debug("Verify The Blank Codigo.");
		logger = extent.startTest("TEST CASE- Verify The Blank Codigo.");
		System.out.println("TEST CASE- Verify The Blank Codigo.");
		System.out.println("TESTING2");
		
		String screenshot_Path = TestUtil.captureScreenShot(driver, "Codigo_Blank");
		String image = logger.addScreenCapture(screenshot_Path);		
		logger.log(LogStatus.INFO, "CodigoPage", "User Clicks On Continue Button Without Entering Codigo." + image);	
							
		Assert.assertEquals("Continuar", driver.findElement(By.id("com.popular.app.corp:id/btnContinuar")).getText());		
		try {			
			driver.findElement(By.id("com.popular.app.corp:id/btnContinuar")).click();
			Thread.sleep(1500);		
			
		} catch (Exception e) {

			System.out.println("Continuar Button Not Found");
		}
			

	   try {	
		   
		Assert.assertEquals("Error", driver.findElement(By.id("android:id/alertTitle")).getText());			
		logger.log(LogStatus.INFO, "Error Message:", driver.findElement(By.id("android:id/message")).getText());		
		screenshot_Path = TestUtil.captureScreenShot(driver, "BlankCodigo");
		image = logger.addScreenCapture(screenshot_Path);			
		logger.log(LogStatus.INFO, "Error Alert PopUp", "User Clicks On Continue Button On Error Pop for Blank Codigo." + image);	
			
		System.out.println("Blank Codigo Validation Successful");
				
		testresultdata.put(object.getProperty("BlankCodigo"),
				new Object[] {  "CodigoScreen-Blank Codigo",
								 "User Enters Blank Codigo And Click Guarder Button",
								 "Error Message-" + driver.findElement(By.id("android:id/message")).getText() + " should be displayed", 
								 "Error Message-" + driver.findElement(By.id("android:id/message")).getText() + " Is displayed",  
								 "Success",
								 "Pass", 
								 "NA", 
								 "NA", 
								 "NA", });	
		
		System.out.println("Error Message Content Is : "+ driver.findElement(By.id("android:id/message")).getText());
	
		driver.findElement(By.id("android:id/button1")).click();

			} catch (Exception e) {
				
		System.out.println("Blank Codigo Validation UnSuccessful");
							
		testresultdata.put(object.getProperty("BlankCodigo"),
				new Object[] { "CodigoScreen-Blank Codigo",
							   "User Enters Blank Codigo And Click Continuar Button",
							   "Error Message-" + driver.findElement(By.id("android:id/message")).getText() + " should be displayed", 
							   "Error Message-" + driver.findElement(By.id("android:id/message")).getText() + " Is displayed", 
							   "UnSuccess",
							   "Fail", 
							   "NA", 
							   "NA", 
							   "NA", });	
				
			}
	}
	
	
	//@Test(priority = 2, dependsOnMethods = "BlankCodigo")
	public void InvalidCodigo() {
				
		app_logs.debug("Verify The Invalid Codigo");
		logger = extent.startTest("TEST CASE- Verify The Invalid Codigo");
		System.out.println("TEST CASE- Verify The Invalid Codigo");
		
		String screenshot_Path = TestUtil.captureScreenShot(driver, "Invalid_Codigo");
		String image = logger.addScreenCapture(screenshot_Path);		
		logger.log(LogStatus.INFO, "CodigoPage", "User Clicks On Continue Button Entering Invalid Codigo." + image);

		try {
			Assert.assertEquals("Continuar",driver.findElement(By.id("com.popular.app.corp:id/btnContinuar")).getText());

			MobileElement Codigo =driver.findElement(By.id("com.popular.app.corp:id/editText1"));
			Codigo.click();
			Codigo.sendKeys("123123");
			Thread.sleep(1000);
			driver.findElement(By.id("com.popular.app.corp:id/btnContinuar")).click();
			Thread.sleep(1500);	
			
		} catch (Exception e) {

			System.out.println("Continuar Button Not Found");
		}
		
			
			try {				
				Assert.assertEquals("Error", driver.findElement(By.id("android:id/alertTitle")).getText());
				
				logger.log(LogStatus.INFO, "Error Message:",driver.findElement(By.id("android:id/message")).getText());
				
				screenshot_Path = TestUtil.captureScreenShot(driver, "InvalidCodigo");
				image = logger.addScreenCapture(screenshot_Path);				
				logger.log(LogStatus.INFO, "Error Alert PopUp", "User Clicks On Continue Button On Error Pop for Invalid Codigo." + image);	
							
				System.out.println("Invalid Codigo Validation Successful");
				
				testresultdata.put(object.getProperty("InvalidCodigo"),
						new Object[] {  "CodigoScreen-InvalidCodigo Codigo",
								 		"User Enters InvalidCodigo Codigo And Click Guarder Button",
								 		"Error Message-" + driver.findElement(By.id("android:id/message")).getText() + " should be displayed", 
								 		"Error Message-" + driver.findElement(By.id("android:id/message")).getText() + " Is displayed",  
								 		"Success",
								 		"Pass", 
								 		"NA", 
								 		"NA", 
								 		"NA", });	
				
				
				System.out.println("Error Message Content Is : " + driver.findElement(By.id("android:id/message")).getText());
							
				driver.findElement(By.id("android:id/button1")).click();
				Thread.sleep(15000);

			} catch (Exception e) {
				
				System.out.println("InvalidCodigo Codigo Validation UnSuccessful");
							
				testresultdata.put(object.getProperty("InvalidCodigo"),
						new Object[] {  "CodigoScreen-InvalidCodigo Codigo",
								 		"User Enters InvalidCodigo Codigo And Click Guarder Button",
								 		"Error Message-" + driver.findElement(By.id("android:id/message")).getText() + " should be displayed", 
								 		"Error Message-" + driver.findElement(By.id("android:id/message")).getText() + " Is displayed",  
								 		"UnSuccess",
								 		"Fail", 
								 		"NA", 
								 		"NA", 
								 		"NA", });		
				
			}



	}
	
	
   //@Test(priority = 3, dependsOnMethods = "InvalidCodigo")
   @Test
   public void Verification() throws InterruptedException, AWTException, IOException, MessagingException {

		if (config.getProperty("App").equals("Production")) {

			AppSwitch();
			ValidCodigo();

		} else if ((config.getProperty("App").equalsIgnoreCase("Development"))) {

			ValidCodigo();

		}

	}
	
	
	public void AppSwitch() throws InterruptedException, AWTException {

		logger = extent.startTest("TEST CASE-App Switch : Banco Popular App Switching To RSA App.");

		Assert.assertEquals("Cancelar", driver.findElement(By.id("com.popular.app.android:id/btnCancelar")).getText());
		System.out.println("TEST CASE-App Switch : Banco Popular App Switching To RSA App.");

		driver.startActivity("com.rsa.securidapp", "com.rsa.securidapp.ui.Splash_Activity", "com.rsa.securidapp",
				".ui.ShowOTP_Activity");
		

		if(i==1){
					
			for (int i = 0; i <= 120; i++) {
				System.out.println("Value Of i is " + i);
				
				WebElement Value = driver.findElement(By.id("com.rsa.securidapp:id/secondsRemainingValue"));
				String Timer = Value.getText();
				String TimerSet = Timer.substring(0, 2);
				System.out.println("Remaining Seconds Is " + TimerSet);
				Thread.sleep(500);
				if (TimerSet.equalsIgnoreCase("58") || TimerSet.equalsIgnoreCase("54") || TimerSet.equalsIgnoreCase("50")
						|| TimerSet.equalsIgnoreCase("45") || TimerSet.equalsIgnoreCase("40")
						|| TimerSet.equalsIgnoreCase("35") || TimerSet.equalsIgnoreCase("30")){
					break;
				}
			}
		} else if (i==2 || i==3){
			
			System.out.println("Value Of i is " + i);
			MobileElement NextCode = driver.scrollToExact("Next Code");
			NextCode.click();
			Thread.sleep(1500);
							
			for (int i = 0; i <= 120; i++) {

				WebElement Value = driver.findElement(By.id("com.rsa.securidapp:id/secondsRemainingValue"));
				String Timer = Value.getText();
				String TimerSet = Timer.substring(0, 2);
				System.out.println("Remaining Seconds Is " + TimerSet);
				Thread.sleep(500);
				if (TimerSet.equalsIgnoreCase("58") || TimerSet.equalsIgnoreCase("54") || TimerSet.equalsIgnoreCase("50")
						|| TimerSet.equalsIgnoreCase("45") || TimerSet.equalsIgnoreCase("40")
						|| TimerSet.equalsIgnoreCase("35") || TimerSet.equalsIgnoreCase("30")){
					break;
				}
			}
			
		}

		Thread.sleep(1500);
		ArrayList<String> arrList = new ArrayList<String>();

		long start = System.currentTimeMillis();
		String StartTime = time_formatter.format(System.currentTimeMillis());

		try {
			for (int i = 1; i < 9; i++) {
				MobileElement Text = driver.findElement(By.id("com.rsa.securidapp:id/OPT8_Value" + i));
				String Text1 = Text.getText();
				arrList.add(Text1);
			}

			long finish = System.currentTimeMillis();
			long total = finish - start;
			String totalTime = String.format("%.2f", total / 1000.0);
			String EndTime = time_formatter.format(System.currentTimeMillis());

			Assert.assertEquals("Token 1", driver.findElement(By.id(object.getProperty("Token1"))).getText());

			StringBuilder builder = new StringBuilder();
			for (String value : arrList) {
				builder.append(value);
			}
			text = builder.toString();

			driver.startActivity("com.popular.app.android", "com.siddhatech.activities.RegistrationCodigoActivity",
					"com.popular.app.android", "com.siddhatech.activities.RegistrationCodigoActivity");
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

			System.out.println("RSA App Switch Back To Banco Popular Codigo Screen With Codigo : " + text);
		
			testresultdata.put(object.getProperty("Token"),
					new Object[] {  "RSA App-Capturing The Token",
							 		"User Captures The Token:" ,
							 		"Correct Token Should Be Captured", 
							 		"Correct Token Caputured Is " + text,
							 		"Success",
							 		"Pass", 
							 		StartTime, 
							 		EndTime, 
							 		totalTime + "seconds.", });

		} catch (Throwable e) {

			logger.log(LogStatus.ERROR, "Error Trace Is : ", ExceptionUtils.getStackTrace(e));

			System.out.println("RSA App Not Found");

			long finish = System.currentTimeMillis();
			long total = finish - start;
			String totalTime = String.format("%.2f", total / 1000.0);
			String EndTime = time_formatter.format(System.currentTimeMillis());
			
			testresultdata.put(object.getProperty("Token"),
					new Object[] {  "RSA App-Capturing The Token",
							 		"User Captures The Token:" ,
							 		"Correct Token Should Be Captured", 
							 		"Correct Token Caputured Is " + text,
							 		"UnSuccess",
							 		"Fail", 
							 		StartTime, 
							 		EndTime, 
							 		totalTime + "seconds.", });
			
			//SENDS ALERT MAIL ON FAIL				
			String Message = 
					"<b>Error Alert : </b><br>"
					+ "<b>RSA App Switch Fail. Alert Message Is : </b><br> "
					+ "Check The Error Stacktrace & Attached Error ScreenShot.<br><br>" ;
							
			SendAlertMailTest.SendDetail(From, Password , TO, CC, "BPD Application Alert : " + formattedDate, 
			Message + ExceptionUtils.getStackTrace(e));
			System.out.println("Alert Send Via Mail For RSA App Switch Fail");
			Thread.sleep(5000);
		}

		logger.log(LogStatus.PASS, "Switch Back To Banco Popular Verification:","Expected-Codigo Screen Should Get Displayed");		
		Assert.assertEquals("Continuar",
				driver.findElement(By.id("com.popular.app.android:id/btnContinuar")).getText());
		logger.log(LogStatus.PASS, "Switch Back To Banco Popular Verification:", "Actual-Codigo Screen Is Displayed");
	}
	
	
	public void ValidCodigo() throws InterruptedException {
		
		logger = extent.startTest("TEST CASE-Codigo : User Enters Valid Codigo.");

		Assert.assertEquals("Continuar",driver.findElement(By.id("com.popular.app.corp:id/btnContinuar")).getText());
		
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		MobileElement Codigo = driver.findElement(By.id("com.popular.app.corp:id/editText1"));
		
		if (config.getProperty("App").equals("Production")) {
			System.out.println("TEST CASE : User Enters Valid Codigo Taken From RSA App");
			Codigo.click();
			Codigo.sendKeys(text);
			driver.hideKeyboard();
		} else {		
			System.out.println("TEST CASE : User Enters Valid Development Codigo.");
			Codigo.click();
			Codigo.sendKeys("321321");
			driver.hideKeyboard();			
		}

			//EDITED
			String screenshot_Path = TestUtil.captureScreenShot(driver, "CodigoScreen");
			String image = logger.addScreenCapture(screenshot_Path);
			logger.log(LogStatus.INFO, "Codigo Screen: ",
					"User Enters Codigo : " + text + " Taken From RSA App" + image);

			driver.findElement(By.id("com.popular.app.corp:id/btnContinuar")).click();
			
			long start = System.currentTimeMillis();
			String StartTime = time_formatter.format(System.currentTimeMillis());

			try {
				logger.log(LogStatus.INFO, "Continuar Button: ", "User Clicks Continuar Button ");

				Assert.assertEquals("PIN:",driver.findElement(By.id("com.popular.app.corp:id/textView4")).getText());

				long finish = System.currentTimeMillis();
				long total = finish - start;
				String totalTime = String.format("%.2f", total / 1000.0);
				String EndTime = time_formatter.format(System.currentTimeMillis());

				System.out.println("Codigo Verification Passed. Pin Screen Displaying");

				System.out.println("TOTAL TIME FOR GETTING LOGIN Is " + totalTime + " seconds");
				
				testresultdata.put(object.getProperty("ValidCodigo"),
						new Object[] {  "CodigoScreen-Valid Codigo",
								 		"User Enters Valid Codigo With Attempt-"+i,
								 		"Create Pin Screen Should Be Displayed.", 
								 		"Create Pin Screen Is Displayed.",
								 		"Success",
								 		"Pass", 
								 		StartTime, 
								 		EndTime, 
								 		totalTime + "seconds.", });
							
				logger.log(LogStatus.INFO, "CreatePin Screen Verification",
						"Total Time Required For Displaying Pin Screen Is : " + totalTime + " seconds.");

			} catch (Exception e) {

				long finish = System.currentTimeMillis();
				long total = finish - start;
				String totalTime = String.format("%.2f", total / 1000.0);
				String EndTime = time_formatter.format(System.currentTimeMillis());
				
				testresultdata.put(object.getProperty("ValidCodigo"),
						new Object[] {  "CodigoScreen-Valid Codigo",
								 		"User Enters Valid Codigo And Click Guarder Button With Attempt-"+i,
								 		"Create Pin Screen Should Be Displayed.", 
								 		"Create Pin Screen Is Not Displayed.", 
								 		"UnSuccess",
								 		"Fail", 
								 		StartTime, 
								 		EndTime, 
								 		totalTime + "seconds.", });

				logger.log(LogStatus.ERROR, "Error Trace Is : ", ExceptionUtils.getStackTrace(e));

				screenshot_Path = TestUtil.captureScreenShot(driver, "CodigoFail");
				image = logger.addScreenCapture(screenshot_Path);
				
				logger.log(LogStatus.INFO, "Codigo Screen: ", "Codigo Fail " + image);
				

														
				//SENDS ALERT MAIL ON FAIL
				
				System.out.println("Alert Mail Sending In Process !!");				
				String Message = "<b>Error Alert : </b> Codigo Validation Fail." + "<br>"
						+ "<b>Error Message Is : </b>" + driver.findElement(By.id(object.getProperty("ErrroWindowMesg"))).getText() + "<br>"
						+ "Check The Error Stacktrace & Attached Error ScreenShot.</b><br><br>";
				SendAlertMailTest.SendDetail(From, Password , TO, CC, "PYME Application Alert : Codigo Validation Fail " + formattedDate, 
				Message + ExceptionUtils.getStackTrace(e));
				System.out.println("Alert Mail Send For Codigo Validation Fail");
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);				
				System.out.println("Error Message " + driver.findElement(By.id(object.getProperty("ErrroWindowMesg"))).getText());
				
				driver.findElement(By.id(object.getProperty("Continuar"))).click();	
				System.out.println("Value Of i is " + i);
				i++;
				System.out.println("Value Of i is " + i);
				ReAttemptCodigo();
								
			}	
			
			logger.log(LogStatus.INFO, "CreatePin Verification:", "Expected-Create Pin Screen Should Get Displayed");
			Assert.assertEquals("PIN:", driver.findElement(By.id("com.popular.app.corp:id/textView4")).getText());
			logger.log(LogStatus.PASS, "CreatePin Verification:", "Actual-Create Pin Screen Is Displayed");	
		}
	
		
	public void ReAttemptCodigo() throws InterruptedException {
		
		try {		
			if (config.getProperty("App").equals("Production")) {
				if(i==3){
					System.out.println("Codigo Verification Fail Abort The Tests.");
					CodigoFailScenario();
					
				}else {
					AppSwitch();
					ValidCodigo();
				}
			} else if (config.getProperty("App").equals("Development")) {
				
				ValidCodigo();
			}
									
		} catch(Exception e) {
			
			System.out.println("Codigo Failed");
					
			String screenshot_Path = TestUtil.captureScreenShot(driver, "CodigoFail");
			String image = logger.addScreenCapture(screenshot_Path);
			
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			logger.log(LogStatus.FAIL, "Expected Screen Verification Fail", image);						
			extent.endTest(logger);
			extent.flush();				
			setupAfterSuite();				
			driver.quit();	
						
		}
		
	}
	
		
	public void CodigoFailScenario() throws InterruptedException, MessagingException, IOException, AWTException, DocumentException {
		
		try{
			logger.log(LogStatus.INFO, "CreatePin Verification:", "Expected-Create Pin Screen Should Get Displayed");
			Assert.assertEquals("Guardar", driver.findElement(By.id(object.getProperty("Guardar"))).getText());
			logger.log(LogStatus.PASS, "CreatePin Verification:", "Actual-Create Pin Screen Is Displayed");
			
		}catch(Exception e){
			
			String screenshot_Path = TestUtil.captureScreenShot(driver, "CodigoFail");
			String image = logger.addScreenCapture(screenshot_Path);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			logger.log(LogStatus.FAIL, "Expected Screen Verification Fail", image);
						
			extent.endTest(logger);
			extent.flush();
			
			setupAfterSuite();			
			QuitDriver();
			
		}
	  }
	}

