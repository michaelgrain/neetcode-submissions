/**
 * Construct Binary Tree from Preorder and Inorder Traversal
 * Difficulty: Medium
 *
 * You are given two integer arrays `preorder` and `inorder`.
 *
 * - `preorder` is the preorder traversal of a binary tree
 * - `inorder` is the inorder traversal of the same tree
 * - Both arrays are of the same size and consist of unique values.
 *
 * Rebuild the binary tree from the preorder and inorder traversals and
 * return its root.
 */
class Solution 
{
    private Map<Integer, Integer> inorderIndexMap;
    private int[] preorder;
    private int preorderIndex;

    public TreeNode buildTree(int[] preorder, int[] inorder) 
    {
        this.preorder = preorder;
        this.preorderIndex = 0;

        // Сохраняем индекс каждого значения в inorder для быстрого поиска O(1)
        inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) 
        {
            inorderIndexMap.put(inorder[i], i);
        }

        return build(0, inorder.length - 1);
    }

    private TreeNode build(int inorderLeft, int inorderRight) 
    {
        // Если границы пересеклись — поддерево пустое
        if (inorderLeft > inorderRight) 
        {
            return null;
        }

        // Берём следующий элемент preorder — это корень текущего поддерева
        int rootVal = preorder[preorderIndex];
        preorderIndex++;

        TreeNode root = new TreeNode(rootVal);

        // Находим позицию корня в inorder
        int rootIndexInInorder = inorderIndexMap.get(rootVal);

        // Сначала строим левое поддерево (т.к. preorder идёт: корень -> левое -> правое)
        root.left = build(inorderLeft, rootIndexInInorder - 1);
        root.right = build(rootIndexInInorder + 1, inorderRight);

        return root;
    }
}