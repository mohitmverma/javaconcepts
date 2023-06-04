package ds.tree;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");


        BinaryTree tree = new BinaryTree();

        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, -1, -1, -1, -1, -1, -1, 9};

        tree.insert(5);
        tree.insert(2);
        tree.insert(8);
        tree.insert(1);
        tree.insert(3);

        System.out.println(tree.root.val + " " + tree.root.left.val);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        left = null;
        right = null;
    }
}

class BinaryTree {
    TreeNode root;

    public BinaryTree() {
        root = null;
    }

    public void insert(int val) {
        root = insertRecursive(root, val);
    }

    public void insert(int arr[]) {
        if(arr ==null || arr.length == 0)
            return ;

        int i=0;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(new TreeNode(arr[i++]));

        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            if(i<arr.length) {
                node.left = new TreeNode(arr[i++]);
                q.add(node.left);
            }
            if(i<arr.length) {
                node.right = new TreeNode(arr[i++]);
                q.add(node.right);
            }
        }
    }
    private TreeNode insertRecursive(TreeNode current, int val) {
        if (current == null) {
            return new TreeNode(val);
        }

        if (val < current.val) {
            current.left = insertRecursive(current.left, val);
        } else if (val > current.val) {
            current.right = insertRecursive(current.right, val);
        } else {
            return current;
        }
        return current;
    }
}