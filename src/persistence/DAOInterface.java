package persistence;
import java.util.List;

import javax.xml.xpath.XPathExpressionException;

import domain.Product;

public interface DAOInterface {
    List<Product> getProducts() throws XPathExpressionException;
    List<Product> getTeapots() throws XPathExpressionException;
}
