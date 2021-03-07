/* Range Sum Of BST
 *
 * Given the root node of binary search tree Return the sum of values of all
 * nodes with value between L and R (inclusive)
 *
 * It's guarented to have unique value
 */

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; };
}

class Solution {
    public int rangeSumBST(TreeNode root, int L, int R) {
        int sum = 0;

        Stack<TreeNode> s = new Stack<>();
        s.push(root);

        while (!s.isEmpty()) {
            TreeNode n = s.pop();
            if (n == null) continue;

            if (n.val >= L && n.val <= R) {
                sum += n.val;
            }

            if (n.val > L)
                s.push(n.left);

            if (n.val < R)
                s.push(n.right);
        }

        return sum;
    }

    public static void main(String args[]) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(18);

        Solution sol = new Solution();
        System.out.println(sol.rangeSumBST(root, 7, 15));
    }
}

