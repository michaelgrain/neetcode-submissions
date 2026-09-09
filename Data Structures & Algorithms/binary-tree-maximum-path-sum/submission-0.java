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
    private int maxSum;

    public int maxPathSum(TreeNode root) 
    {
        maxSum = Integer.MIN_VALUE;
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode node) 
    {
        if (node == null) return 0;

        // Рекурсивно считаем максимальный вклад от левого и правого поддерева.
        // Если вклад отрицательный — не берём его вообще (Math.max(..., 0)).
        int leftGain = Math.max(dfs(node.left), 0);
        int rightGain = Math.max(dfs(node.right), 0);

        // Путь, который "проходит через" текущий узел (может использовать оба поддерева).
        // Такой путь нельзя продолжить наверх к родителю, поэтому обновляем
        // глобальный максимум прямо здесь.
        int pathThroughNode = node.val + leftGain + rightGain;
        maxSum = Math.max(maxSum, pathThroughNode);

        // А родителю возвращаем только "однорукий" путь — 
        // узел + лучшее ИЗ ОДНОГО поддерева (нельзя взять оба, 
        // иначе путь разветвится и перестанет быть простой цепочкой).
        return node.val + Math.max(leftGain, rightGain);
    }
}
