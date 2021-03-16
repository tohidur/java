import java.util.*;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; };
}


class Solution {
    public void flatten(TreeNode root) {
        if (root == null) return;

        Stack<TreeNode> s = new Stack<>();
        s.push(root);

        while (!s.isEmpty()) {
            TreeNode cn = s.pop();
            if (cn.right != null)
                s.push(cn.right);
            if (cn.left != null)
                s.push(cn.left);

            if (!s.isEmpty()) {
                cn.right = s.peek();
            }

            cn.left = null;
        }
    }

    public static void main(String args[]) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);

        Solution sol = new Solution();
        sol.flatten(root);
        System.out.println(root.val);
        System.out.println(root.left);
        System.out.println(root.right.val);
        System.out.println(root.right.left);
        System.out.println(root.right.right.val);
        System.out.println(root.right.right.left);
        System.out.println(root.right.right.right.val);
        System.out.println(root.right.right.right.left);
        System.out.println(root.right.right.right.right.val);
        System.out.println(root.right.right.right.right.left);
        System.out.println(root.right.right.right.right.right.val);
        System.out.println(root.right.right.right.right.right.left);
        System.out.println(root.right.right.right.right.right.right);
    }
}

