/* Binary Tree purning
 * 
 * We are given the root node of a binary tree, where additionally every nodes
 * value is either 0 or 1.
 * Return the same tree where every subtree (of the given tree not contains a
 * 1 has been removed.
 *
 * (Recall the subtree of node X is X, plus node that is descendant of X)
 *
 * Ex1:
 * Input: [1, null, 0, 0, 0]
 * Output: [1, null, 0, null, 1]
 *
 * Ex2:
 * Input: [1, 0, 1, 0, 0, 0, 1]
 * Output: [1, null, 1, null, 1]
 *
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public TreeNode purneTree(TreeNode root) {
        boolean is_one = _purneIfanyChildContainsOne(root);
        if (!is_one)
            return null;
        return root;
    }

    private boolean _purneIfanyChildContainsOne(TreeNode root) {
        boolean on_left = false, on_right = false; 

        if (root.left != null) {
            on_left = _purneIfanyChildContainsOne(root.left);
            if (!on_left)
                root.left = null;
        }
        if (root.right != null) {
            on_right =  _purneIfanyChildContainsOne(root.right);
            if (!on_right)
                root.right = null;
        }

        return (root.val == 1 || on_left || on_right);
    }

    public static void main(String args[]) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(0);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);

        Solution sol = new Solution();
        TreeNode res = sol.purneTree(root);
        System.out.println(res.val);
        System.out.println((res.left !=  null) ? res.left.val : null);
        System.out.println((res.right !=  null) ? res.right.val : null);
        System.out.println((res.right.left !=  null) ? res.right.left.val : null);
        System.out.println((res.right.right !=  null) ? res.right.right.val : null);

        System.out.println("Second sol");
        TreeNode r2 = new TreeNode(1);
        r2.left = new TreeNode(0);
        r2.right = new TreeNode(1);
        r2.left.left = new TreeNode(0);
        r2.left.right = new TreeNode(0);
        r2.right.left = new TreeNode(0);
        r2.right.right = new TreeNode(1);

        TreeNode res2 = sol.purneTree(r2);
        System.out.println(res2.val);
        System.out.println((res2.left !=  null) ? res2.left.val : null);
        System.out.println((res2.right !=  null) ? res2.right.val : null);
        System.out.println((res2.right.left !=  null) ? res2.right.left.val : null);
        System.out.println((res2.right.right !=  null) ? res2.right.right.val : null);
    }
}

