class TreeNode {
    public int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) { val = x; }
}


class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        System.out.println(root + "==" + sum);
        if (root == null) {
            if (sum == 0)
                return true;
            return false;
        }
        System.out.println(root.val);

        sum -= root.val;
        boolean lhs = hasPathSum(root.left, sum);
        if (lhs == true) {
            return true;
        } else {
            return hasPathSum(root.right, sum);
        }
    }

    public static void main(String args[]) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);

        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right.right = new TreeNode(1);

        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        Solution sol = new Solution();
        System.out.println(sol.hasPathSum(root1, 1));

    }
}
