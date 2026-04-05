package wodel.utils.manager;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.python.apache.xml.serialize.OutputFormat;
import org.python.apache.xml.serialize.XMLSerializer;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 * @author Pablo Gomez-Abajo
 * 
 * XML code formatting
 * 
 */
public class XMLUtils {
	
	
	public static String prettyPrint(CharSequence charXMLSq) {
		String prettyPrint = charXMLSq.toString();
		try {
			prettyPrint = prettyPrint(prettyPrint);
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prettyPrint;
	}
	@SuppressWarnings("deprecation")
	private static String prettyPrint(String xml) throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		Document doc = db.parse(new InputSource(new StringReader(xml)));
		OutputFormat format = new OutputFormat(doc);
		format.setIndenting(true);
		format.setIndent(2);
		format.setOmitXMLDeclaration(false);
		format.setLineWidth(Integer.MAX_VALUE);
		StringWriter outxml = new StringWriter();
		XMLSerializer serializer = new XMLSerializer(outxml, format);
		serializer.serialize(doc);
		return outxml.toString();
	}
}
