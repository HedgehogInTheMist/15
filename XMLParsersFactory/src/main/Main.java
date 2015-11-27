package main;

import product.Parser;
import creator.DOMParserCreator;
import creator.ParserCreator;
import creator.SAXParserCreator;
import creator.StAXParserCreator;

public class Main {

	public static void main(String[] args) {
		
//		ParserCreator creator = new DOMParserCreator();
//		ParserCreator creator = new SAXParserCreator();
		ParserCreator creator = new StAXParserCreator();
		Parser parser = creator.createParser();
		parser.performParser();

	}

	
}