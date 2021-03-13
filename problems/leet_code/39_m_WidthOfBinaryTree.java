import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; };
}

class Solution {
    int max_width;
    HashMap<Integer, Integer> leftmost_positions;

    public int widthOfBinaryTree(TreeNode root) {
        max_width = 0;
        leftmost_positions = new HashMap<>();
        get_width(root, 0, 0);
        return max_width;
    }

    public void get_width(TreeNode root, int depth, int position) {
        if (root == null) return;
        leftmost_positions.computeIfAbsent(depth, x->position);
        max_width = Math.max(max_width, position - leftmost_positions.get(depth)+1);
        get_width(root.left, depth+1, position*2);
        get_width(root.right, depth+1, position*2+1);
    }

    // Width of binary tree iterative - Error
    private class QE {
        TreeNode node;
        int lvl;
        int pos;
        QE(TreeNode n, int l, int p) {
            node = n;
            pos = p;
            lvl = l;
        }
    }

    public int widthOfBinaryTreeItr(TreeNode root) {
        if (root == null) return 0;

        int max_pos = 0;
        Queue<QE> q = new LinkedList<>();
        q.offer(new QE(root, 0, 0));

        while (!q.isEmpty()) {
            QE curQE = q.remove();

            if (curQE.node.left != null) {
                int lpos = 2 * curQE.pos + 1;
                q.offer(new QE(curQE.node.left, curQE.lvl+1, lpos));
            }
            if (curQE.node.right != null) {
                int rpos = 2 * curQE.pos + 2;
                q.offer(new QE(curQE.node.right, curQE.lvl+2, rpos));
            }
            int first_l = (int)(Math.pow(2, (curQE.pos-1)) - 1);
            max_pos = Math.max(max_pos, Math.abs(curQE.pos - first_l) - 1);
        }

        return max_pos;
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

