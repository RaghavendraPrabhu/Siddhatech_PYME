package dd_util;

import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import dd_testCore.testCore;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class TestUtil extends testCore {
		
	public static void VerifyWish() {
		
/*		time >=0 && time < 12
		Buenos días
	    time >=12 && time < 19
	    Buenas tardes
	    time >=19 && time < 24
		Buenas noches*/
				
	 	Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH");
        System.out.println( sdf.format(cal.getTime()));
        
        String Time = sdf.format(cal.getTime());
        Integer CurrentTime = Integer.valueOf(Time);
        
        if(CurrentTime >=0 && CurrentTime < 12){
        	timeinstance = "Buenos días";
        	System.out.println(timeinstance);
        } else if (CurrentTime >=12 && CurrentTime <19) {
        	timeinstance = "Buenas tardes";
        	System.out.println(timeinstance);
        } else if (CurrentTime >=19 && CurrentTime <24){
        	timeinstance = "Buenas noches";
        	System.out.println(timeinstance);
        }
        
	}

	public static void AlertWindow() throws InterruptedException {

		String AlertButton1 = "Continuar";
		try {

			MobileElement AlertButton2 = driver.findElement(By.id(object.getProperty("Continuar")));
			String AlertButton = AlertButton2.getText();

			if (AlertButton1.equalsIgnoreCase(AlertButton)) {
				System.out.println("User Clicks Error Window Continuar Button");
				driver.findElement(By.id(object.getProperty("Continuar"))).click();
				Thread.sleep(1500l);
			} else {
				System.out.println("Continuar Button Is Not Found ");
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Something Went Wrong - Check Alert Window ");
		}

	}

	public static void ClearWindow() throws InterruptedException {

		try {
			System.out.println("Clearing both login and password text box ");
			driver.findElement(By.id(object.getProperty("ClearUserName"))).clear();
			Thread.sleep(3000l);
			driver.navigate().back();
			driver.findElement(By.id(object.getProperty("ClearPassWord"))).clear();
			driver.navigate().back();
		} catch (Exception e) {
			System.out.println("Something Went Wrong On Clear Window ");
		}
	}

	public static void LoginButton() throws InterruptedException {

		try {
			MobileElement LoginButton = driver.findElement(By.id(object.getProperty("Acceder")));
			Assert.assertEquals(LoginButton.getText(), "Acceder");
			driver.findElement(By.id(object.getProperty("Acceder"))).click();
			Thread.sleep(12000l);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void Guardar() throws InterruptedException {
		String Guardar1 = "Guardar";

		try {
			MobileElement Guardar2 = driver.findElement(By.id(object.getProperty("Guarder")));
			String Guardar = Guardar2.getText();

			if (Guardar1.equalsIgnoreCase(Guardar)) {
				driver.findElement(By.id(object.getProperty("Guarder"))).click();
				Thread.sleep(2000l);
			} else {
				System.out.println("Guader Button Not Found On Device ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void WelcomeMsg() throws InterruptedException {

		driver.findElement(By.id(object.getProperty("WelComeMsg"))).click();
		Thread.sleep(2500l);
	}

	public static void captureScreenshot() {

		Calendar cal = new GregorianCalendar();
		int month = cal.get(Calendar.MONTH);
		int year = cal.get(Calendar.YEAR);
		int sec = cal.get(Calendar.SECOND);
		int min = cal.get(Calendar.MINUTE);
		int date = cal.get(Calendar.DATE);
		int day = cal.get(Calendar.HOUR_OF_DAY);

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy hh:mm aa");
		String formattedDate = dateFormat.format(new Date()).toString();
		// System.out.println(formattedDate);

		try {
			// FileUtils.copyFile(src, new File(System.getProperty("user.dir") +
			// "\\ScreenShots\\" + "_" + formattedDate+".jpeg"), true);

			/*
			 * FileUtils.copyFile(src, new File(System.getProperty("user.dir") +
			 * "\\ScreenShots\\" + date + "-" + (month + 1) + "-" + year + "-" +
			 * min +".jpeg"), true);
			 */

			FileUtils.copyFile(src, new File(System.getProperty("user.dir") + "\\ScreenShots\\" + year + "_" + date
					+ "_" + (month + 1) + "_" + day + "_" + min + "_" + sec + ".jpeg"), true);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void CalculateTime() {
		long start = System.currentTimeMillis();
		long finish = System.currentTimeMillis();
		long totalTime = finish - start;
		System.out.println("TIME FOR SWIPING ALL TUTORIAL SCREENS : " + totalTime + " milliseconds");
	}

/*	public static void HideKeyBoard() {
		Map<String, Object> BackspaceKeyEvent = new HashMap<>();
		BackspaceKeyEvent.put("key", "67");
		((JavascriptExecutor) driver).executeScript("mobile:key:event", BackspaceKeyEvent);
	}
*/

	public static void Delete_Report() throws IOException {

		try {
			FileUtils.deleteDirectory(new File(System.getProperty("user.dir") + "\\XSLT_Reports"));
			System.out.println("Previous XSLT_Report Deleted Succesfully");
		} catch (Throwable t) {
			System.out.println("No XSLT Report Found To Delete");
		}

	}

	public static void Delete_Zip() {

		try {
			File file = new File(System.getProperty("user.dir") + "\\XSLT_Reports.zip");
			file.delete();
			System.out.println("Previous XSLT_Report.zip Deleted Succesfully");
		} catch (Throwable t) {
			System.out.println("No XSLT_Report.zip Found To Delete");
		}

	}

	public static void Delete_ScreenShots() {

		try {
			File dir = new File(System.getProperty("user.dir") + "\\Reports\\ScreenShots");
			if (dir.isDirectory()) {
				String[] children = dir.list();
				for (int i = 0; i < children.length; i++) {
					new File(dir, children[i]).delete();
				}
				// System.out.println("All ScreenShots Deleted");
			}
		} catch (Exception e) {
			System.out.println("No ScreenShot Available To Delete");
		}

	}
		
	public static void Delete_Logs() {

		try {
			File dir = new File(System.getProperty("user.dir") + "\\Reports\\AppiumLogs");
			if (dir.isDirectory()) {
				String[] children = dir.list();
				for (int i = 0; i < children.length; i++) {
					new File(dir, children[i]).delete();
				}
				// System.out.println("All ScreenShots Deleted");
			}
		} catch (Exception e) {
			System.out.println("No Logs Available To Delete");
		}

	}
	
	public static void Delete_ExcelTestResults() {

		try {
			File dir = new File(System.getProperty("user.dir") + "\\Reports\\ExcelReport");
			if (dir.isDirectory()) {
				String[] children = dir.list();
				for (int i = 0; i < children.length; i++) {
					new File(dir, children[i]).delete();
				}
				// System.out.println("All ScreenShots Deleted");
			}
		} catch (Exception e) {
			System.out.println("No Logs Available To Delete");
		}

	}

	public static void Delete_CSV() {

		try {
			File dir = new File(System.getProperty("user.dir") + "\\Reports\\CSV");
			if (dir.isDirectory()) {
				String[] children = dir.list();
				for (int i = 0; i < children.length; i++) {
					new File(dir, children[i]).delete();
				}
				// System.out.println("All ScreenShots Deleted");
			}
		} catch (Exception e) {
			System.out.println("No Logs Available To Delete");
		}

	}
	
	public static void Delete_SeleniumLogs() {

		try {
			File dir = new File(System.getProperty("user.dir") + "\\Reports\\SeleniumLogs");
			if (dir.isDirectory()) {
				String[] children = dir.list();
				for (int i = 0; i < children.length; i++) {
					new File(dir, children[i]).delete();
				}
				// System.out.println("All ScreenShots Deleted");
			}
		} catch (Exception e) {
			System.out.println("No Logs Available To Delete");
		}

	}
	
	public static void Delete_PDFFile() {

		try {
			File dir = new File(System.getProperty("user.dir") + "\\Reports\\PDF_Report");
			if (dir.isDirectory()) {
				String[] children = dir.list();
				for (int i = 0; i < children.length; i++) {
					new File(dir, children[i]).delete();
				}
				// System.out.println("All ScreenShots Deleted");
			}
		} catch (Exception e) {
			System.out.println("No PDF Available To Delete");
		}

	}
		
	public static String captureScreenShot(AndroidDriver<MobileElement> driver, String screenshotName) {

		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			String dest1 = System.getProperty("user.dir") + "\\Reports\\ScreenShots\\" + screenshotName + ".jpeg";
			String dest2 = "ScreenShots\\" + screenshotName + ".jpeg";
			
			File destination = new File(dest2);
			File destinationNew = new File(dest1);
			FileUtils.copyFile(source, destinationNew);
			System.out.println("Screen ScreenShot Captured");
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			return dest2;
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println("Exception While Capturing ScreenShot" + e.getMessage());
			return e.getMessage();

		}

	}
	
	public static String captureScreenShot_Other(AndroidDriver<MobileElement> driver, String screenshotName) {
		
		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			String dest1 = System.getProperty("user.dir") + "\\Reports\\ScreenShots\\" + screenshotName + ".jpeg";
			String dest2 = "ScreenShots\\" + screenshotName + ".jpeg";
			
			//File destination = new File(dest2);
			File destinationNew = new File(dest1);
			FileUtils.copyFile(source, destinationNew);
			Thread.sleep(2500);
			System.out.println("Screen ScreenShot Captured");
			return dest2;

		} catch (Exception e) {

			System.out.println("Exception While Capturing ScreenShot" + e.getMessage());
			return e.getMessage();

		}

	}
		
	public static String captureScreenShot101(AndroidDriver driver, String screenshotName) {

		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			//String dest1 = System.getProperty("user.dir") + "\\Reports\\ScreenShots\\" + screenshotName + ".jpeg";
			//String dest2 = "ScreenShots\\" + screenshotName + ".jpeg";
			
			String dest1 = System.getProperty("user.dir") + "\\Reports\\ScreenShots\\" + screenshotName + ".jpeg";
		    BufferedImage i1 = ImageIO.read(new File(dest1));
		    compressAndShow(i1, 0.5f);
		    
			String dest2 = "ScreenShots\\" + screenshotName + ".jpeg";
		    BufferedImage i2 = ImageIO.read(new File(dest2));
		    compressAndShow(i2, 0.5f);
			
			File destination = new File(dest2);
			File destinationNew = new File(dest1);
			FileUtils.copyFile(source, destinationNew);
			//System.out.println("Screen ScreenShot Captured");
			return dest2;

		} catch (Exception e) {

			System.out.println("Exception While Capturing ScreenShot" + e.getMessage());
			return e.getMessage();

		}

	}
	
	public static void compressAndShow(BufferedImage image, float quality) throws IOException
	      {
	       // Get a ImageWriter for jpeg format.
	       Iterator<ImageWriter> writers = ImageIO.getImageWritersBySuffix("jpeg");
	       if (!writers.hasNext()) throw new IllegalStateException("No writers found");
	       ImageWriter writer = (ImageWriter) writers.next();
	       // Create the ImageWriteParam to compress the image.
	       ImageWriteParam param = writer.getDefaultWriteParam();
	       param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
	       param.setCompressionQuality(quality);
	       // The output will be a ByteArrayOutputStream (in memory)
	       ByteArrayOutputStream bos = new ByteArrayOutputStream(32768);
	       ImageOutputStream ios = ImageIO.createImageOutputStream(bos);
	       writer.setOutput(ios);
	       writer.write(null, new IIOImage(image, null, null), param);
	       ios.flush(); // otherwise the buffer size will be zero!
	       // From the ByteArrayOutputStream create a RenderedImage.
	       ByteArrayInputStream in = new ByteArrayInputStream(bos.toByteArray());
	       RenderedImage out = ImageIO.read(in);
	       int size = bos.toByteArray().length;
	       // showImage("Compressed to " + quality + ": " + size + " bytes", out);
	       // Uncomment code below to save the compressed files.
	       //    File file = new File("compressed."+quality+".jpeg");
	       //    FileImageOutputStream output = new FileImageOutputStream(file);
	       //    writer.setOutput(output); writer.write(null, new IIOImage(image, null,null), param);
	       } 


}
