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
    public int kthSmallest(TreeNode root, int k) 
    {
        List<Integer> values = new ArrayList<>();
        inorder(root, values);
        // k нумеруется с 1, а индексы списка с 0, поэтому берём k - 1
        return values.get(k - 1);
    }

    // Рекурсивно собираем значения в порядке возрастания (in-order обход)
    private void inorder(TreeNode node, List<Integer> values) 
    {
        if (node == null) 
        {
            return;
        }
        inorder(node.left, values);   // сначала левое поддерево
        values.add(node.val);         // затем сам узел
        inorder(node.right, values);  // затем правое поддерево
    }
}
