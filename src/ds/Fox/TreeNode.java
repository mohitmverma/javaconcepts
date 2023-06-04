package ds.Fox;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {

    TreeNode left;
    TreeNode right;

    List<Product> productList;

    TreeNode(Product product) {
        productList = new ArrayList<>();
        productList.add(product);
        left = null;
        right = null;
    }

    void addProduct(Product product) {
        productList.add(product);
    }
}
