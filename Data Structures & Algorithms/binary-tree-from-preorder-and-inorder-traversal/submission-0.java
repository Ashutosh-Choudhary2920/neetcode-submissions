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
    public TreeNode buildTree(int preStart, int preEnd, int[] preorder, int inStart, int inEnd, int[] inorder, Map<Integer, Integer> inMap) {
        if(preStart > preEnd || inStart > inEnd) return null;

        TreeNode root = new TreeNode(preorder[preStart]);

        int inRoot = inMap.get(preorder[preStart]);
        int leftTreeNodeCounts = inRoot - inStart;

        root.left = buildTree(preStart+1, preStart + leftTreeNodeCounts, preorder, inStart, inRoot-1, inorder, inMap);

        root.right = buildTree(preStart+leftTreeNodeCounts+1, preEnd, preorder, inRoot+1, inEnd, inorder, inMap);

        return root;

    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }

        return buildTree(0, preorder.length-1, preorder, 0, inorder.length-1, inorder, inMap);

    }
}
