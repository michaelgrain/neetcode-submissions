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
    /**
     * Рекурсивный поиск наименьшего общего предка (LCA) в BST.
     *
     * Логика та же, что и в итеративной версии, но реализована через
     * рекурсивные вызовы вместо цикла:
     * - если оба узла меньше текущего — рекурсивно идём влево;
     * - если оба узла больше текущего — рекурсивно идём вправо;
     * - иначе (пути разошлись, либо текущий узел сам равен p или q) —
     *   текущий узел и есть искомый LCA.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) 
    {
        if(p == null || q == null)
          return null;
        
        // Оба искомых значения меньше текущего узла — LCA в левом поддереве
        if (p.val < root.val && q.val < root.val) 
        {
            return lowestCommonAncestor(root.left, p, q);
        }

        // Оба искомых значения больше текущего узла — LCA в правом поддереве
        if (p.val > root.val && q.val > root.val) 
        {
            return lowestCommonAncestor(root.right, p, q);
        }

        // Пути разошлись (или root совпадает с p или q) — нашли точку расхождения
        return root;
    }
}
