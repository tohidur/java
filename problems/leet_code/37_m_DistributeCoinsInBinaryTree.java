/* Distribute coins in binary tree
 *
 * Given the root of a binary tree with N nodes, each node in the tree has
 * node.val coins, and there are N coins total
 *
 * In one move, we may choose two adjacent nodes and move one coin from one
 * node to another 
 *
 * Return the number of moves required to make every node have exactly one
 * coin
 */

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode (int x) { val = x; };
}

class Solution {
    static int ans = 0;

    public int distributeCoins(TreeNode root) {
        distributeCoinsUtil(root);
        return ans;
    }

    public int distributeCoinsUtil(TreeNode root) {
        if (root == null) return 0;

        int l = distributeCoinsUtil(root.left);
        int r = distributeCoinsUtil(root.right);

        ans += Math.abs(l) + Math.abs(r);
        // System.out.println("===");
        // System.out.println("Moves: " + ((root.left != null) ? root.left.val : null) + "--" + ((root.right != null) ? root.right.val : null) + " :" + (Math.abs(l) + Math.abs(r)));
        // System.out.println(ans);
        // System.out.println("===");

        return root.val + l + r - 1;
    }

    public static void main(String args[]) {
        Solution sol = new Solution();

        // TreeNode root = new TreeNode(0);
        // root.left = new TreeNode(3);
        // root.right = new TreeNode(0);
        // System.out.println(sol.distributeCoins(root));


        TreeNode r2 = new TreeNode(0);
        r2.left = new TreeNode(0);
        r2.right = new TreeNode(0);
        r2.left.left = new TreeNode(2);
        r2.left.right = new TreeNode(0);
        r2.left.right.left = new TreeNode(1);
        r2.right.left = new TreeNode(3);
        r2.right.right = new TreeNode(0);
        r2.right.left.right = new TreeNode(3);
        System.out.println(sol.distributeCoins(r2));
    }
}

