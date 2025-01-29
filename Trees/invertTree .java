// Leetcode Link: https://leetcode.com/problems/invert-binary-tree/
// Youtube Solution: https://youtu.be/yb2Y9h2YWio

//**************** Java Solution ***********************

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        
        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);
        
        root.left = right;
        root.right = left;
        return root;
    }
}

// Main class to test the solution
public class Main {
    public static void main(String[] args) {
        // Create a binary tree
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        
        // Print the original tree
        System.out.println("Original Tree:");
        printTree(root);
        
        // Invert the tree
        Solution solution = new Solution();
        TreeNode invertedRoot = solution.invertTree(root);
        
        // Print the inverted tree
        System.out.println("\nInverted Tree:");
        printTree(invertedRoot);
    }
    
    // Helper method to print the tree (in-order traversal)
    public static void printTree(TreeNode root) {
        if (root == null) {
            return;
        }
        printTree(root.left);
        System.out.print(root.val + " ");
        printTree(root.right);
    }
}