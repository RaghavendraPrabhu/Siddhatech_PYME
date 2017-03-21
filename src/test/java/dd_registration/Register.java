package dd_registration;

import java.awt.AWTException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.mail.MessagingException;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import dd_testCore.testCore;
import dd_util.SendAlertMailTest;
import dd_util.TestUtil;

import org.testng.Assert;


public class Register extends testCore {
	
	//@Test
	public void FooterMenus(){
		
		app_logs.debug("Verify Registeration Footer Links.");
		logger = extent.startTest("TEST CASE-Register Screen : Verfiy Placeholder Texts.");
		
		if(config.getProperty("Link1").equalsIgnoreCase(driver.findElement(By.id("com.popular.app.corp:id/txtLink1")).getText())){
			
			logger.log(LogStatus.PASS, "Regístrate Link Is Present : ", driver.findElement(By.id("com.popular.app.corp:id/txtLink1")).getText());
			
			testresultdata.put(object.getProperty("Link1"),
					new Object[] {"FooterLink1 - Regístrate", 
							"Regístrate Link Verification.",
							"Regístrate Should Be Available.",
							 driver.findElement(By.id("com.popular.app.corp:id/txtLink1")).getText() + " Is Available.",
							"Sucess",
							"Pass", 
							"N/A", 
							"N/A",
							"N/A", });	
			
		}else{
			
			logger.log(LogStatus.FAIL, "Regístrate Link Is Not Present : ", "Present Text Name : " + driver.findElement(By.id("com.popular.app.corp:id/txtLink1")).getText());
			
			testresultdata.put(object.getProperty("Link1"),
					new Object[] {"FooterLink1 - Regístrate", 
							"Regístrate Link Verification.",
							"Regístrate Should Be Available.",
							 driver.findElement(By.id("com.popular.app.corp:id/txtLink1")).getText() + " Is Available Link.",
							"Sucess",
							"Pass", 
							"N/A", 
							"N/A",
							"N/A", });
		}
		
		if(config.getProperty("Link2").equalsIgnoreCase(driver.findElement(By.id("com.popular.app.corp:id/txtLink2")).getText())){
			
			logger.log(LogStatus.PASS, "Sucursales/ ATMs Link Is Present : ", driver.findElement(By.id("com.popular.app.corp:id/txtLink2")).getText());
			
			testresultdata.put(object.getProperty("Link2"),
					new Object[] {"FooterLink2 - Sucursales/ ATMs", 
							"Sucursales/ ATMs Link Verification.",
							"Sucursales/ ATMs Should Be Available.",
							 driver.findElement(By.id("com.popular.app.corp:id/txtLink2")).getText() + " Is Available.",
							"Sucess",
							"Pass", 
							"N/A", 
							"N/A",
							"N/A", });	
			
		}else{
			
			logger.log(LogStatus.FAIL, "Sucursales/ ATM Link Is Not Present : ", "Present Text Name : " + driver.findElement(By.id("com.popular.app.corp:id/txtLink2")).getText());
			
			testresultdata.put(object.getProperty("Link2"),
					new Object[] {"FooterLink2 - Sucursales/ ATMs", 
							"Sucursales/ ATMs Link Verification.",
							"Sucursales/ ATMs Should Be Available.",
							 driver.findElement(By.id("com.popular.app.corp:id/txtLink2")).getText() + " Is Available Link.",
							"Sucess",
							"Pass", 
							"N/A", 
							"N/A",
							"N/A", });	
		}
	
		if(config.getProperty("Link3").equalsIgnoreCase(driver.findElement(By.id("com.popular.app.corp:id/txtLink3")).getText())){
		
			logger.log(LogStatus.PASS, "Novedades Link Is Present : ", driver.findElement(By.id("com.popular.app.corp:id/txtLink3")).getText());
			
			testresultdata.put(object.getProperty("Link3"),
					new Object[] {"FooterLink3 - Novedades", 
							"Novedades Link Verification.",
							"Novedades Should Be Available.",
							 driver.findElement(By.id("com.popular.app.corp:id/txtLink3")).getText() + " Is Available.",
							"Sucess",
							"Pass", 
							"N/A", 
							"N/A",
							"N/A", });	
			
		}else{
		
			logger.log(LogStatus.FAIL, "Novedades Link Is Not Present : ", "Present Text Name : " + driver.findElement(By.id("com.popular.app.corp:id/txtLink3")).getText());
			
			testresultdata.put(object.getProperty("Link3"),
					new Object[] {"FooterLink3 - Novedades", 
							"Novedades Link Verification.",
							"Novedades Should Be Available.",
							 driver.findElement(By.id("com.popular.app.corp:id/txtLink3")).getText() + " Is Available Link.",
							"Sucess",
							"Pass", 
							"N/A", 
							"N/A",
							"N/A", });	
		}
			
		
	}
	
	
	//@Test(priority = 2)
	public void VerifyRegisterForm() {
		
		app_logs.debug("Verify Register Form.");
		logger = extent.startTest("TEST CASE-Register Screen : Verfiy Placeholder Texts.");
		
		try{
		
			if(config.getProperty("Empresa").equalsIgnoreCase(driver.findElement(By.id("com.popular.app.corp:id/editBusinessName")).getText())){	
				System.out.println(driver.findElement(By.id("com.popular.app.corp:id/editBusinessName")).getText() + " Placeholder Text Is Present");
				
				logger.log(LogStatus.PASS, "Empressa Placeholder Text Is - ", driver.findElement(By.id("com.popular.app.corp:id/editBusinessName")).getText());
					
					testresultdata.put(object.getProperty("Empressaplaceholder"),
							new Object[] {"Empresa", 
									"Empresa Placeholder Text Verification.",
									 config.getProperty("Empresa") + " Should Be Available.",
									 driver.findElement(By.id("com.popular.app.corp:id/editBusinessName")).getText() + " Is Available.",
									"Sucess",
									"Pass", 
									"N/A", 
									"N/A",
									"N/A", });	
					
				} else {
					System.out.println(driver.findElement(By.id("com.popular.app.corp:id/editBusinessName")).getText() + " Is The Found Placeholder Text.");
					
					logger.log(LogStatus.FAIL, "Present Empressa Placeholder Text Is - ", driver.findElement(By.id("com.popular.app.corp:id/editBusinessName")).getText());			
					testresultdata.put(object.getProperty("Empressaplaceholder"),
							new Object[] {"Empresa", 
									"Empresa Placeholder Text Verification.",
									config.getProperty("Empresa") + " Should Be Available.",
									 driver.findElement(By.id("com.popular.app.corp:id/editBusinessName")).getText() + " Is Available.",
									"UnSucess",
									"Fail", 
									"N/A", 
									"N/A",
									"N/A", });				
				}
			
		}catch (Exception e) {
			
			e.printStackTrace();
			System.out.println("Empressa Field Error. Check Empress Field PlaceHolder Text");
		}
		
		
		try{
						
			if(config.getProperty("Usuario").equalsIgnoreCase(driver.findElement(By.id("com.popular.app.corp:id/editUsername")).getText())){	
				
				System.out.println(driver.findElement(By.id("com.popular.app.corp:id/editUsername")).getText() + " Placeholder Text Is Present");
				logger.log(LogStatus.PASS, "Usuario Placeholder Text Is - ", driver.findElement(By.id("com.popular.app.corp:id/editUsername")).getText());
					
					testresultdata.put(object.getProperty("Usuarioplaceholder"),
							new Object[] {"Usuario", 
									"Usuario Placeholder Text Verification.",
									config.getProperty("Usuario") + " Should Be Available.",
									 driver.findElement(By.id("com.popular.app.corp:id/editUsername")).getText() + " Is Available.",
									"Sucess",
									"Pass", 
									"N/A", 
									"N/A",
									"N/A", });	
					
				}else {
					
					System.out.println(driver.findElement(By.id("com.popular.app.corp:id/editUsername")).getText() + " Is The Found Placeholder Text.");
					logger.log(LogStatus.FAIL, "Present Usuario Placeholder Text Is - ", driver.findElement(By.id("com.popular.app.corp:id/editUsername")).getText());
					
					testresultdata.put(object.getProperty("Usuarioplaceholder"),
							new Object[] {"Usuario", 
									"Usuario Placeholder Text Verification.",
									config.getProperty("Usuario") + " Should Be Available.",
									 driver.findElement(By.id("com.popular.app.corp:id/editUsername")).getText() + " Is Available.",
									"UnSucess",
									"Fail", 
									"N/A", 
									"N/A",
									"N/A", });	
					
				}
						
		}catch (Exception e){
			e.printStackTrace();
			System.out.println("Usuario Field Error. Check Usuario Field PlaceHolder Text");
		}
		

		try{			
			if(config.getProperty("Password").equalsIgnoreCase(driver.findElement(By.id("com.popular.app.corp:id/editPassword")).getText())){	
				
				System.out.println(driver.findElement(By.id("com.popular.app.corp:id/editPassword")).getText() + " Placeholder Text Is Present");
				System.out.println("TESTING5");	
				logger.log(LogStatus.PASS, "Password Placeholder Text Is - ", driver.findElement(By.id("com.popular.app.corp:id/editPassword")).getText());
					
					testresultdata.put(object.getProperty("Passwordplaceholder"),
							new Object[] {"Password", 
									"Password Placeholder Text Verification.",
									 config.getProperty("Password") + " Should Be Available.",
									 driver.findElement(By.id("com.popular.app.corp:id/editPassword")).getText() + " Is Available.",
									"Sucess",
									"Pass", 
									"N/A", 
									"N/A",
									"N/A", });	
					
				}else {
					
					System.out.println(driver.findElement(By.id("com.popular.app.corp:id/editPassword")).getText() + " Is The Found Placeholder Text.");
					System.out.println("TESTING6");	
					logger.log(LogStatus.FAIL, "Present Password Placeholder Text Is - ", driver.findElement(By.id("com.popular.app.corp:id/editPassword")).getText());
					
					testresultdata.put(object.getProperty("Passwordplaceholder"),
							new Object[] {"Password", 
									"Password Placeholder Text Verification.",
									 config.getProperty("Password") + " Should Be Available.",
									 driver.findElement(By.id("com.popular.app.corp:id/editPassword")).getText() + " Is Available.",
									"UnSucess",
									"Fail", 
									"N/A", 
									"N/A",
									"N/A", });	
					
				}
			
		}catch (Exception e){
			e.printStackTrace();
			System.out.println("Password Field Error. Check Password Field PlaceHolder Text");
		}
		

		try{
			
			if(config.getProperty("Acceder").equalsIgnoreCase(driver.findElement(By.id("com.popular.app.corp:id/btnLogin")).getText())){	
				
				System.out.println(driver.findElement(By.id("com.popular.app.corp:id/btnLogin")).getText() + " Placeholder Text Is Present");
				System.out.println("TESTING5");	
				logger.log(LogStatus.PASS, "Password Placeholder Text Is - ", driver.findElement(By.id("com.popular.app.corp:id/btnLogin")).getText());
					
					testresultdata.put(object.getProperty("Accederplaceholder"),
							new Object[] {"Acceder", 
									"Acceder Placeholder Text Verification.",
									config.getProperty("Acceder") + " Should Be Available.",
									 driver.findElement(By.id("com.popular.app.corp:id/btnLogin")).getText() + " Is Available.",
									"Sucess",
									"Pass", 
									"N/A", 
									"N/A",
									"N/A", });	
					
				}else {
					
					System.out.println(driver.findElement(By.id("com.popular.app.corp:id/btnLogin")).getText() + " Is The Found Placeholder Text.");
					System.out.println("TESTING6");	
					logger.log(LogStatus.FAIL, "Present Password Placeholder Text Is - ", driver.findElement(By.id("com.popular.app.corp:id/btnLogin")).getText());
					
					testresultdata.put(object.getProperty("Accederplaceholder"),
							new Object[] {"Acceder", 
									"Acceder Placeholder Text Verification.",
									config.getProperty("Acceder") + " Should Be Available.",
									 driver.findElement(By.id("com.popular.app.corp:id/btnLogin")).getText() + " Is Available.",
									"UnSucess",
									"Fail", 
									"N/A", 
									"N/A",
									"N/A", });	
					
				}
			
			
		}catch (Exception e) {
			
			e.printStackTrace();
			System.out.println("Acceder Field Error. Check Acceder Button PlaceHolder Text");
		}
			
	}

	
	//@Test(priority = 3, dependsOnMethods = "VerifyRegisterForm")
	public void BlankRegistration() throws InterruptedException, MessagingException, IOException, AWTException {
		
		app_logs.debug("BlankLogin.");
		
		System.out.println("TEST CASE- BlankLogin : Attempt Blank Registration");
		logger = extent.startTest("TEST CASE- BlankLogin : Attempt Blank Registration");
		
		String screenshot_Path = TestUtil.captureScreenShot(driver, "AccederClick");
		String image = logger.addScreenCapture(screenshot_Path);
		
		if ("ACCEDER".equalsIgnoreCase(driver.findElement(By.id("com.popular.app.corp:id/btnLogin")).getText())) {

			logger.log(LogStatus.INFO, "Login Screen", "User Clicks On Acceder Button" + image);	
			
			long start = System.currentTimeMillis();
			String StartTime = time_formatter.format(System.currentTimeMillis());
	
			driver.findElement(By.id("com.popular.app.corp:id/btnLogin")).click();;
			Thread.sleep(500l);
									
			try {								
				Assert.assertEquals("Error",driver.findElement(By.id("android:id/alertTitle")).getText());
				
				long finish = System.currentTimeMillis();
				long total =  finish - start;
				String totalTime = String.format("%.2f", total / 1000.0);
				String EndTime =  time_formatter.format(System.currentTimeMillis());
								
				testresultdata.put(object.getProperty("BlankLogin"),
						new Object[] { "Registration Screen-Blank Attempt",
								 		"Click On Acceder Button Without Data",
								 		"Error Alert- " + driver.findElement(By.id("android:id/message")).getText() + " Should Get Displayed", 
								 		"Correct Error Alert- " + driver.findElement(By.id("android:id/message")).getText() + " Is Displayed",  
								 		"Success",
								 		"Pass", 
								 		StartTime, 
								 		EndTime,
								 		totalTime + " seconds."});	
				
				screenshot_Path = TestUtil.captureScreenShot(driver, "BlankLoginPass");
				image = logger.addScreenCapture(screenshot_Path);		
				
				logger.log(LogStatus.INFO, "Error Alert PopUp", "User Clicks On Continuar Button On Alert Pop Up" + image);					
				System.out.println("Error Message Content Is : "+ driver.findElement(By.id("android:id/message")).getText());	
				logger.log(LogStatus.INFO, "Error Message-", driver.findElement(By.id("android:id/message")).getText());	
				
				driver.findElement(By.id("android:id/button1")).click();
				
								
			} catch (Exception e) {

				logger.log(LogStatus.ERROR, "Error Trace Is : ", ExceptionUtils.getStackTrace(e));
								
				System.out.println("Login Blank Scenario Failed ");
				
				long finish = System.currentTimeMillis();
				long total =  finish - start;
				String totalTime = String.format("%.2f", total / 1000.0);
				String EndTime =  time_formatter.format(System.currentTimeMillis());
							
				testresultdata.put(object.getProperty("BlankLogin"),
						new Object[] { "Registration Screen-Blank Attempt",
								 		"Click On Continuar Button Without Data",
								 		"Error Alert- " + driver.findElement(By.id("android:id/message")).getText() + " Should Get Displayed", 
								 		"Correct Error Alert- " + driver.findElement(By.id("android:id/message")).getText() + " Is Displayed",  
								 		"UnSuccess",
								 		"Fail", 
								 		StartTime, 
								 		EndTime,
								 		totalTime + " seconds."});					
				
				//EDITED
				screenshot_Path = TestUtil.captureScreenShot(driver, "BlankLoginFail");
				image = logger.addScreenCapture(screenshot_Path);	
				logger.log(LogStatus.INFO, "Error Alert PopUp", "User Clicks On Continuar Button On Alert Pop Up" + image);
				
				driver.findElement(By.id("android:id/button1")).click();
				
			}
		}	
	}
		
	
	//@Test(priority = 4, dependsOnMethods = "BlankRegistration")
	public void InValidRegistration() throws InterruptedException, MessagingException, IOException, AWTException {

		app_logs.debug("InValid Registration Attempt ");

		System.out.println("TEST CASE- InValid Registration : User Enters Wrong Empress, Usario & Password.");
		logger = extent.startTest("TEST CASE- InValid Registration : User Enters Wrong Empress, Usario & Password.");

		Assert.assertEquals("ACCEDER",driver.findElement(By.id("com.popular.app.corp:id/btnLogin")).getText());

		long start = System.currentTimeMillis();
		String StartTime = time_formatter.format(System.currentTimeMillis());
		
		if (config.getProperty("App").equalsIgnoreCase("Production")) {

			try {
				start = System.currentTimeMillis();
				StartTime = time_formatter.format(System.currentTimeMillis());
				driver.findElement(By.id("com.popular.app.corp:id/editBusinessName")).sendKeys(config.getProperty("Empresawrong"));
				long finish = System.currentTimeMillis();
				long total =  finish - start;
				String totalTime = String.format("%.2f", total / 1000.0);
				String EndTime =  time_formatter.format(System.currentTimeMillis());
				
				logger.log(LogStatus.INFO,"Registration Screen : Empresa","Enter Wrong Empresa : " + config.getProperty("Empresawrong"));
				
				String screenshot_Path = TestUtil.captureScreenShot_Other(driver, "Wrong_Empresa");
				String image = logger.addScreenCapture(screenshot_Path);				
				logger.log(LogStatus.INFO, "Registration Screen : Empresa" + config.getProperty("Empresawrong"),"Total Time Required To Enter Empresa: " + totalTime + " seconds" + image);
							
				testresultdata.put(object.getProperty("Wrong_Empresa"),
						new Object[] { "Registration Screen-InValid Empresa Attempt",
								 		"User Enters Wrong Empresa: " + config.getProperty("Empresawrong"),
								 		config.getProperty("Empresawrong") + " Empresa Should Get Entered Properly", 
								 		config.getProperty("Empresawrong") + " Empresa Gets Entered Properly",  
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
								
				testresultdata.put(object.getProperty("Wrong_Empresa"),
						new Object[] { "Registration Screen-InValid Empresa Attempt",
								 		"User Enters Wrong Empresa: " + config.getProperty("Empresawrong"),
								 		config.getProperty("Empresawrong") + " Empresa Should Get Entered Properly", 
								 		config.getProperty("Empresawrong") + " Empresa Gets Entered Properly",  
								 		"UnSucess",
								 		"Fail", 
								 		StartTime, 
								 		EndTime,
								 		totalTime + " seconds."});	
			}
			
			
			try {
				
				start = System.currentTimeMillis();
				StartTime = time_formatter.format(System.currentTimeMillis());
				
				driver.findElement(By.id("com.popular.app.corp:id/editUsername")).sendKeys(config.getProperty("Usuariowrong"));
				long finish = System.currentTimeMillis();
				long total =  finish - start;
				String totalTime = String.format("%.2f", total / 1000.0);
				String EndTime =  time_formatter.format(System.currentTimeMillis());
				
				logger.log(LogStatus.INFO,"Registration Screen : Usuario","User Enters Wrong Usuario : " + config.getProperty("Usuariowrong"));
				
				String screenshot_Path = TestUtil.captureScreenShot_Other(driver, "Wrong_Usuario");
				String image = logger.addScreenCapture(screenshot_Path);				
				logger.log(LogStatus.INFO, "Registration Screen : User Enters Wrong Usuario","Total Time Required To Enter Usuario: " + totalTime + " seconds" + image);
				
				testresultdata.put(object.getProperty("Wrong_Usuario"),
						new Object[] { "Registration Screen-InValid Usuario Attempt",
								 		"User Enters Wrong Usuario: " + config.getProperty("Usuariowrong"),
								 		config.getProperty("Usuariowrong")+ " Usuario Should Get Entered Properly", 
								 		config.getProperty("Usuariowrong")+ " Usuario Gets Entered Properly",  
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
				
				testresultdata.put(object.getProperty("Wrong_Usuario"),
						new Object[] { "Registration Screen-InValid Usuario Attempt",
								 		"User Enters Wrong Usuario: " + config.getProperty("Usuariowrong"),
								 		config.getProperty("Usuariowrong")+ " Usuario Should Get Entered Properly", 
								 		config.getProperty("Usuariowrong")+ " Usuario Gets Entered Properly",  
								 		"UnSucess",
								 		"Fail", 
								 		StartTime, 
								 		EndTime,
								 		totalTime + " seconds."});
	
			}

			try {
				
				start = System.currentTimeMillis();
				StartTime = time_formatter.format(System.currentTimeMillis());
				
				driver.findElement(By.id("com.popular.app.corp:id/editPassword")).sendKeys(config.getProperty("Passwordwrong"));
				long finish = System.currentTimeMillis();
				long total =  finish - start;
				String totalTime = String.format("%.2f", total / 1000.0);
				String EndTime =  time_formatter.format(System.currentTimeMillis());

				logger.log(LogStatus.INFO,"Registration Screen : Password","User Enters Wrong Password : " + config.getProperty("Passwordwrong"));
				
				String screenshot_Path = TestUtil.captureScreenShot_Other(driver, "Password_Prod");
				String image = logger.addScreenCapture(screenshot_Path);				
				logger.log(LogStatus.INFO, "Login Screen : User Enters Wrong Password","Total Time Required To Enter Password: " + totalTime + " seconds" + image);
				
				testresultdata.put(object.getProperty("Wrong_Password"),
						new Object[] { "Registration Screen-InValid Password Attempt",
								 		"User Enters Wrong Password: " + config.getProperty("Passwordwrong"),
								 		config.getProperty("Passwordwrong")+ " Password Should Get Entered Properly", 
								 		config.getProperty("Passwordwrong")+ " Password Gets Entered Properly",  
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
				
				testresultdata.put(object.getProperty("Wrong_Password"),
						new Object[] { "Registration Screen-InValid Password Attempt",
								 		"User Enters Wrong Password: " + config.getProperty("Passwordwrong"),
								 		config.getProperty("Passwordwrong")+ " Password Should Get Entered Properly", 
								 		config.getProperty("Passwordwrong")+ " Password Gets Entered Properly",  
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
				driver.findElement(By.id("com.popular.app.corp:id/editBusinessName")).sendKeys(config.getProperty("Empresawrong"));
				long finish = System.currentTimeMillis();
				long total =  finish - start;
				String totalTime = String.format("%.2f", total / 1000.0);
				String EndTime =  time_formatter.format(System.currentTimeMillis());

				logger.log(LogStatus.INFO,"Registration Screen : Empresa","Enter Wrong Empresa : " + config.getProperty("Empresawrong"));
				
				String screenshot_Path = TestUtil.captureScreenShot_Other(driver, "Wrong_Empresa");
				String image = logger.addScreenCapture(screenshot_Path);				
				logger.log(LogStatus.INFO, "Registration Screen : Empresa" + config.getProperty("Empresawrong"),"Total Time Required To Enter Empresa: " + totalTime + " seconds" + image);
							
				testresultdata.put(object.getProperty("Wrong_Empresa"),
						new Object[] { "Registration Screen-InValid Empresa Attempt",
								 		"User Enters Wrong Empresa: " + config.getProperty("Empresawrong"),
								 		config.getProperty("Empresawrong") + " Empresa Should Get Entered Properly", 
								 		config.getProperty("Empresawrong") + " Empresa Gets Entered Properly",  
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
								
				testresultdata.put(object.getProperty("Wrong_Empresa"),
						new Object[] { "Registration Screen-InValid Empresa Attempt",
								 		"User Enters Wrong Empresa: " + config.getProperty("Empresawrong"),
								 		config.getProperty("Empresawrong") + " Empresa Should Get Entered Properly", 
								 		config.getProperty("Empresawrong") + " Empresa Gets Entered Properly",  
								 		"UnSucess",
								 		"Fail", 
								 		StartTime, 
								 		EndTime,
								 		totalTime + " seconds."});	
			}
			
			
			try {
				
				start = System.currentTimeMillis();
				StartTime = time_formatter.format(System.currentTimeMillis());
				
				driver.findElement(By.id("com.popular.app.corp:id/editUsername")).sendKeys(config.getProperty("Usuariowrong"));
				long finish = System.currentTimeMillis();
				long total =  finish - start;
				String totalTime = String.format("%.2f", total / 1000.0);
				String EndTime =  time_formatter.format(System.currentTimeMillis());

				logger.log(LogStatus.INFO,"Registration Screen : Usuario","User Enters Wrong Usuario : " + config.getProperty("Usuariowrong"));
				
				String screenshot_Path = TestUtil.captureScreenShot_Other(driver, "Wrong_Usuario");
				String image = logger.addScreenCapture(screenshot_Path);				
				logger.log(LogStatus.INFO, "Registration Screen : User Enters Wrong Usuario","Total Time Required To Enter Usuario: " + totalTime + " seconds" + image);
				
				testresultdata.put(object.getProperty("Wrong_Usuario"),
						new Object[] { "Registration Screen-InValid Usuario Attempt",
								 		"User Enters Wrong Usuario: " + config.getProperty("Usuariowrong"),
								 		config.getProperty("Usuariowrong")+ " Usuario Should Get Entered Properly", 
								 		config.getProperty("Usuariowrong")+ " Usuario Gets Entered Properly",  
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
				
				testresultdata.put(object.getProperty("Wrong_Usuario"),
						new Object[] { "Registration Screen-InValid Usuario Attempt",
								 		"User Enters Wrong Usuario: " + config.getProperty("Usuariowrong"),
								 		config.getProperty("Usuariowrong")+ " Usuario Should Get Entered Properly", 
								 		config.getProperty("Usuariowrong")+ " Usuario Gets Entered Properly",  
								 		"UnSucess",
								 		"Fail", 
								 		StartTime, 
								 		EndTime,
								 		totalTime + " seconds."});
	
			}

			try {
				
				start = System.currentTimeMillis();
				StartTime = time_formatter.format(System.currentTimeMillis());
				
				driver.findElement(By.id("com.popular.app.corp:id/editPassword")).sendKeys(config.getProperty("Passwordwrong"));
				long finish = System.currentTimeMillis();
				long total =  finish - start;
				String totalTime = String.format("%.2f", total / 1000.0);
				String EndTime =  time_formatter.format(System.currentTimeMillis());

				logger.log(LogStatus.INFO,"Registration Screen : Password","User Enters Wrong Password : " + config.getProperty("Passwordwrong"));
				
				String screenshot_Path = TestUtil.captureScreenShot_Other(driver, "Password_Prod");
				String image = logger.addScreenCapture(screenshot_Path);				
				logger.log(LogStatus.INFO, "Login Screen : User Enters Wrong Password","Total Time Required To Enter Password: " + totalTime + " seconds" + image);
				
				testresultdata.put(object.getProperty("Wrong_Password"),
						new Object[] { "Registration Screen-InValid Password Attempt",
								 		"User Enters Wrong Password: " + config.getProperty("Passwordwrong"),
								 		config.getProperty("Passwordwrong")+ " Password Should Get Entered Properly", 
								 		config.getProperty("Passwordwrong")+ " Password Gets Entered Properly",  
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
				
				testresultdata.put(object.getProperty("Wrong_Password"),
						new Object[] { "Registration Screen-InValid Password Attempt",
								 		"User Enters Wrong Password: " + config.getProperty("Passwordwrong"),
								 		config.getProperty("Passwordwrong")+ " Password Should Get Entered Properly", 
								 		config.getProperty("Passwordwrong")+ " Password Gets Entered Properly",  
								 		"UnSucess",
								 		"Fail", 
								 		StartTime, 
								 		EndTime,
								 		totalTime + " seconds."});		
			}
			
		}
		
		
		String screenshot_Path = TestUtil.captureScreenShot(driver, "AccederClick");
		String image = logger.addScreenCapture(screenshot_Path);
		
		if ("ACCEDER".equalsIgnoreCase(driver.findElement(By.id("com.popular.app.corp:id/btnLogin")).getText())) {

			logger.log(LogStatus.INFO, "Registration Screen", "User Clicks On Acceder Button" + image);	
			
			start = System.currentTimeMillis();
			StartTime = time_formatter.format(System.currentTimeMillis());

			driver.findElement(By.id("com.popular.app.corp:id/btnLogin")).click();
			Thread.sleep(500l);
									
			try {				
				Assert.assertEquals("Error",driver.findElement(By.id("android:id/alertTitle")).getText());
				
				long finish = System.currentTimeMillis();
				long total =  finish - start;
				String totalTime = String.format("%.2f", total / 1000.0);
				String EndTime =  time_formatter.format(System.currentTimeMillis());
																
				testresultdata.put(object.getProperty("AccederButtonInvalid"),
						new Object[] { "Registration Screen-Invalid Registration",
								 		"Click On Acceder Button With Invalid Registration Details",
								 		"Error Alert- " + driver.findElement(By.id("android:id/message")).getText() + " Should Get Displayed", 
								 		"Correct Error Alert- " + driver.findElement(By.id("android:id/message")).getText() + " Is Displayed",   
								 		"Success",
								 		"Pass", 
								 		StartTime, 
								 		EndTime,
								 		totalTime + " seconds."});	
				
				screenshot_Path = TestUtil.captureScreenShot(driver, "InvalidRegistrationPass");
				image = logger.addScreenCapture(screenshot_Path);				
				logger.log(LogStatus.INFO, "Error Alert PopUp", "User Clicks On Continuar Button On Alert Pop Up" + image);	
				
				System.out.println("Error Message Content Is : "
						+ driver.findElement(By.id("android:id/message")).getText());	
				
				driver.findElement(By.id("android:id/button1")).click();
				
								
			} catch (Exception e) {

				System.out.println("Waiting Few More 120 Seconds For The Response");
				Thread.sleep(120000);
				
				logger.log(LogStatus.ERROR, "Error Trace Is : ", ExceptionUtils.getStackTrace(e));
								
				System.out.println("Registration Invalid Scenario Failed ");
				
				long finish = System.currentTimeMillis();
				long total =  finish - start;
				String totalTime = String.format("%.2f", total / 1000.0);
				String EndTime =  time_formatter.format(System.currentTimeMillis());
				
				testresultdata.put(object.getProperty("AccederButtonInvalid"),
						new Object[] { "Registration Screen-Invalid Registration",
								 		"Click On Acceder Button With Invalid Registration Details",
								 		"Error Alert- " + driver.findElement(By.id("android:id/message")).getText() + " Should Get Displayed", 
								 		"Correct Error Alert- " + driver.findElement(By.id("android:id/message")).getText() + " Is Displayed",   
								 		"UnSucess",
								 		"Fail", 
								 		StartTime, 
								 		EndTime,
								 		totalTime + " seconds."});	
			
				
				//EDITED
				screenshot_Path = TestUtil.captureScreenShot(driver, "InvalidRegistrationFail");
				image = logger.addScreenCapture(screenshot_Path);	
				logger.log(LogStatus.INFO, "Error Alert PopUp", "User Clicks On Continuar Button On Alert Pop Up" + image);
				driver.findElement(By.id("android:id/button1")).click();
			}
		}	

	}
	
	
	//@Test(priority = 4, dependsOnMethods = "InValidRegistration")
	@Test
	public void ValidRegistration() throws InterruptedException{
		
		app_logs.debug("Valid Registration Attempt ");
		System.out.println("TEST CASE- Valid Registration : User Enters Correct Empress, Usario & Password.");
		logger = extent.startTest("TEST CASE- Valid Registration : User Enters Correct Empress, Usario & Password.");

		Assert.assertEquals("ACCEDER",driver.findElement(By.id("com.popular.app.corp:id/btnLogin")).getText());

		long start = System.currentTimeMillis();
		String StartTime = time_formatter.format(System.currentTimeMillis());
		
		if (config.getProperty("App").equalsIgnoreCase("Production")) {

			try {
				start = System.currentTimeMillis();
				StartTime = time_formatter.format(System.currentTimeMillis());
				driver.findElement(By.id("com.popular.app.corp:id/editBusinessName")).sendKeys(config.getProperty("EmpresaCorrect"));
				long finish = System.currentTimeMillis();
				long total =  finish - start;
				String totalTime = String.format("%.2f", total / 1000.0);
				String EndTime =  time_formatter.format(System.currentTimeMillis());
				
				logger.log(LogStatus.INFO,"Registration Screen : Empresa","Enter Correct Empresa : " + config.getProperty("EmpresaCorrect"));
				
				String screenshot_Path = TestUtil.captureScreenShot_Other(driver, "EmpresaCorrect");
				String image = logger.addScreenCapture(screenshot_Path);				
				logger.log(LogStatus.INFO, "Registration Screen : Empresa" + config.getProperty("EmpresaCorrect"),"Total Time Required To Enter Empresa: " + totalTime + " seconds" + image);
							
				testresultdata.put(object.getProperty("EmpresaCorrect"),
						new Object[] { "Registration Screen-Valid Correct Empresa Attempt",
								 		"User Enters Correct Empresa: " + config.getProperty("EmpresaCorrect"),
								 		config.getProperty("EmpresaCorrect") + " Empresa Should Get Entered Properly", 
								 		config.getProperty("EmpresaCorrect") + " Empresa Gets Entered Properly",  
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
								
				testresultdata.put(object.getProperty("EmpresaCorrect"),
						new Object[] { "Registration Screen-Valid Empresa Attempt",
								 		"User Enters Correct Empresa: " + config.getProperty("EmpresaCorrect"),
								 		config.getProperty("EmpresaCorrect") + " Empresa Should Get Entered Properly", 
								 		config.getProperty("EmpresaCorrect") + " Empresa Gets Entered Properly",  
								 		"UnSucess",
								 		"Fail", 
								 		StartTime, 
								 		EndTime,
								 		totalTime + " seconds."});	
			}
			
			
			try {
				
				start = System.currentTimeMillis();
				StartTime = time_formatter.format(System.currentTimeMillis());
				
				driver.findElement(By.id("com.popular.app.corp:id/editUsername")).sendKeys(config.getProperty("UsuarioCorrect"));
				long finish = System.currentTimeMillis();
				long total =  finish - start;
				String totalTime = String.format("%.2f", total / 1000.0);
				String EndTime =  time_formatter.format(System.currentTimeMillis());
				
				logger.log(LogStatus.INFO,"Registration Screen : Usuario","User Enters Correct Usuario : " + config.getProperty("UsuarioCorrect"));
				
				String screenshot_Path = TestUtil.captureScreenShot_Other(driver, "Wrong_Usuario");
				String image = logger.addScreenCapture(screenshot_Path);				
				logger.log(LogStatus.INFO, "Registration Screen : User Enters Correct Usuario","Total Time Required To Enter Usuario: " + totalTime + " seconds" + image);
				
				testresultdata.put(object.getProperty("UsuarioCorrect"),
						new Object[] { "Registration Screen-Valid Usuario Attempt",
								 		"User Enters Correct Usuario: " + config.getProperty("UsuarioCorrect"),
								 		config.getProperty("UsuarioCorrect")+ " Usuario Should Get Entered Properly", 
								 		config.getProperty("UsuarioCorrect")+ " Usuario Gets Entered Properly",  
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
				
				testresultdata.put(object.getProperty("UsuarioCorrect"),
						new Object[] { "Registration Screen-Valid Usuario Attempt",
								 		"User Enters Correct Usuario: " + config.getProperty("UsuarioCorrect"),
								 		config.getProperty("UsuarioCorrect")+ " Usuario Should Get Entered Properly", 
								 		config.getProperty("UsuarioCorrect")+ " Usuario Gets Entered Properly",  
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
				driver.findElement(By.id("com.popular.app.corp:id/editBusinessName")).sendKeys(config.getProperty("EmpresaCorrect"));
				long finish = System.currentTimeMillis();
				long total =  finish - start;
				String totalTime = String.format("%.2f", total / 1000.0);
				String EndTime =  time_formatter.format(System.currentTimeMillis());
				
				logger.log(LogStatus.INFO,"Registration Screen : Empresa","Enter Correct Empresa : " + config.getProperty("EmpresaCorrect"));
				
				String screenshot_Path = TestUtil.captureScreenShot_Other(driver, "EmpresaCorrect");
				String image = logger.addScreenCapture(screenshot_Path);				
				logger.log(LogStatus.INFO, "Registration Screen : Empresa" + config.getProperty("EmpresaCorrect"),"Total Time Required To Enter Empresa: " + totalTime + " seconds" + image);
							
				testresultdata.put(object.getProperty("EmpresaCorrect"),
						new Object[] { "Registration Screen-Valid Correct Empresa Attempt",
								 		"User Enters Correct Empresa: " + config.getProperty("EmpresaCorrect"),
								 		config.getProperty("EmpresaCorrect") + " Empresa Should Get Entered Properly", 
								 		config.getProperty("EmpresaCorrect") + " Empresa Gets Entered Properly",  
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
								
				testresultdata.put(object.getProperty("EmpresaCorrect"),
						new Object[] { "Registration Screen-Valid Empresa Attempt",
								 		"User Enters Correct Empresa: " + config.getProperty("EmpresaCorrect"),
								 		config.getProperty("EmpresaCorrect") + " Empresa Should Get Entered Properly", 
								 		config.getProperty("EmpresaCorrect") + " Empresa Gets Entered Properly",  
								 		"UnSucess",
								 		"Fail", 
								 		StartTime, 
								 		EndTime,
								 		totalTime + " seconds."});	
			}
			
			
			try {
				
				start = System.currentTimeMillis();
				StartTime = time_formatter.format(System.currentTimeMillis());
				
				driver.findElement(By.id("com.popular.app.corp:id/editUsername")).sendKeys(config.getProperty("UsuarioCorrect"));
				long finish = System.currentTimeMillis();
				long total =  finish - start;
				String totalTime = String.format("%.2f", total / 1000.0);
				String EndTime =  time_formatter.format(System.currentTimeMillis());
				
				logger.log(LogStatus.INFO,"Registration Screen : Usuario","User Enters Correct Usuario : " + config.getProperty("UsuarioCorrect"));
				
				String screenshot_Path = TestUtil.captureScreenShot_Other(driver, "Wrong_Usuario");
				String image = logger.addScreenCapture(screenshot_Path);				
				logger.log(LogStatus.INFO, "Registration Screen : User Enters Correct Usuario","Total Time Required To Enter Usuario: " + totalTime + " seconds" + image);
				
				testresultdata.put(object.getProperty("UsuarioCorrect"),
						new Object[] { "Registration Screen-Valid Usuario Attempt",
								 		"User Enters Correct Usuario: " + config.getProperty("UsuarioCorrect"),
								 		config.getProperty("UsuarioCorrect")+ " Usuario Should Get Entered Properly", 
								 		config.getProperty("UsuarioCorrect")+ " Usuario Gets Entered Properly",  
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
				
				testresultdata.put(object.getProperty("UsuarioCorrect"),
						new Object[] { "Registration Screen-Valid Usuario Attempt",
								 		"User Enters Correct Usuario: " + config.getProperty("UsuarioCorrect"),
								 		config.getProperty("UsuarioCorrect")+ " Usuario Should Get Entered Properly", 
								 		config.getProperty("UsuarioCorrect")+ " Usuario Gets Entered Properly",  
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
			
		String screenshot_Path = TestUtil.captureScreenShot(driver, "AccederClick");
		String image = logger.addScreenCapture(screenshot_Path);
		
		if ("ACCEDER".equalsIgnoreCase(driver.findElement(By.id("com.popular.app.corp:id/btnLogin")).getText())) {

			logger.log(LogStatus.INFO, "Registration Screen", "User Clicks On Acceder Button" + image);	
			
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
				//Thread.sleep(120000);
				
				logger.log(LogStatus.ERROR, "Error Trace Is : ", ExceptionUtils.getStackTrace(e));
								
				System.out.println("Registration Valid Scenario Failed ");
				
				long finish = System.currentTimeMillis();
				long total =  finish - start;
				String totalTime = String.format("%.2f", total / 1000.0);
				String EndTime =  time_formatter.format(System.currentTimeMillis());
				
				
				//SENDS ALERT MAIL ON FAIL
				String Message = "<b>Error Alert : </b> Registration Fail." + "<br>"
						+ "<b>Error Message Is : </b>" + driver.findElement(By.id("android:id/message")).getText() + "<br>"
						+ "Check The Error Stacktrace & Attached Error ScreenShot.</b><br><br>";
				SendAlertMailTest.SendDetail(From, Password , TO, CC, "SMB Application Alert : Login Access Fail " + formattedDate, 
				Message + ExceptionUtils.getStackTrace(e));
				System.out.println("Alert Send Via Mail For Login Access Fail");
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				
				
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
	
	
	
}