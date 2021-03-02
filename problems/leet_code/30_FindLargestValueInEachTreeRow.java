 // Find the largest value of each row in the binary tree
import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> largestVals = new ArrayList<>();
        _findMax(root, largestVals, 0);
        return largestVals;
    }

    private void _findMax(TreeNode root, List<Integer> largestVals, int level) {
        if (root == null) return;

        if (level == largestVals.size()) {
            // No values added yet for current level
            largestVals.add(root.val);
        } else {
            largestVals.set(level, Math.max(largestVals.get(level), root.val));
        }
        _findMax(root.left, largestVals, level+1);
        _findMax(root.right, largestVals, level+1);
    }

    public static void main(String args[]) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(3);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);

        Solution sol = new Solution();
        for (int i : sol.largestValues(root))
            System.out.println(i);
    }
}

