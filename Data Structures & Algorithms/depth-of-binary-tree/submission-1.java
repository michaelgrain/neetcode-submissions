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
    public int maxDepth(TreeNode root)
    {
        // Пустое дерево — глубина равна нулю
        if (root == null)
        {
            return 0;
        }

        int depth = 0;
        // Очередь для обхода дерева в ширину (BFS), уровень за уровнем
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root); // добавляем корень как стартовую точку обхода

        // Пока в очереди есть необработанные узлы — обходим дерево дальше
        while (!queue.isEmpty())
        {
            // Количество узлов на текущем уровне
            // (фиксируем ДО того, как начнём добавлять узлы следующего уровня)
            int levelSize = queue.size();

            // Раз мы дошли до этого уровня — значит, глубина минимум +1
            depth++;

            // Обрабатываем все узлы текущего уровня,
            // одновременно добавляя в очередь узлы следующего уровня
            for (int i = 0; i < levelSize; i++)
            {
                TreeNode node = queue.poll(); // извлекаем очередной узел уровня

                // Если есть левый потомок — добавляем его в очередь
                // (он будет обработан на следующей итерации while, т.е. на следующем уровне)
                if (node.left != null)
                {
                    queue.offer(node.left);
                }

                // Аналогично для правого потомка
                if (node.right != null)
                {
                    queue.offer(node.right);
                }
            }
            // К этому моменту в очереди остались только узлы следующего уровня
        }

        // Когда очередь опустела — все уровни пройдены, возвращаем итоговую глубину
        return depth;
    }

}
