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
    private TreeNode rootAfterDeletingNode(TreeNode root) {
        if(root.left == null) return root.right;
        if(root.right == null) return root.left;

        TreeNode leftmostNodeOfRightSubtree = root.right;

        while(leftmostNodeOfRightSubtree.left != null) {
            leftmostNodeOfRightSubtree = leftmostNodeOfRightSubtree.left;
        }

        leftmostNodeOfRightSubtree.left = root.left;

        return root.right;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;

        if(root.val == key) return rootAfterDeletingNode(root);

        TreeNode temp = root;
        while(temp != null) {
            if(temp.val > key) {
                if(temp.left != null && temp.left.val == key) {
                    temp.left = rootAfterDeletingNode(temp.left);
                    break;
                } else {
                    temp = temp.left;
                }
            } else {
                if(temp.right != null && temp.right.val == key) {
                    temp.right = rootAfterDeletingNode(temp.right);
                    break;
                } else {
                    temp = temp.right;
                }
            }
        } 

        return root;
    }
}