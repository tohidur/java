import java.util.HashMap;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; };
}

class Solution {
    int max_width;
    HashMap<Integer, Integer> lvl_width;

    public int widthOfBinaryTree(TreeNode root) {
        lvl_width = new HashMap<>();
        get_max_width(root, 0, lvl_width);
        return max_width;
    }

    private void get_max_width(TreeNode root, int lvl, HashMap<Integer, Integer> lvl_width) {
        if (root == null) return;

        int cur = lvl_width.getOrDefault(lvl, 0);
        lvl_width.put(lvl, cur+1);
    }

    public static void main(String args[]) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);

        Solution sol = new Solution();
        System.out.println(sol.widthOfBinaryTree(root));
    }
}

