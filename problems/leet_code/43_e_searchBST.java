/*
 *  Search in BST. Return the sub-tree.
 */


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public TreeNode searchBST(TreeNode root, int n) {
        if (root == null) return root;

        if (n == root.val) {
            return root;
        } else if (n < root.val) {
            return searchBST(root.left, n);
        } else {
            return searchBST(root.right, n);
        }
    }

    public static void main(String args[]) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        Solution sol = new Solution();
        System.out.println(sol.searchBST(root, 2).val);
    }
}
