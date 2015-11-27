package creator;

import product.DOM;
import product.Parser;

public class DOMParserCreator implements ParserCreator {

	@Override
	public Parser createParser() {
		return new DOM();
	}

}