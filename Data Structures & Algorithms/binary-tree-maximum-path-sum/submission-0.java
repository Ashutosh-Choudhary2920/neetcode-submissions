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
    int max = Integer.MIN_VALUE;
    public int maxPathSumHelper(TreeNode root) {
        if(root == null) return 0;

        int leftMaxSum = Math.max(0, maxPathSumHelper(root.left));
        int rightMaxSum = Math.max(0, maxPathSumHelper(root.right));

        int maxPathSumForCurrentNode = root.val + leftMaxSum + rightMaxSum;

        max = Math.max(max, maxPathSumForCurrentNode);

        return root.val + Math.max(leftMaxSum, rightMaxSum);
    }

    public int maxPathSum(TreeNode root) {
        maxPathSumHelper(root);

        return max;
    }
}
