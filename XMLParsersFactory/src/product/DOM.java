package product;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOM implements Parser {

	@Override
	public void performParser() {

		System.out.println("-------------- DOM Parser - Start ---------------");

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = null;
		Document doc = null;
		try {
			builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		File studentList = new File("./src/resources/Planes.xml");
		try {
			doc = builder.parse(studentList);
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Element root = doc.getDocumentElement();
		System.out.print(root.getTagName());

		NamedNodeMap attributes = root.getAttributes();
		System.out.print(" (");
		for (int i = 0; i < attributes.getLength(); i++) {
			System.out.print(attributes.item(i).getNodeName() + ":" + attributes.item(i).getNodeValue() + " ");
		}
		System.out.println(")");

		NodeList nList = root.getChildNodes();
		for (int i = 0; i < nList.getLength(); i++) {
			if (nList.item(i) instanceof Element) {
				System.out.println(nList.item(i).getNodeName());

				NodeList nList2 = nList.item(i).getChildNodes();
				for (int j = 0; j < nList2.getLength(); j++) {
					if (nList2.item(j) instanceof Element) {
						System.out.println(
								"    " + nList2.item(j).getNodeName() + "<" + nList2.item(j).getTextContent() + ">");
					}
				}

			}
		}
		System.out.println("--------------- DOM Parser - End -----------------\n");

	}

}
