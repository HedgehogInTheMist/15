package product;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class StAX implements Parser {

	@Override
	public void performParser() {
		
System.out.println("StAXParser started");
		
		boolean isStudent = false;
		boolean isFirstName = false;
		boolean isLastName = false;
		boolean isAge = false;
		boolean isFaculty = false;
		boolean isStudentList = false;
		
		XMLInputFactory factory = XMLInputFactory.newFactory();
		try {
			XMLStreamReader reader = factory.createXMLStreamReader(new FileInputStream("./src/resources/Planes.xml"));
			while (reader.hasNext()) {
				int res = reader.next();
				if (res == reader.START_ELEMENT) {
					if (reader.getLocalName().equals("Plane")) {
						isStudentList = true;
						System.out.print(reader.getLocalName() + ": ");
//						System.out.print("(");
						for (int i=0; i<reader.getAttributeCount(); i++) {
							System.out.print(reader.getAttributeLocalName(i) + "=" + reader.getAttributeValue(i) + " ");
						}
//						System.out.println(")");
						System.out.println();
					} else if (reader.getLocalName().equals("Model")) {
						isStudent = true;
						System.out.print(reader.getLocalName() + ": ");
						for (int i=0; i<reader.getAttributeCount(); i++) {
							System.out.print("(" + reader.getAttributeLocalName(i) + "=" + reader.getAttributeValue(i) + ")\n");
						}
					} else if (reader.getLocalName().equals("Origin")) {
						isFirstName = true;
					} else if (reader.getLocalName().equals("Chars")) {
						isLastName = true;
					} else if (reader.getLocalName().equals("Parameters")) {
						isAge = true;
					} else if (reader.getLocalName().equals("Price")) {
						isFaculty = true;
					}
				} else if (res == reader.CHARACTERS) {
					if (isFirstName) {
						System.out.println("    " + "Origin: " + reader.getText());
						isFirstName = false;
					} else if (isLastName) {
						System.out.println("    " + "Chars: " + reader.getText());
						isLastName = false;
					} else if (isAge) {
						System.out.println("    " + "Parameters: " + reader.getText());
						isAge = false;
					} else if (isFaculty) {
						System.out.println("    " + "Price: " + reader.getText());
						isFaculty = false;
					}
				} 
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
		
		System.out.println("StAXParser Ended");
		
	}

}
