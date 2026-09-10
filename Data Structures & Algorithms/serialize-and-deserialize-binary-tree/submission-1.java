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

public class Codec 
{
    private static final String NULL_MARKER = "N";
    private static final String DELIMITER = ",";

    // Сериализация: обход по уровням (BFS)
    public String serialize(TreeNode root) 
    {
        if (root == null) 
        {
            return NULL_MARKER;
        }

        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) 
        {
            TreeNode node = queue.poll();

            if (node == null) 
            {
                sb.append(NULL_MARKER).append(DELIMITER);
            } 
            else 
            {
                sb.append(node.val).append(DELIMITER);
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }

        return sb.toString();
    }

    // Десериализация: восстанавливаем по уровням
    public TreeNode deserialize(String data) 
    {
        String[] values = data.split(DELIMITER);

        if (values[0].equals(NULL_MARKER)) 
        {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (!queue.isEmpty() && i < values.length) 
        {
            TreeNode node = queue.poll();

            // левый потомок
            if (!values[i].equals(NULL_MARKER)) 
            {
                node.left = new TreeNode(Integer.parseInt(values[i]));
                queue.offer(node.left);
            }
            i++;

            // правый потомок
            if (i < values.length && !values[i].equals(NULL_MARKER)) 
            {
                node.right = new TreeNode(Integer.parseInt(values[i]));
                queue.offer(node.right);
            }
            i++;
        }

        return root;
    }
}
