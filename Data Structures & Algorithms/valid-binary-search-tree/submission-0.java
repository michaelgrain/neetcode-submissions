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
    public boolean isValidBST(TreeNode node) 
    {
        return validate(node, null, null);
    }

    private boolean validate(TreeNode node, Long lower, Long upper) 
    {
        if (node == null) 
        {
            return true;
        }

        long val = node.val;

        if (lower != null && val <= lower) 
        {
            return false;
        }
        if (upper != null && val >= upper) 
        {
            return false;
        }

        return validate(node.left, lower, val) && validate(node.right, val, upper);
    }    
}
