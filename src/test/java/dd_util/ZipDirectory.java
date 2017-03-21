package dd_util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.testng.annotations.Test;

public class ZipDirectory {
	
	static SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMMyy_hh-mm-aa");
	static String formattedDate = dateFormat.format(new Date()).toString();


	public static void SendZipScreenShots () throws IOException {
		File directoryToZip = new File(System.getProperty("user.dir")+ "\\ScreenShots");

		List<File> fileList = new ArrayList<File>();
		//System.out.println("---Getting references to all files in: " + directoryToZip.getCanonicalPath());
		getAllFiles(directoryToZip, fileList);
		System.out.println("Creating Zip File Of BPD App ScreenShots");
		writeZipFile(directoryToZip, fileList);
		System.out.println("Zip Done Successfully");
	}


	public static void XSLT_Reports () throws IOException {
		
		File directoryToZip = new File(System.getProperty("user.dir")+ "\\XSLT_Reports");

		List<File> fileList = new ArrayList<File>();
		//System.out.println("---Getting references to all files in: " + directoryToZip.getCanonicalPath());
		getAllFiles(directoryToZip, fileList);
		System.out.println("Creating Zip File Of XSLT_Reports");
		writeZipFile(directoryToZip, fileList);
		System.out.println("Zip XSLT_Reports Done Successfully");
	}
	
	public static void Reports () throws IOException, InterruptedException {
		
		File directoryToZip = new File(System.getProperty("user.dir")+ "\\Reports");

		List<File> fileList = new ArrayList<File>();
		//System.out.println("---Getting references to all files in: " + directoryToZip.getCanonicalPath());
		getAllFiles(directoryToZip, fileList);
		System.out.println("Creating Zip File Of Reports");
		Thread.sleep(2000);
		writeZipFile(directoryToZip, fileList);
		Thread.sleep(2000);
		System.out.println("Zip Reports Done Successfully");
	}
	
	public static void getAllFiles(File dir, List<File> fileList) {
		try {
			File[] files = dir.listFiles();
			for (File file : files) {
				fileList.add(file);
				if (file.isDirectory()) {
					//System.out.println("directory:" + file.getCanonicalPath());
					getAllFiles(file, fileList);
				} else {
					System.out.println("     file:" + file.getCanonicalPath());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void writeZipFile(File directoryToZip, List<File> fileList) {

		try {
			FileOutputStream fos = new FileOutputStream("C:\\Users\\Raghavendra\\Downloads\\Reports\\"+ directoryToZip.getName() + formattedDate+".zip");
			//FileOutputStream fos = new FileOutputStream(directoryToZip.getName() + ".zip");
			//FileOutputStream fos = new FileOutputStream(directoryToZip.getName() + formattedDate+".zip");
			ZipOutputStream zos = new ZipOutputStream(fos);

			for (File file : fileList) {
				if (!file.isDirectory()) { // we only zip files, not directories
					addToZip(directoryToZip, file, zos);
				}
			}

			zos.close();
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void addToZip(File directoryToZip, File file, ZipOutputStream zos) throws FileNotFoundException,
			IOException {

		FileInputStream fis = new FileInputStream(file);

		// we want the zipEntry's path to be a relative path that is relative
		// to the directory being zipped, so chop off the rest of the path
		String zipFilePath = file.getCanonicalPath().substring(directoryToZip.getCanonicalPath().length() + 1,
				file.getCanonicalPath().length());
		//System.out.println("Writing '" + zipFilePath + "' to zip file");
		ZipEntry zipEntry = new ZipEntry(zipFilePath);
		zos.putNextEntry(zipEntry);

		byte[] bytes = new byte[1024];
		int length;
		while ((length = fis.read(bytes)) >= 0) {
			zos.write(bytes, 0, length);
		}

		zos.closeEntry();
		fis.close();
	}

	
	//IMPORTANT CODE
	public static void Zipfile() throws IOException {
		 StringBuilder sb = new StringBuilder();
	     sb.append("Test String");

	     File f = new File(System.getProperty("user.dir")+ "\\ScreenShots.zip");
	     ZipOutputStream out = new ZipOutputStream(new FileOutputStream(f));
	     ZipEntry e = new ZipEntry("mytext.txt");
	     out.putNextEntry(e);

	     byte[] data = sb.toString().getBytes();
	     out.write(data, 0, data.length);
	     out.closeEntry();

	     out.close();
	}
}