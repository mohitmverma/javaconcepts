package ds.Fox;

import java.util.List;

public class Main {
    public static void main(String[] args) {

    /*
        Add  a product to the catalog
        User can filter product based on price range
        Use a in memory store.
    */


        ProductService productService = new ProductService();

        productService.addProduct("a","A", 13);
        productService.addProduct("b","B", 11);
        productService.addProduct("c","C", 7);
        productService.addProduct("d","D", 15);
        productService.addProduct("e","E", 22);
        productService.addProduct("f","F", 16);
        productService.addProduct("g","G", 10);
        productService.addProduct("h","H", 25);
        productService.addProduct("i","I", 12);
        productService.addProduct("j","J", 15);
        productService.addProduct("k","K", 12);
        productService.addProduct("l","L", 18);
        productService.addProduct("m","M", 12);
        productService.addProduct("n","N", 10);
        productService.addProduct("o","O", 12);
        productService.addProduct("p","P", 9);



        List<Product> productList = productService.searchProduct(14,20);
        System.out.println(productList.size());
        for(Product product: productList) {
            System.out.println(product.productId + " " + product.name + " " + product.price);
        }

    }



}
