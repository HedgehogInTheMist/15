package product;

import java.io.IOException;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

public class SAX implements Parser {

	@Override
	public void performParser() {
		
		try {
			XMLReader reader = XMLReaderFactory.createXMLReader();
			SaxHandler handler = new SaxHandler();
			reader.setContentHandler(handler);
			reader.parse("./src/resources/Planes.xml");
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}

class SaxHandler extends DefaultHandler {
	
	@Override
	public void startDocument() {
		System.out.println("-------------- SAX Parser - Start ---------------");
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) {
		String s = localName;
		for (int i = 0; i < attributes.getLength(); i++) {
			s += " " + attributes.getLocalName(i) + "=" + attributes.getValue(i);
		}
		System.out.print(s.trim());
	}
	
	@Override
	public void characters(char[] ch, int start, int length) {
		System.out.print(" " + new String(ch, start, length) + " ");
	}

	@Override
	public void endElement(String uri, String localName, String qName) {
		System.out.print(localName);
	}

	@Override
	public void endDocument() {
		System.out.println("\n--------------- SAX Parser - End -----------------\n");
	}

}


