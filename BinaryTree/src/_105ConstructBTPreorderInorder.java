import java.util.HashMap;

public class _105ConstructBTPreorderInorder {
    private int preorderFirst;
    private int[] preorder;
    private int[] inorder;
    HashMap<Integer, Integer> inorderIndexMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        this.preorderFirst = 0;

        int inorderIndex = 0;
        for (Integer i : inorder){
            inorderIndexMap.put(i, inorderIndex++);
        }

        return buildNode(0, inorder.length - 1);
    }

    private TreeNode buildNode(int inLeft, int inRight){
        if (inLeft > inRight) return null;

        int rootVal = preorder[preorderFirst];
        TreeNode root = new TreeNode(rootVal);

        int inorderRootIndex = inorderIndexMap.get(rootVal);

        preorderFirst++;
        root.left = buildNode(inLeft, inorderRootIndex - 1);
        root.right = buildNode(inorderRootIndex + 1, inRight);
        return root;
    }
}
