package application;

import java.util.ArrayList;
import java.util.List;

import domain.Product;

public class ProductFilterer {
    private ProductFilterer () {}

    
    /** 
     * @param products Filters all but the cheapest products from the list
     * @return List<Product> Filtered list
     */
    public static List<Product> getCheapestProducts(List<Product> products) {
        int minimumPrice = getMinimumPrice(products);
        List<Product> filteredProducts = new ArrayList<>();
        for (Product product : products)
            if (product.getPrice() == minimumPrice)
                filteredProducts.add(product);
        return filteredProducts;
    }

    
    /** 
     * @param products Finds the minimal price in the list of products
     * @return int The cheapest product's price
     */
    private static int getMinimumPrice (List<Product> products) {
        int minimumPrice = Integer.MAX_VALUE;
        for (Product product : products)
            minimumPrice = Integer.min(minimumPrice, product.getPrice());
        return minimumPrice;
    }
}
