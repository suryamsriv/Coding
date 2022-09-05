import java.util.ArrayList;
import java.util.List;

public class InOrderTraversal {
    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    List<Integer> traversal = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null)
            return traversal;
        inorderTraversal(root.left);
        traversal.add(root.val);
        inorderTraversal(root.right);

        return traversal;
    }
}
