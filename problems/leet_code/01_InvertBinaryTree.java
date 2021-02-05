import java.io.*;
import java.util.*;


class TreeNode {
    public int val;
    TreeNode left;
    TreeNode right;
    private HashMap<Integer, List<TreeNode>> _lvlHM = new HashMap<Integer, List<TreeNode>>();

    TreeNode(int x) {
        val = x;
    }

    public int getVal() {
        return val;
    }

    private void setLvlHM(TreeNode node, Integer lvl) {
        List<TreeNode> nodes = _lvlHM.get(lvl);

        if (nodes == null)
            nodes = new ArrayList<>();

        nodes.add(node);
        _lvlHM.put(lvl, nodes);

        if (node != null) {
            setLvlHM(node.left, lvl+1);
            setLvlHM(node.right, lvl+1);
        }
    }

    public HashMap<Integer, List<TreeNode>> getLvlHM() {
        if (this != null && _lvlHM.size() > 0)
            return _lvlHM;

        setLvlHM(this, 0);
        return _lvlHM;
    }

    public int getLevelNum(TreeNode node) {
        HashMap<Integer, List<TreeNode>> lhm = getLvlHM();
        return lhm.size();
    }

    public void repr() {
        HashMap<Integer, List<TreeNode>> lhm = getLvlHM();
        Integer space = 4;
        Integer lvl_r = lhm.size();

        for (Integer key : lhm.keySet()) {
            List<TreeNode> nodes = lhm.get(key);

            StringBuilder prnt = new StringBuilder();
            for (TreeNode node : nodes) {
                for (int i = 0; i< space*lvl_r; i++) {
                    prnt.append(' ');
                }
                prnt.append((node != null) ? node.val : "-");
            }

            System.out.print(prnt.toString());
            System.out.print("\n\n");
            lvl_r -= 1;
        }
    }
}


class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.right = left;
        root.left = right;
        
        return root;
    }

    public static void main(String args[]) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        // root.left.right = new TreeNode(3);
        // root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        root.repr();

        Solution sol = new Solution();
        TreeNode result = sol.invertTree(root);

    }
}
