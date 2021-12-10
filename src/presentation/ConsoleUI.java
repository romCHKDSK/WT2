package presentation;

import java.util.Scanner;

import javax.xml.xpath.XPathExpressionException;

import application.ProductFilterer;
import persistence.DAO;

public class ConsoleUI {
    private ConsoleUI() {}

	
    /** 
     * Main program loop
     * @param scanner Scanner to be used for reading user input
     * @param dao Data access object te app will be working with
     * @throws XPathExpressionException
     */
    public static void mainLoop(Scanner scanner, DAO dao) throws XPathExpressionException {
        int result = -1;
        do {
            System.out.println("Electronics shopper 9000");
            System.out.println("1 - List all");
            System.out.println("2 - List teapots");
            System.out.println("3 - Find cheapest product");
            System.out.println("0 - Escape");
            result = scanner.nextInt();
            switch (result) {
                case 1:
                    printProducts(dao);
                    break;
                case 2:
                    printTeapots(dao);
                    break;
                case 3:
                    printCheapestProducts(dao);
                    break;
                default:
                    break;
            }
        } while (result != 0);
    }

    
    /** 
     * Prints all products that can be accessed by the DAO
     * @param dao Data access object providing the product list
     * @throws XPathExpressionException
     */
    private static void printProducts(DAO dao) throws XPathExpressionException {
        System.out.println("Products:");
        for (var product : dao.getProducts()) {
            System.out.println(product);
        }
    }

    
    /**
     * Prints all products marked as teapot
     * @param dao Data access object providing the product list
     * @throws XPathExpressionException
     */
    private static void printTeapots(DAO dao) throws XPathExpressionException {
        System.out.println("Teapots:");
        for (var teapot : dao.getTeapots()) {
            System.out.println(teapot);
        }
    }

    
    /**
     * Finds the cost of the cheapest product price, and prints all products
     * worth this much
     * @param dao Data access object providing the product list
     * @throws XPathExpressionException
     */
    private static void printCheapestProducts(DAO dao) throws XPathExpressionException {
        System.out.println("Cheapest products:");
        for (var teapot : ProductFilterer.getCheapestProducts(dao.getProducts())) {
            System.out.println(teapot);
        }
    }
}
