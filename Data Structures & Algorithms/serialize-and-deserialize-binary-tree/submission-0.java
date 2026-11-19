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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        StringBuilder sb = new StringBuilder();

        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            if(node == null) {
                sb.append("n ");
                continue;
            }

            sb.append(node.val + " ");
            q.add(node.left);
            q.add(node.right);
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("")) return null;

        Queue<TreeNode> q = new LinkedList<>();
        String[] values = data.split(" ");

        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        q.add(root);

        for(int i=1; i<values.length; i++) {
            TreeNode parent = q.poll();
            if(!values[i].equals("n")) {
                parent.left = new TreeNode(Integer.parseInt(values[i]));
                q.add(parent.left);
            }

            if(!values[++i].equals("n")) {
                parent.right = new TreeNode(Integer.parseInt(values[i]));
                q.add(parent.right);
            }
        }

        return root;
    }
}
