package creator;

import product.SAX;
import product.Parser;

public class SAXParserCreator implements ParserCreator {

	@Override
	public Parser createParser() {
		return new SAX();
	}

}