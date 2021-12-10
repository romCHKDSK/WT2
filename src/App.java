
import java.io.IOException;
import java.util.Scanner;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import persistence.DAO;
import presentation.ConsoleUI;

public class App {
    
    /** 
     * LR2 - a single-threaded console app that provides information about
     * electronic appliances stored in an xml database.
     * @param args Command line parameters (ignored)
     */
    public static void main(String[] args) {
        try (var scanner = new Scanner(System.in)) {
            var documentBuilderFactory = DocumentBuilderFactory.newInstance();
            documentBuilderFactory.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "");
            documentBuilderFactory.setAttribute(XMLConstants.ACCESS_EXTERNAL_SCHEMA, "");
            var documentBuilder = documentBuilderFactory.newDocumentBuilder();
            
            Document document = documentBuilder.parse("product_db.xml");

            DAO dao = new DAO(document);
            
            ConsoleUI.mainLoop(scanner, dao);

        } catch (ParserConfigurationException | IOException | SAXException | XPathExpressionException e) {
            e.printStackTrace();
        }
    }
}
