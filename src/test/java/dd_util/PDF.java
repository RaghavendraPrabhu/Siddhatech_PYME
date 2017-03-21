package dd_util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import dd_testCore.testCore;


public class PDF extends testCore {

	//public static void main(String[] args) {
		
		public static void Pdf_Creator() {	

		Document document = new Document();
		try {
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(new File(
					System.getProperty("user.dir") + "\\Reports\\PDF_Report\\TestResult_" + formattedDate + ".pdf")));
			document.open();
			document.add(new Paragraph("A Hello World PDF document."));
			document.close();
			writer.close();
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
