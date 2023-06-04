package ds.Fox;


import java.util.ArrayList;
import java.util.List;

public class ProductService {

    TreeNode root;

    public ProductService() {
        root = null;
    }

    public void addProduct(String id, String name, double price) {
        Product product = new Product(id, name, price);
        root = insertRecursive(root, product);
    }


    private TreeNode insertRecursive(TreeNode current, Product product) {
        if (current == null) {
            return new TreeNode(product);
        }
        if (product.price < current.productList.get(0).price) {
            current.left = insertRecursive(current.left, product);
        } else if (product.price > current.productList.get(0).price) {
            current.right = insertRecursive(current.right, product);
        } else {
            current.addProduct(product);
        }
        return current;
    }

    public List<Product> searchProduct(double start, double end) {
        List<Product> products = new ArrayList<>();
        findProducts(root, start, end, products);
        return products;
    }

    private void findProducts(TreeNode root, double start, double end, List<Product> products) {
        if(root==null) {
            return;
        }

        if(root.productList.get(0).price >= start && root.productList.get(0).price <= end) {
            products.addAll(root.productList);
            findProducts(root.left, start, end, products);
            findProducts(root.right, start, end, products);
        } else if(root.productList.get(0).price < start)
            findProducts(root.right, start, end, products);
        else if(root.productList.get(0).price > end)
            findProducts(root.left, start, end, products);
    }


}
