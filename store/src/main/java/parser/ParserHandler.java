package parser;

import model.Root;
import model.Sort;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ParserHandler extends DefaultHandler {

    final String TAG_SORT = "sort";
    final String TAG_NAME = "name";
    final String TAG_PRICE = "price";
    final String TAG_RATE = "rate";

    private String currentTegName;
    private boolean isSort = false;

    private final Root root = new Root();
    private final Sort sort = new Sort();

    public Root getRoot() {
        return root;
    }

    @Override
    public void endDocument() throws SAXException {
        root.setSort(sort);
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentTegName = qName;

        if(qName.equals(TAG_SORT)) {
            isSort = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if(qName.equals(TAG_SORT)) {
            isSort = false;
        }
        currentTegName = null;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {

        if (currentTegName == null) return;

        if(isSort) {
            switch (currentTegName) {
                case TAG_NAME:
                    String nameOrder = new String(ch, start, length);
                    sort.setNameOrder(nameOrder);
                    break;
                case TAG_PRICE:
                    String priceOrder = new String(ch, start, length);
                    sort.setPriceOrder(priceOrder);
                    break;
                case TAG_RATE:
                    String rateOrder = new String(ch, start, length);
                    sort.setRateOrder(rateOrder);
                    break;
            }
        }
    }
}
