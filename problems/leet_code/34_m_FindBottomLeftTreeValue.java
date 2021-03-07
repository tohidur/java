/* Find Bottom Left Tree Value
 *
 * Given a binary tree find the leftmost value in the last row of the tree
 *
 */
import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; };
}

class Solution {
    public int findBottomLeftValue(TreeNode root) {
        if (root == null) return 0;

        // Creata queue
        Queue<TreeNode> q = new LinkedList<TreeNode>();

        // start adding nodes to the queue

        TreeNode cur = root;
        q.add(root);
        while (!q.isEmpty()) {
            cur = q.remove();

            if (cur.right != null)
                q.add(cur.right);
            if (cur.left != null)
                q.add(cur.left);
        }
        return cur.val;
    }

    public static void main(String args[]) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);

        Solution s = new Solution();
        System.out.println(s.findBottomLeftValue(root));
    }
}

