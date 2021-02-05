import java.io.*;


class TreeNode {
    public int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}


class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {

    }

    public static void main(String args[]) {
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(3);
        t1.right = new TreeNode(2);
        t1.left.left = new TreeNode(5);

        TreeNode t2 = new TreeNode(2);
        t2.left = new TreeNode(1);
        t2.right = new TreeNode(3);
        t2.left.right = new TreeNode(4);
        t2.right.right = new TreeNode(7);

        Solution sol = new Solution();
        TreeNode merged = sol.mergeTrees(t1, t2);

        TreeNode cur = merged;

        while (cur != null) {
            System.out.println(cur.val);
        }
    }
}

