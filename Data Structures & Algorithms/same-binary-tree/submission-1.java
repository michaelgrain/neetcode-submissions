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
        Queue<TreeNode> queueP = new LinkedList<>();
        Queue<TreeNode> queueQ = new LinkedList<>();
        queueP.offer(p);
        queueQ.offer(q);

        while (!queueP.isEmpty() && !queueQ.isEmpty())
        {
            TreeNode nodeP = queueP.poll();
            TreeNode nodeQ = queueQ.poll();

            // Оба null — идём дальше, эта пара узлов совпадает
            if (nodeP == null && nodeQ == null)
            {
                continue;
            }
            // Один null, другой нет, или значения различаются — деревья разные
            if (nodeP == null || nodeQ == null || nodeP.val != nodeQ.val)
            {
                return false;
            }

            queueP.offer(nodeP.left);
            queueQ.offer(nodeQ.left);
            queueP.offer(nodeP.right);
            queueQ.offer(nodeQ.right);
        }

        // Если одна очередь опустела раньше другой — деревья разной структуры
        return queueP.isEmpty() && queueQ.isEmpty();
    }
}
