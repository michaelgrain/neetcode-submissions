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
    public int maxPathSum(TreeNode root) 
    {
        int maxSum = Integer.MIN_VALUE;

        // Стек для обхода узлов
        Deque<TreeNode> stack = new ArrayDeque<>();
        // Храним "вклад" (gain), который узел передаёт наверх, после того как он обработан
        Map<TreeNode, Integer> gain = new HashMap<>();
        // last — последний обработанный узел, чтобы понять, откуда мы "вернулись"
        TreeNode last = null;

        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) 
        {
            // Спускаемся максимально влево
            if (curr != null) 
            {
                stack.push(curr);
                curr = curr.left;
            } 
            else 
            {
                TreeNode peek = stack.peek();
                // Если есть правый ребёнок и мы ещё не обработали его — идём направо
                if (peek.right != null && last != peek.right) 
                {
                    curr = peek.right;
                } 
                else 
                {
                    // Обрабатываем узел (постфиксно): оба ребёнка уже обработаны
                    stack.pop();

                    int leftGain = peek.left != null 
                        ? Math.max(gain.get(peek.left), 0) : 0;
                    int rightGain = peek.right != null 
                        ? Math.max(gain.get(peek.right), 0) : 0;

                    int pathThroughNode = peek.val + leftGain + rightGain;
                    maxSum = Math.max(maxSum, pathThroughNode);

                    gain.put(peek, peek.val + Math.max(leftGain, rightGain));

                    last = peek;
                }
            }
        }

        return maxSum;
    }
}