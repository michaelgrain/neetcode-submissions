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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) 
    {
        TreeNode current = root;

        while (current != null) 
        {
            // Оба узла лежат левее текущего — спускаемся влево
            if (p.val < current.val && q.val < current.val) 
            {
                current = current.left;
            }
            // Оба узла лежат правее текущего — спускаемся вправо
            else if (p.val > current.val && q.val > current.val) 
            {
                current = current.right;
            }
            // Пути к p и q разошлись (или текущий узел сам является p или q) —
            // значит нашли точку расхождения, это и есть LCA
            else 
            {
                return current;
            }
        }

        // По условию задачи p и q всегда есть в дереве,
        // поэтому до этой строки код не дойдёт
        return null;
    }
}
