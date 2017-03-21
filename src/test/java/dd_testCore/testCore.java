package dd_testCore;

import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import javax.mail.MessagingException;
import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteException;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.*;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import dd_util.TestUtil;
import dd_util.ZipDirectory;

public class testCore {

	public static String timeinstance ="";
	public static Properties config = new Properties();
	public static Properties object = new Properties();
	public static Properties users = new Properties();
	// public static Xls_Reader excel = null;	

	public static AndroidDriver<MobileElement> driver = null;
	
	//public static Logger app_logs = Logger.getLogger("devpinoyLogger");
	public static Logger app_logs = Logger.getLogger("devpinoyLogger");
	public static HSSFWorkbook workbook;
	public static HSSFSheet sheet;
	public static Map<String, Object[]> testresultdata;
	
	//static Locale locale = new Locale("es");  
	static Locale locale = new Locale("en");  
	public static ExtentReports extent = new ExtentReports(System.getProperty("user.dir") + "\\Reports\\Report.html",true, locale);
	public static ExtentTest logger;
	File configFile = new File (System.getProperty("user.dir")+ "\\Config.xml");
	
	public static Calendar cal = Calendar.getInstance();
    //public static SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    //protected static SimpleDateFormat time_formatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss.SSS");	
	protected static SimpleDateFormat time_formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    protected static SimpleDateFormat time_formatter1 = new SimpleDateFormat("ss.SSS");
      
	public static String appiumPath="C:\\Progra~2\\Appium";	
	public static DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();
	public static DefaultExecutor executor = new DefaultExecutor();	
	public static SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMMyy_hh-mm-aa");
	public static String formattedDate = dateFormat.format(new Date()).toString();
	
	public static Document document = new Document();
	public static File pathpdf = new File(System.getProperty("user.dir") + "\\Reports\\PDF_Report\\TestResult_" + formattedDate + ".pdf");
	PdfWriter writer;
		
	//MailDetails:	
	public static String TO = "raghavendrap@siddhatech.com";
	public static String CC = "raghavendra_uday@yahoo.com";
	
	//public static String From = "androidrobotsiddhatech@yahoo.com";
	//public static String Password = "2016sidd";
	
	public static String From = "androidrobotsiddhatech2017";
	public static String Password = "2017Raghu";
	
	private static Process process;
	private static String STARTSERVER ="C:\\Progra~2\\Appium\\node.exe C:\\Progra~2\\Appium\\node_modules\\appium\\bin\\appium.js";
	
	public static String AccountType;
	public static String PaymentOption;
	public static String text = "";
		
	@BeforeSuite
	public void init() throws IOException, InterruptedException, DocumentException {
		
		ClearAppiumPorts();		
		StopAppiumServer();
		//Kill_Chrome();
	
		extent.loadConfig(configFile);	
		
		//extent.config().reportName("BANCO POPULAR");
		//extent.config().reportHeadline("Testing Report");	
		//Locale locale = new Locale("es-ES");  
		
		if (driver == null) {

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
			app_logs.debug("Loading the Users Propeties File");
						
			TestUtil.Delete_Logs();
			TestUtil.Delete_ExcelTestResults();
			TestUtil.Delete_CSV();
			TestUtil.Delete_ScreenShots();
			TestUtil.Delete_PDFFile();
					
			StartAppiumServer();

		
			DesiredCapabilities capabilities = new DesiredCapabilities();
			
			capabilities.setCapability("Automation", "Appium v1.4.0");
			capabilities.setCapability("deviceName", "emulator-5554");
			capabilities.setCapability("platformVersion","4.4.2");
			capabilities.setCapability("platformName", "Android");
			//capabilities.setCapability("app", app.getAbsolutePath());
			capabilities.setCapability("newCommandTimeout", "600");
			
			
		/*	capabilities.setCapability(MobileCapabilityType.APPIUM_VERSION,"Appium v1.4.0");
		    capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"AutomationBPD");
		    capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		    capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "4.4.2");
		    capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		    capabilities.setCapability("newCommandTimeout", 600);
		    //capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 180);
*/

			if (config.getProperty("App").equals("Production")) {
				capabilities.setCapability("app", System.getProperty("user.dir") + "\\App_Prod\\NegociosPopular.apk");
				
			} else if (config.getProperty("App").equals("Development")) {
				capabilities.setCapability("app", System.getProperty("user.dir") + "\\App_Dev\\NegociosPopular.apk");
			}
		
			logger = extent.startTest("TEST CASE- Appium Installs " + config.getProperty("App") + " App & Launches.");
			System.out.println("TEST CASE- Appium Installs " + config.getProperty("App") + " App & Launches.");
			Thread.sleep(2000);
			
			try {
				long start = System.currentTimeMillis();
				driver = new AndroidDriver<MobileElement>(new URL(config.getProperty("URL")), capabilities);
				long finish = System.currentTimeMillis();
				long total =  finish - start;
				String totalTime = String.format("%.2f", total / 1000.0);
				
				System.out.println(
						"TIME FOR INSTALLING & LAUNCHING SMB Application Is : - " + totalTime + " seconds");	
								
				String screenshot_Path = TestUtil.captureScreenShot_Other(driver, "ApplicationInstallation");
				String image = logger.addScreenCapture(screenshot_Path);
				logger.log(LogStatus.INFO, "Application Gets Install & Launch: ", "Total Response Time For Installing & Launching SMB App Is : "+ totalTime + " seconds."+ image);				
			}

			catch (Exception e) {
				e.printStackTrace();
				System.out.println("Please Check Appium Server Is Not Working OR Find Out What Is Wrong !");
				driver.quit();
			}

			driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
			System.out.println("Appium Launched The SMB Application Successfully ");			
					
			Thread.sleep(1500);
		}
		
		//EDITED
		String screenshot_Path = TestUtil.captureScreenShot(driver, "ApplicationInstallation");
		String image = logger.addScreenCapture(screenshot_Path);
		
		logger.log(LogStatus.PASS, "Registration Screen Verification :", "Expected-Registration Screen Should Get Displayed On Application Launch");		
		Assert.assertEquals("ACCEDER",driver.findElement(By.id("com.popular.app.corp:id/btnLogin")).getText());
		logger.log(LogStatus.PASS, "Resgistration Screen Verification :", "Actual-Registration Screen Is Displayed On Application Launch" + image);				
		
		extent.endTest(logger);
		extent.flush();
	}

	@BeforeTest
	public void setupBeforeSuite(ITestContext context) {
		     
		try {
			workbook = new HSSFWorkbook();
			sheet = workbook.createSheet("TestResult");		
			
			testresultdata = new LinkedHashMap<String, Object[]>();

			//testresultdata.put("1", new Object[] { "Test Case Description", "Expected Result", "Actual Result",
					//"Case Status", "Start Time","End Time","Total Time Required",  });
			
			testresultdata.put("1", new Object[] {"Description",
												  "TestCase_Name",
												  "ExpectedResults",
												  "ActualResults",
												  "Results",
												  "Case_Status",
												  "Start Time",
												  "End Time",
												  "Total Time",});			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Something Went Wrong In Creating The Work Book ");
		}
	}
	
	@AfterTest
	public void setupAfterSuite() throws InterruptedException {
		// write excel file and file name is TestResult.xls
		Set<String> keyset = testresultdata.keySet();
		int rownum = 0;

		for (String key : keyset) {
			Row row = sheet.createRow(rownum++);
			Object[] objArr = testresultdata.get(key);
			int cellnum = 0;
			for (Object obj : objArr) {
				Cell cell = row.createCell(cellnum++);
				if (obj instanceof Date)
					cell.setCellValue((Date) obj);
				else if (obj instanceof Boolean)
					cell.setCellValue((Boolean) obj);
				else if (obj instanceof String)
					cell.setCellValue((String) obj);
				else if (obj instanceof Double)
					cell.setCellValue((Double) obj);
			}
		}
		try {
			FileOutputStream out = new FileOutputStream(new File(System.getProperty("user.dir")+"\\Reports\\ExcelReport\\TestResult_"+formattedDate+".xls"));
		
			workbook.write(out);
			out.close();
			System.out.println("TestResults Are Written In Excel Successfully.");
			Thread.sleep(1500);
			
			File folder = new File(System.getProperty("user.dir") + "\\Reports\\ExcelReport");
			File[] listOfFiles = folder.listFiles();

			for (int i = 0; i < listOfFiles.length; i++) {
				if (listOfFiles[i].isFile()) {
					String filename = listOfFiles[i].getName();
					//System.out.println(filename);
					String filename1 = System.getProperty("user.dir") + "\\Reports\\ExcelReport\\" + filename;
					//System.out.println(filename1);
					
					File inputFile = new File(filename1);
					File outputFile = new File(System.getProperty("user.dir") + "\\Reports\\CSV\\TestResult_"+formattedDate+".csv");
					//File outputFile1 = new File("C:\\Automation_Reports\\Report_CSV\\TestResult_"+formattedDate+".csv");
					Excel(inputFile, outputFile);
					//Excel(inputFile, outputFile1);
					Thread.sleep(10000);
					System.out.println("Test Results Excel Is Converted To CSV.");								
					
				} else if (listOfFiles[i].isDirectory()) {
					System.out.println("Directory " + listOfFiles[i].getName());
				}
			}			

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
				
	}

	@AfterSuite
	public void QuitDriver() throws InterruptedException, MessagingException, IOException, AWTException, DocumentException {	
	 
		ZipDirectory.Reports();
		Thread.sleep(10000);	
		//SendMailFunction.SendMail();		
		System.out.println("Driver 1");
		driver.quit();
		System.out.println("Quit The Android Driver");
		AppiumNodeStop();
	}

	@AfterMethod
	public void tearDown(ITestResult result) throws IOException, InterruptedException, DocumentException {
		
		Document document = new Document();
		
		if (result.getStatus() == ITestResult.FAILURE) {

			String screenshot_Path = TestUtil.captureScreenShot(driver, result.getName());
			String image = logger.addScreenCapture(screenshot_Path);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			logger.log(LogStatus.FAIL, "Expected Screen Verification Fail", image);			
		
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			
			String screenshot_Path = TestUtil.captureScreenShot(driver, result.getName());
			String image = logger.addScreenCapture(screenshot_Path);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			logger.log(LogStatus.PASS, "Expected Screen Verification Pass", image);				
		}
				
		Thread.sleep(2500);
		extent.endTest(logger);
		extent.flush();
	}
			
	public void AppiumLogs() throws ExecuteException, IOException, InterruptedException {
		
		CommandLine command = new CommandLine("cmd");
		command.addArgument("/c");
		command.addArgument(appiumPath + "\\node.exe");
		command.addArgument(appiumPath +"\\node_modules\\appium\\bin\\appium.js");
		command.addArgument("--address");
		command.addArgument("localhost");
		command.addArgument("--port");
		command.addArgument("4723");
		command.addArgument("--local-timezone",true);
		//command.addArgument("--no-reset");
		command.addArgument("--command-timeout");
		command.addArgument("250000");
		command.addArgument("--log",true);
		command.addArgument(System.getProperty("user.dir")+ "\\Reports\\AppiumLogs\\BPD_AppiumLogs_"+formattedDate);
		executor.execute(command,resultHandler);
		Thread.sleep(5000);
	}

	public void AppiumNodeStop() throws ExecuteException, IOException, InterruptedException {
		
		CommandLine command = new CommandLine("cmd");	
		command.addArgument("/c");
		command.addArgument("taskkill");
		command.addArgument("/F");
		command.addArgument("/IM");
		command.addArgument("node.exe");
		executor.execute(command,resultHandler);
		Thread.sleep(2500);
		
	}
		
	public void Excel(File inputFile, File outputFile) {

		// For storing data into CSV files
		StringBuffer data = new StringBuffer();
		try {
			FileOutputStream fos = new FileOutputStream(outputFile);

			// Get the workbook object for XLS file
			HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(inputFile));
			// Get first sheet from the workbook
			HSSFSheet sheet = workbook.getSheetAt(0);
			Cell cell;
			Row row;

			// Iterate through each rows from first sheet
			Iterator<Row> rowIterator = sheet.iterator();
			while (rowIterator.hasNext()) {
				row = rowIterator.next();
				// For each row, iterate through each columns
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					cell = cellIterator.next();

					switch (cell.getCellType()) {
					case Cell.CELL_TYPE_BOOLEAN:
						data.append(cell.getBooleanCellValue() + ",");
						break;

					case Cell.CELL_TYPE_NUMERIC:
						data.append(cell.getNumericCellValue() + ",");
						break;

					case Cell.CELL_TYPE_STRING:
						data.append(cell.getStringCellValue() + ",");
						break;

					case Cell.CELL_TYPE_BLANK:
						data.append("" + ",");
						break;

					default:
						data.append(cell + ",");
					}
				}
				data.append('\n');
			}

			fos.write(data.toString().getBytes());
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
	public void ClearAppiumPorts() throws ExecuteException, IOException, InterruptedException {
		
		System.out.println("Clearing Previous Appium Server Ports");	
		
		CommandLine command = new CommandLine("cmd");	
		command.addArgument("/c");
		command.addArgument("taskkill");
		command.addArgument("/F");
		command.addArgument("/IM");
		command.addArgument("node.exe");
		executor.execute(command,resultHandler);	
		Thread.sleep(5000);
		
	}
	
	public void StartAppiumServer() throws IOException, InterruptedException {
	
		Runtime runtime = Runtime.getRuntime();
		process = runtime.exec(STARTSERVER);
		Thread.sleep(10000);
		
		if(process != null){
		System.out.println("Appium Server Started Successfully");
		
		CommandLine command = new CommandLine("cmd");
		command.addArgument("/c");
		command.addArgument(appiumPath + "\\node.exe");
		command.addArgument(appiumPath +"\\node_modules\\appium\\bin\\appium.js");
		command.addArgument("--address");
		command.addArgument("localhost");
		command.addArgument("--port");
		command.addArgument("4723");
		command.addArgument("--local-timezone",true);
		//command.addArgument("--no-reset");
		command.addArgument("--command-timeout");
		command.addArgument("150000");
		command.addArgument("--log",true);
		command.addArgument(System.getProperty("user.dir")+ "\\Reports\\AppiumLogs\\BPD_AppiumLogs_"+formattedDate);
		executor.execute(command,resultHandler);
		Thread.sleep(5000);
		
		}
		
	}
	
	public void StopAppiumServer() {
		
		if(process != null){
			process.destroy();
			System.out.println("Appium Session Is Destroyed Successfully ");
		}else {
			System.out.println("No Previous Appium Session Is Running !");
		}
	}
			
	public void Kill_Chrome() {

		try {
			Runtime.getRuntime().exec("TASKKILL /F /IM chrome.exe");
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
}



