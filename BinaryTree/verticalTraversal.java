/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    class Node{
        int row;
        int col;
        int val;    
        Node(int row, int col, int val){
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }
    void traverse(TreeNode root, int row, int column, List<Node> nodes){
        if(root == null) return;
        nodes.add(new Node(row,column,root.val));
        traverse(root.left,row+1,column-1,nodes);
        traverse(root.right,row+1,column+1,nodes);
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<Node> nodes = new ArrayList<>();
        traverse(root,0,0,nodes);
        nodes.sort((a,b)->{
            if(a.col != b.col) return Integer.compare(a.col,b.col);
            if(a.row != b.row) return Integer.compare(a.row,b.row);
            return Integer.compare(a.val,b.val);
        });
        List<List<Integer>> ret = new ArrayList<>();
        int prevCol = Integer.MIN_VALUE;
        List<Integer> current = new ArrayList<>();
        for(Node node : nodes){
            if(node.col != prevCol){
                if(!current.isEmpty()) ret.add(current);
                current = new ArrayList<>();
                prevCol = node.col;
            }
            current.add(node.val);
        }
        ret.add(current);
        return ret;
    }
}