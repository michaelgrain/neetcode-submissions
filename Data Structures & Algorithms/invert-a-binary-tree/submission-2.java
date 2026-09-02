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
    public TreeNode invertTree(TreeNode root) 
    {
        if (root == null) return null;

        Set<TreeNode> visited = Collections.newSetFromMap(new IdentityHashMap<>());
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        visited.add(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;

            if (current.left != null && !visited.contains(current.left)) 
            {
                visited.add(current.left);
                queue.add(current.left);
            }
            if (current.right != null && !visited.contains(current.right)) 
            {
                visited.add(current.right);
                queue.add(current.right);
            }
        }

        return root;
    }
}
