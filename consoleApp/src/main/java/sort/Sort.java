package sort;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class Sort {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        Sort sort = new Sort();
        sort.initConfig();
    }

    private String name;
    private String rate;
    private String price;

    private void initConfig() throws ParserConfigurationException, IOException, SAXException {
        File file = new File("consoleApp/src/main/resources/config.xml");
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        Document doc =dbf.newDocumentBuilder().parse(file);
        Node sortNode = doc.getFirstChild();
        System.out.println(sortNode.getNodeName());
        NodeList sortChilds = sortNode.getChildNodes();
        for (int i = 0; i < sortChilds.getLength(); i++) {
            if (sortChilds.item(i).getNodeType() == Node.ELEMENT_NODE) {
                System.out.println(sortChilds.item(i).getNodeName());

            }
        }


    }
}
