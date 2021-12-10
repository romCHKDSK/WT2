package persistence;

import java.util.ArrayList;
import java.util.List;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import domain.Product;

public class DAO implements DAOInterface {
    private Document document;
    
    public DAO(Document document) {
        this.document = document;
    }

    
    /** 
     * Retrieves all products from the database
     * @return List<Product> All products contained in the database
     * @throws XPathExpressionException
     */
    @Override
    public List<Product> getProducts() throws XPathExpressionException {
        XPathFactory pathFactory = XPathFactory.newInstance();
        XPath xPath = pathFactory.newXPath();
        XPathExpression expression = xPath.compile("//product");
        NodeList nodes = (NodeList) expression.evaluate(document, XPathConstants.NODESET);
        return nodesToList(nodes);
    }

    
    /**
     * Retrieves all products marked as teapots from the database
     * @return List<Product> All products marked as teapots
     * @throws XPathExpressionException
     */
    @Override
    public List<Product> getTeapots() throws XPathExpressionException {
        XPathFactory pathFactory = XPathFactory.newInstance();
        XPath xPath = pathFactory.newXPath();
        XPathExpression expression = xPath.compile("//product[info/@type='teapot']");
        NodeList nodes = (NodeList) expression.evaluate(document, XPathConstants.NODESET);
        
        return nodesToList(nodes);
    }

    
    /** 
     * Reads NodeList into a List<Product>
     * @param nodes NodeList object to grab the product info from
     * @return List<Product> List of objects containing the product info
     */
    private List<Product> nodesToList (NodeList nodes) {
        List<Product> products = new ArrayList<>();
        
        for (int i = 0; i < nodes.getLength(); i++) {
            Product product = new Product("", "", 0, "", "", 0);
            Node node = nodes.item(i);
            NodeList childNodes = node.getChildNodes();

            for (int j = 0; j < childNodes.getLength(); j++) {
                Node childNode = childNodes.item(j);
                switch (childNode.getNodeName()) {
                    case "info":
                        product.setInfo(childNode.getTextContent());
                        break;
                    case "name":
                        product.setName(childNode.getTextContent());
                        break;
                    case "price":
                        product.setPrice(Integer.parseInt(childNode.getTextContent()));
                        break;
                    case "material":
                        product.setMaterial(childNode.getTextContent());
                        break;
                    case "color":
                        product.setColor(childNode.getTextContent());
                        break;
                    case "voltage":
                        product.setVoltage(Integer.parseInt(childNode.getTextContent()));
                        break;
                    default:
                        break;
                }
            }
            products.add(product);
        }
        return products;
    }
}
