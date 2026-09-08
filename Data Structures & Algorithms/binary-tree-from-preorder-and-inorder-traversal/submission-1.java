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
    public TreeNode buildTree(int[] preorder, int[] inorder) 
    {
        if (preorder.length == 0) return null;

        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode root = new TreeNode(preorder[0]);
        stack.push(root);

        int inorderIndex = 0; // указатель на текущий "самый левый непосещённый" элемент inorder

        for (int i = 1; i < preorder.length; i++) 
        {
            int value = preorder[i];
            TreeNode node = new TreeNode(value);
            TreeNode parent = stack.peek();

            if (parent.val != inorder[inorderIndex]) 
            {
                // Вершина поддерева ещё не "закрыта" -> новый узел это левый ребёнок
                parent.left = node;
            } else 
            {
                // Поднимаемся по стеку, пока верхний элемент совпадает с inorder[inorderIndex]
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) 
                {
                    parent = stack.pop();
                    inorderIndex++;
                }
                // Новый узел — правый ребёнок последнего "закрытого" родителя
                parent.right = node;
            }
            stack.push(node);
        }

        return root;
    }
}