/*  Merge two binary trees
 *
 *  The merge rule.
 *  If two nodes overlap, then sum node values up as the new value of the
 *  merged node. Otherwise, the NOT null node will be used as the node of
 *  new tree
 */


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
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t2 == null)
            return t1;
        if (t1 == null)
            return t2;

        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);

        return t1;
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

        t1.repr();
        t2.repr();

        Solution sol = new Solution();
        TreeNode merged = sol.mergeTrees(t1, t2);
        merged.repr();
    }
}

