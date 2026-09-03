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

class Solution 
{
    public boolean isSameTree(TreeNode p, TreeNode q)
    {
        if (p == null || q == null)
        {
            return p == q; // true, только если оба null; false — если только один
        }
        // Значения текущих узлов должны совпадать,
        // и оба поддерева (левое и правое) должны быть идентичны рекурсивно
        return p.val == q.val 
                && isSameTree(p.left, q.left) 
                && isSameTree(p.right, q.right);
    }
}
