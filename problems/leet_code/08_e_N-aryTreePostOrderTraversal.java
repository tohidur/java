/* N-ary Tree postorder traversal
 *
 * Given an n-ary tree return the post order traversal of it's node's values
 *
 */


import java.io.*;
import java.util.*;


class Node {
    public int val;
    public List<Node> children = new ArrayList<Node>();

    public Node(int _val) {
        val = _val;
    };
}


class Solution {
    public List<Integer> postOrder(Node root) {
        LinkedList<Node> stack  = new LinkedList<>();
        LinkedList<Integer> output_arr = new LinkedList<>();

        if (root == null)
            return output_arr;

      
        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pollLast();
            output_arr.addFirst(node.val);
            for (Node child : node.children) {
                stack.add(child);
            }
        }

        return output_arr;
    }

    public static void main(String args[]) {
        Node root = new Node(1);
        root.children.add(new Node(3));
        root.children.add(new Node(2));
        root.children.add(new Node(4));
        root.children.get(0).children.add(new Node(5));
        root.children.get(0).children.add(new Node(6));

        Solution sol = new Solution();
        List<Integer> res = sol.postOrder(root);
        System.out.println(res);
    }
}

