package dd_registration;

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

public class NewRegistration extends testCore {
	
	
	//@Test
	public void Get_UserInfo(){
		
		app_logs.debug("Get User Info On Account DashBoard.");
		logger = extent.startTest("TEST CASE- Get User Info On Account DashBoard.");
		
		try{
			Assert.assertEquals("Salir", driver.findElement(By.id("com.popular.app.corp:id/txtLogout")).getText());	
			
			String screenshot_Path = TestUtil.captureScreenShot(driver, "AccountDashBoard");
			String image = logger.addScreenCapture(screenshot_Path);	
			
			logger.log(LogStatus.INFO, "UserInformation - ", driver.findElement(By.id("com.popular.app.corp:id/txtnombre")).getText() );	
			logger.log(LogStatus.INFO, "Current Date - ", driver.findElement(By.id("com.popular.app.corp:id/txtDate")).getText() );	
			logger.log(LogStatus.INFO, "Information ScreenShot - ", image);	
			
			
		}catch(Exception e) {
			
			e.printStackTrace();
		}				
	}
	
	
	@Test
	public void Cerrar(){
		
		driver.findElement(By.id("com.popular.app.corp:id/txtLogout")).click();
	}
	
	
	@Test(priority = 1)
	public void PinScreen_NewRegistration(){
		
		driver.findElement(By.id("com.popular.app.corp:id/txtLink1")).click();

	}

	
	@Test(priority = 2)
	public void RegisterNew() throws InterruptedException{
		
		app_logs.debug("Valid Registration2 Attempt ");
		System.out.println("TEST CASE- Valid Registration2 : User Enters Correct Empress, Usario & Password.");
		logger = extent.startTest("TEST CASE- Valid Registration2 : User Enters Correct Empress, Usario & Password.");

		Assert.assertEquals("VINCULAR",driver.findElement(By.id("com.popular.app.corp:id/btnLogin")).getText());

		long start = System.currentTimeMillis();
		String StartTime = time_formatter.format(System.currentTimeMillis());
		
		if (config.getProperty("App").equalsIgnoreCase("Production")) {

			try {
				start = System.currentTimeMillis();
				StartTime = time_formatter.format(System.currentTimeMillis());
				driver.findElement(By.id("com.popular.app.corp:id/editBusinessName")).sendKeys(config.getProperty("EmpresaCorrect1"));
				long finish = System.currentTimeMillis();
				long total =  finish - start;
				String totalTime = String.format("%.2f", total / 1000.0);
				String EndTime =  time_formatter.format(System.currentTimeMillis());
				
				logger.log(LogStatus.INFO,"Registration Screen : Empresa","Enter Correct Empresa : " + config.getProperty("EmpresaCorrect1"));
				
				String screenshot_Path = TestUtil.captureScreenShot_Other(driver, "EmpresaCorrect1");
				String image = logger.addScreenCapture(screenshot_Path);				
				logger.log(LogStatus.INFO, "Registration Screen : Empresa" + config.getProperty("EmpresaCorrect1"),"Total Time Required To Enter Empresa: " + totalTime + " seconds" + image);
							
				testresultdata.put(object.getProperty("EmpresaCorrect1"),
						new Object[] { "Registration Screen-Valid Correct Empresa Attempt",
								 		"User Enters Correct Empresa: " + config.getProperty("EmpresaCorrect1"),
								 		config.getProperty("EmpresaCorrect1") + " Empresa Should Get Entered Properly", 
								 		config.getProperty("EmpresaCorrect1") + " Empresa Gets Entered Properly",  
								 		"Success",
								 		"Pass", 
								 		StartTime, 
								 		EndTime,
								 		totalTime + " seconds."});	

				Thread.sleep(1000l);
				
			} catch (Exception e) {
				
				long finish = System.currentTimeMillis();
				long total =  finish - start;
				String totalTime = String.format("%.2f", total / 1000.0);
				String EndTime =  time_formatter.format(System.currentTimeMillis());
				
				logger.log(LogStatus.ERROR, "Error Trace Is : ", ExceptionUtils.getStackTrace(e));
				
				System.out.println("Empresa Field Not Found");
								
				testresultdata.put(object.getProperty("EmpresaCorrect1"),
						new Object[] { "Registration Screen-Valid Empresa Attempt",
								 		"User Enters Correct Empresa: " + config.getProperty("EmpresaCorrect1"),
								 		config.getProperty("EmpresaCorrect1") + " Empresa Should Get Entered Properly", 
								 		config.getProperty("EmpresaCorrect1") + " Empresa Gets Entered Properly",  
								 		"UnSucess",
								 		"Fail", 
								 		StartTime, 
								 		EndTime,
								 		totalTime + " seconds."});	
			}
			
			
			try {
				
				start = System.currentTimeMillis();
				StartTime = time_formatter.format(System.currentTimeMillis());
				
				driver.findElement(By.id("com.popular.app.corp:id/editUsername")).sendKeys(config.getProperty("UsuarioCorrect1"));
				long finish = System.currentTimeMillis();
				long total =  finish - start;
				String totalTime = String.format("%.2f", total / 1000.0);
				String EndTime =  time_formatter.format(System.currentTimeMillis());
				
				logger.log(LogStatus.INFO,"Registration Screen : Usuario","User Enters Correct Usuario : " + config.getProperty("UsuarioCorrect1"));
				
				String screenshot_Path = TestUtil.captureScreenShot_Other(driver, "Wrong_Usuario");
				String image = logger.addScreenCapture(screenshot_Path);				
				logger.log(LogStatus.INFO, "Registration Screen : User Enters Correct Usuario","Total Time Required To Enter Usuario: " + totalTime + " seconds" + image);
				
				testresultdata.put(object.getProperty("UsuarioCorrect1"),
						new Object[] { "Registration Screen-Valid Usuario Attempt",
								 		"User Enters Correct Usuario: " + config.getProperty("UsuarioCorrect1"),
								 		config.getProperty("UsuarioCorrect1")+ " Usuario Should Get Entered Properly", 
								 		config.getProperty("UsuarioCorrect1")+ " Usuario Gets Entered Properly",  
								 		"Success",
								 		"Pass", 
								 		StartTime, 
								 		EndTime,
								 		totalTime + " seconds."});	
					
				Thread.sleep(1000l);
				
			} catch (Exception e) {
				
				long finish = System.currentTimeMillis();
				long total =  finish - start;
				String totalTime = String.format("%.2f", total / 1000.0);
				String EndTime =  time_formatter.format(System.currentTimeMillis());
				
				logger.log(LogStatus.ERROR, "Error Trace Is : ", ExceptionUtils.getStackTrace(e));
				
				System.out.println("Usuario Field Not Found");
				
				testresultdata.put(object.getProperty("UsuarioCorrect1"),
						new Object[] { "Registration Screen-Valid Usuario Attempt",
								 		"User Enters Correct Usuario: " + config.getProperty("UsuarioCorrect1"),
								 		config.getProperty("UsuarioCorrect1")+ " Usuario Should Get Entered Properly", 
								 		config.getProperty("UsuarioCorrect1")+ " Usuario Gets Entered Properly",  
								 		"UnSucess",
								 		"Fail", 
								 		StartTime, 
								 		EndTime,
								 		totalTime + " seconds."});
	
			}

			try {
				
				start = System.currentTimeMillis();
				StartTime = time_formatter.format(System.currentTimeMillis());
				
				driver.findElement(By.id("com.popular.app.corp:id/editPassword")).sendKeys(config.getProperty("PasswordCorrect"));
				long finish = System.currentTimeMillis();
				long total =  finish - start;
				String totalTime = String.format("%.2f", total / 1000.0);
				String EndTime =  time_formatter.format(System.currentTimeMillis());

				logger.log(LogStatus.INFO,"Registration Screen : Password","User Enters Correct Password : " + config.getProperty("PasswordCorrect"));
				
				String screenshot_Path = TestUtil.captureScreenShot_Other(driver, "Password_Prod");
				String image = logger.addScreenCapture(screenshot_Path);				
				logger.log(LogStatus.INFO, "Login Screen : User Enters Correct Password","Total Time Required To Enter Password: " + totalTime + " seconds" + image);
				
				testresultdata.put(object.getProperty("PasswordCorrect"),
						new Object[] { "Registration Screen-Valid Password Attempt",
								 		"User Enters Correct Password: " + config.getProperty("PasswordCorrect"),
								 		config.getProperty("PasswordCorrect")+ " Password Should Get Entered Properly", 
								 		config.getProperty("PasswordCorrect")+ " Password Gets Entered Properly",  
								 		"Success",
								 		"Pass", 
								 		StartTime, 
								 		EndTime,
								 		totalTime + " seconds."});	
					
				Thread.sleep(1000l);
				
			} catch (Exception e) {
				
				long finish = System.currentTimeMillis();
				long total =  finish - start;
				String totalTime = String.format("%.2f", total / 1000.0);
				String EndTime =  time_formatter.format(System.currentTimeMillis());
				
				logger.log(LogStatus.ERROR, "Error Trace Is : ", ExceptionUtils.getStackTrace(e));
				
				System.out.println("Password Field Not Found");
				
				testresultdata.put(object.getProperty("PasswordCorrect"),
						new Object[] { "Registration Screen-Valid Password Attempt",
								 		"User Enters Wrong Password: " + config.getProperty("PasswordCorrect"),
								 		config.getProperty("PasswordCorrect")+ " Password Should Get Entered Properly", 
								 		config.getProperty("PasswordCorrect")+ " Password Gets Entered Properly",  
								 		"UnSucess",
								 		"Fail", 
								 		StartTime, 
								 		EndTime,
								 		totalTime + " seconds."});		
			}

		} else if ((config.getProperty("App").equalsIgnoreCase("Development")))  {
			
			try {
				start = System.currentTimeMillis();
				StartTime = time_formatter.format(System.currentTimeMillis());
				driver.findElement(By.id("com.popular.app.corp:id/editBusinessName")).sendKeys(config.getProperty("EmpresaCorrect1"));
				long finish = System.currentTimeMillis();
				long total =  finish - start;
				String totalTime = String.format("%.2f", total / 1000.0);
				String EndTime =  time_formatter.format(System.currentTimeMillis());
				
				logger.log(LogStatus.INFO,"Registration Screen : Empresa","Enter Correct Empresa : " + config.getProperty("EmpresaCorrect1"));
				
				String screenshot_Path = TestUtil.captureScreenShot_Other(driver, "EmpresaCorrect1");
				String image = logger.addScreenCapture(screenshot_Path);				
				logger.log(LogStatus.INFO, "Registration Screen : Empresa" + config.getProperty("EmpresaCorrect1"),"Total Time Required To Enter Empresa: " + totalTime + " seconds" + image);
							
				testresultdata.put(object.getProperty("EmpresaCorrect1"),
						new Object[] { "Registration Screen-Valid Correct Empresa Attempt",
								 		"User Enters Correct Empresa: " + config.getProperty("EmpresaCorrect1"),
								 		config.getProperty("EmpresaCorrect1") + " Empresa Should Get Entered Properly", 
								 		config.getProperty("EmpresaCorrect1") + " Empresa Gets Entered Properly",  
								 		"Success",
								 		"Pass", 
								 		StartTime, 
								 		EndTime,
								 		totalTime + " seconds."});	

				Thread.sleep(1000l);
				
			} catch (Exception e) {
				
				long finish = System.currentTimeMillis();
				long total =  finish - start;
				String totalTime = String.format("%.2f", total / 1000.0);
				String EndTime =  time_formatter.format(System.currentTimeMillis());
				
				logger.log(LogStatus.ERROR, "Error Trace Is : ", ExceptionUtils.getStackTrace(e));
				
				System.out.println("Empresa Field Not Found");
								
				testresultdata.put(object.getProperty("EmpresaCorrect1"),
						new Object[] { "Registration Screen-Valid Empresa Attempt",
								 		"User Enters Correct Empresa: " + config.getProperty("EmpresaCorrect1"),
								 		config.getProperty("EmpresaCorrect1") + " Empresa Should Get Entered Properly", 
								 		config.getProperty("EmpresaCorrect1") + " Empresa Gets Entered Properly",  
								 		"UnSucess",
								 		"Fail", 
								 		StartTime, 
								 		EndTime,
								 		totalTime + " seconds."});	
			}
			
			
			try {
				
				start = System.currentTimeMillis();
				StartTime = time_formatter.format(System.currentTimeMillis());
				
				driver.findElement(By.id("com.popular.app.corp:id/editUsername")).sendKeys(config.getProperty("UsuarioCorrect1"));
				long finish = System.currentTimeMillis();
				long total =  finish - start;
				String totalTime = String.format("%.2f", total / 1000.0);
				String EndTime =  time_formatter.format(System.currentTimeMillis());
				
				logger.log(LogStatus.INFO,"Registration Screen : Usuario","User Enters Correct Usuario : " + config.getProperty("UsuarioCorrect1"));
				
				String screenshot_Path = TestUtil.captureScreenShot_Other(driver, "Wrong_Usuario");
				String image = logger.addScreenCapture(screenshot_Path);				
				logger.log(LogStatus.INFO, "Registration Screen : User Enters Correct Usuario","Total Time Required To Enter Usuario: " + totalTime + " seconds" + image);
				
				testresultdata.put(object.getProperty("UsuarioCorrect1"),
						new Object[] { "Registration Screen-Valid Usuario Attempt",
								 		"User Enters Correct Usuario: " + config.getProperty("UsuarioCorrect1"),
								 		config.getProperty("UsuarioCorrect1")+ " Usuario Should Get Entered Properly", 
								 		config.getProperty("UsuarioCorrect1")+ " Usuario Gets Entered Properly",  
								 		"Success",
								 		"Pass", 
								 		StartTime, 
								 		EndTime,
								 		totalTime + " seconds."});	
					
				Thread.sleep(1000l);
				
			} catch (Exception e) {
				
				long finish = System.currentTimeMillis();
				long total =  finish - start;
				String totalTime = String.format("%.2f", total / 1000.0);
				String EndTime =  time_formatter.format(System.currentTimeMillis());
				
				logger.log(LogStatus.ERROR, "Error Trace Is : ", ExceptionUtils.getStackTrace(e));
				
				System.out.println("Usuario Field Not Found");
				
				testresultdata.put(object.getProperty("UsuarioCorrect1"),
						new Object[] { "Registration Screen-Valid Usuario Attempt",
								 		"User Enters Correct Usuario: " + config.getProperty("UsuarioCorrect1"),
								 		config.getProperty("UsuarioCorrect1")+ " Usuario Should Get Entered Properly", 
								 		config.getProperty("UsuarioCorrect1")+ " Usuario Gets Entered Properly",  
								 		"UnSucess",
								 		"Fail", 
								 		StartTime, 
								 		EndTime,
								 		totalTime + " seconds."});
	
			}

			try {
				
				start = System.currentTimeMillis();
				StartTime = time_formatter.format(System.currentTimeMillis());
				
				driver.findElement(By.id("com.popular.app.corp:id/editPassword")).sendKeys(config.getProperty("PasswordCorrect"));
				long finish = System.currentTimeMillis();
				long total =  finish - start;
				String totalTime = String.format("%.2f", total / 1000.0);
				String EndTime =  time_formatter.format(System.currentTimeMillis());

				logger.log(LogStatus.INFO,"Registration Screen : Password","User Enters Correct Password : " + config.getProperty("PasswordCorrect"));
				
				String screenshot_Path = TestUtil.captureScreenShot_Other(driver, "Password_Prod");
				String image = logger.addScreenCapture(screenshot_Path);				
				logger.log(LogStatus.INFO, "Login Screen : User Enters Correct Password","Total Time Required To Enter Password: " + totalTime + " seconds" + image);
				
				testresultdata.put(object.getProperty("PasswordCorrect"),
						new Object[] { "Registration Screen-Valid Password Attempt",
								 		"User Enters Correct Password: " + config.getProperty("PasswordCorrect"),
								 		config.getProperty("PasswordCorrect")+ " Password Should Get Entered Properly", 
								 		config.getProperty("PasswordCorrect")+ " Password Gets Entered Properly",  
								 		"Success",
								 		"Pass", 
								 		StartTime, 
								 		EndTime,
								 		totalTime + " seconds."});	
					
				Thread.sleep(1000l);
				
			} catch (Exception e) {
				
				long finish = System.currentTimeMillis();
				long total =  finish - start;
				String totalTime = String.format("%.2f", total / 1000.0);
				String EndTime =  time_formatter.format(System.currentTimeMillis());
				
				logger.log(LogStatus.ERROR, "Error Trace Is : ", ExceptionUtils.getStackTrace(e));
				
				System.out.println("Password Field Not Found");
				
				testresultdata.put(object.getProperty("PasswordCorrect"),
						new Object[] { "Registration Screen-Valid Password Attempt",
								 		"User Enters Wrong Password: " + config.getProperty("PasswordCorrect"),
								 		config.getProperty("PasswordCorrect")+ " Password Should Get Entered Properly", 
								 		config.getProperty("PasswordCorrect")+ " Password Gets Entered Properly",  
								 		"UnSucess",
								 		"Fail", 
								 		StartTime, 
								 		EndTime,
								 		totalTime + " seconds."});		
			}
			
		}
			
		String screenshot_Path = TestUtil.captureScreenShot(driver, "VincularClick");
		String image = logger.addScreenCapture(screenshot_Path);
		
		if ("VINCULAR".equalsIgnoreCase(driver.findElement(By.id("com.popular.app.corp:id/btnLogin")).getText())) {

			logger.log(LogStatus.INFO, "Registration Screen", "User Clicks On Vincular Button" + image);	
			
			start = System.currentTimeMillis();
			StartTime = time_formatter.format(System.currentTimeMillis());

			driver.findElement(By.id("com.popular.app.corp:id/btnLogin")).click();
			Thread.sleep(500l);
									
			try {				
				Assert.assertEquals("Continuar",driver.findElement(By.id("com.popular.app.corp:id/btnContinuar")).getText());
				
				long finish = System.currentTimeMillis();
				long total =  finish - start;
				String totalTime = String.format("%.2f", total / 1000.0);
				String EndTime =  time_formatter.format(System.currentTimeMillis());
				
				testresultdata.put(object.getProperty("AccederButtonValid"),
						new Object[] { "Registration Screen-Valid Registration",
								 		"Click On Acceder Button With Valid Registration Details Should Display Codigo Screen",
								 		"Codigo Screen : Welcome Message - Ingresa el código de seguridad desplegado en tu Token Popular: should be displayed.",
								 		"Codigo Screen : Welcome Message - " + driver.findElement(By.id("com.popular.app.corp:id/txtCodegoInfo")).getText() + " Is Displayed",   
								 		"Success",
								 		"Pass", 
								 		StartTime, 
								 		EndTime,
								 		totalTime + " seconds."});																				
								
			} catch (Exception e) {

				System.out.println("Waiting Few More 120 Seconds For The Response");
				Thread.sleep(120000);
				
				logger.log(LogStatus.ERROR, "Error Trace Is : ", ExceptionUtils.getStackTrace(e));
								
				System.out.println("Registration Valid Scenario Failed ");
				
				long finish = System.currentTimeMillis();
				long total =  finish - start;
				String totalTime = String.format("%.2f", total / 1000.0);
				String EndTime =  time_formatter.format(System.currentTimeMillis());
				
				testresultdata.put(object.getProperty("AccederButtonValid"),
						new Object[] { "Registration Screen-Valid Registration",
								 		"Click On Acceder Button With Valid Registration Details",
								 		"Error Alert- " + driver.findElement(By.id("android:id/message")).getText() + " Should Get Displayed", 
								 		"Correct Error Alert- " + driver.findElement(By.id("android:id/message")).getText() + " Is Displayed",   
								 		"UnSucess",
								 		"Fail", 
								 		StartTime, 
								 		EndTime,
								 		totalTime + " seconds."});	
			
				
				//EDITED
				screenshot_Path = TestUtil.captureScreenShot(driver, "ValidRegistrationFail");
				image = logger.addScreenCapture(screenshot_Path);	
				logger.log(LogStatus.INFO, "Error Alert PopUp", "User Clicks On Continuar Button On Alert Pop Up" + image);
				driver.findElement(By.id("android:id/button1")).click();
			}
		}
		
		logger.log(LogStatus.INFO, "Codigo Screen Verification:", "Expected-Codigo Screen Should Get Displayed");
		Assert.assertEquals("Continuar",driver.findElement(By.id("com.popular.app.corp:id/btnContinuar")).getText());
		logger.log(LogStatus.PASS, "Codigo Screen Verification:", "Actual-Codigo Screen Is Displayed");	

	}

	
	@Test(priority = 3)
	public void RegisterNew_Codigo() {
		
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
								 		"User Enters Valid Codigo With Attempt-",
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
								 		"User Enters Valid Codigo And Click Guarder Button With Attempt-",
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
				String Message = "<b>Error Alert : </b> Codigo Validation Fail." + "<br>"
						+ "<b>Error Message Is : </b>" + driver.findElement(By.id(object.getProperty("ErrroWindowMesg"))).getText() + "<br>"
						+ "Check The Error Stacktrace & Attached Error ScreenShot.</b><br><br>";
				SendAlertMailTest.SendDetail(From, Password , TO, CC, "BPD Application Alert : Login Access Fail " + formattedDate, 
				Message + ExceptionUtils.getStackTrace(e));
				System.out.println("Alert Send Via Mail For Codigo Validation Fail");
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				
				System.out.println("Error Message " + driver.findElement(By.id(object.getProperty("ErrroWindowMesg"))).getText());
				
				driver.findElement(By.id(object.getProperty("Continuar"))).click();	
								
			}	
			
			logger.log(LogStatus.INFO, "CreatePin Verification:", "Expected-Create Pin Screen Should Get Displayed");
			Assert.assertEquals("PIN:", driver.findElement(By.id("com.popular.app.corp:id/textView4")).getText());
			logger.log(LogStatus.PASS, "CreatePin Verification:", "Actual-Create Pin Screen Is Displayed");	
	}

	
	@Test(priority = 4)
	public void RegisterNew_Pin(){
		
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
	}
		


}

