package parser;

import model.Root;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class Parser {

    public Root parse()  {

        SAXParserFactory factory = SAXParserFactory.newInstance();
        ParserHandler handler = new ParserHandler();
        try {
            SAXParser parser = factory.newSAXParser();
            File file = new File("consoleApp/src/main/resources/config.xml");
            parser.parse(file, handler);
        } catch (Exception e) {
            System.out.println("Exception");
        }
        return handler.getRoot();

    }
}
