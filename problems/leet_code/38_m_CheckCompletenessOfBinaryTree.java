/* Check completeness of binary tree
 */

import java.util.Queue;
import java.util.LinkedList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; };
}

class Solution {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode n = q.remove();
            System.out.println((n != null) ? n.val : n);
            for (TreeNode i : q)
                System.out.print(((i != null) ? i.val : i) + ",  ");
            System.out.println("");
            System.out.println("====");
            if (n == null && !q.isEmpty())
                return false;

            if (n != null && (n.left != null || n.right != null)) {
                q.add(n.left);
                q.add(n.right);
            }
        }

        return true;
    }

    public static void main(String args[]) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);

        Solution sol = new Solution();
        System.out.println(sol.isCompleteTree(root));
    }
}

