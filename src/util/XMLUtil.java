package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;


public class XMLUtil {

	public static Document read() throws IOException, DocumentException{
		try {
			File file = new File("d:/contact.xml");
			if(!file.exists()){
				file.createNewFile();
				Document doc = DocumentHelper.createDocument();
				doc.addElement("ContactList");
				String xml = doc.asXML();
				FileWriter writer = new FileWriter(file);
				writer.write(xml);
				writer.close();
				Document doc1 = new SAXReader().read(file);
				return doc1;
			}else{
				Document doc = new SAXReader().read(file);
				return doc;
			}
		} catch (DocumentException e) {
			e.printStackTrace();
			throw new DocumentException(e);
		} catch (IOException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
	}
	
	public static void write(Document doc){
		
		try {
			FileOutputStream out = new FileOutputStream(new File("d:/contact.xml"));
			OutputFormat	 format = new OutputFormat();
			format.setEncoding("utf-8");
			
			XMLWriter writer = new XMLWriter(out, format);
			
			writer.write(doc);
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
