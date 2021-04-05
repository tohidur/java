/*
 * Find the sum of all leaves in a given binary tree
 */

import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;

        int sum = 0;
        Stack<TreeNode> s = new Stack<>();
        s.push(root);

        while (!s.isEmpty()) {
            TreeNode n = s.pop();
            if (n.left != null) {
                sum += n.left.val;
                s.push(n.left);
            }
            if (n.right != null) {
                s.push(n.right);
            }
        }

        return sum;
    }
    public static void main(String args[]) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        Solution sol = new Solution();
        System.out.println(sol.sumOfLeftLeaves(root));
    }
}
