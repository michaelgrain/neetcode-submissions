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
    public int kthSmallest(TreeNode root, int k) 
    {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode node = root;

        while (node != null || !stack.isEmpty()) 
        {
            while (node != null) 
            {
                stack.push(node);
                node = node.left;
            }

            node = stack.pop();
            k--;

            if (k == 0) 
            {
                return node.val;
            }

            node = node.right;
        }

        throw new IllegalArgumentException("k превышает количество узлов в дереве");        
    }
}
