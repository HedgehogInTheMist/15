package creator;

import product.StAX;
import product.Parser;

public class StAXParserCreator implements ParserCreator {

	@Override
	public Parser createParser() {
		return new StAX();
	}

}
