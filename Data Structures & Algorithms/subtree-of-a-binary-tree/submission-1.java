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
    public boolean isSubtree(TreeNode root, TreeNode subRoot)
    {
        if (subRoot == null)
            return true;
        if (root == null)
            return false;

        // Итеративный обход root (DFS через явный стек)
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        while (!stack.isEmpty())
        {
            TreeNode node = stack.pop();
            if (isSameIterative(node, subRoot))
            {
                return true;
            }

            if (node.right != null)
                stack.push(node.right);
            if (node.left != null)
                stack.push(node.left);
        }

        return false;
    }

    private boolean isSameIterative(TreeNode a, TreeNode b)
    {
        Deque<TreeNode[]> stack = new ArrayDeque<>();
        stack.push(new TreeNode[] { a, b });

        while (!stack.isEmpty())
        {
            TreeNode[] pair = stack.pop();
            TreeNode n1 = pair[0];
            TreeNode n2 = pair[1];

            if (n1 == null && n2 == null)
                continue;
            if (n1 == null || n2 == null)
                return false;
            if (n1.val != n2.val)
                return false;

            stack.push(new TreeNode[] { n1.left, n2.left });
            stack.push(new TreeNode[] { n1.right, n2.right });
        }

        return true;
    }
}
