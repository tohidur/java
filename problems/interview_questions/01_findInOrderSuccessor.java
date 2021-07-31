import java.util.LinkedList;
import java.util.ArrayList;


class Solution {
    static class Node {
        int key;
        Node left;
        Node right;
        Node parent;

        Node (int key) {
            this.key = key;
            left = null;
            right = null;
            parent = null;
        }
    }

    static class BinarySearchTree {
        Node root;

        Node findInOrderSuccessor(Node inputNode) {
            if (root == null)
                return null;

            LinkedList<Node> stack = new LinkedList<>();
            ArrayList<Node> result = new ArrayList<>();
            Node currentNode = root;
            boolean foundKey = false;

            while (currentNode != null || !stack.isEmpty()) {
                while (currentNode != null) {
                    stack.push(currentNode);
                    currentNode = currentNode.left;
                }

                currentNode = stack.pop();
                if (foundKey) {
                    for (Node n : result) {
                        System.out.println(n.key);
                    }
                    return currentNode;
                }

                result.add(currentNode);
                if (currentNode == inputNode) {
                    foundKey = true;
                }
                currentNode = currentNode.right;
            }

            return null;
        }

        void insert(int key) {
            if (this.root == null) {
                this.root = new Node(key);
                return;
            }

            Node currentNode = this.root;
            Node newNode = new Node(key);

            while(currentNode != null) {
                if (key < currentNode.key) {
                    if (currentNode.left == null) {
                        currentNode.left = newNode;
                        newNode.parent = currentNode;
                        break;
                    } else {
                        currentNode = currentNode.left;
                    }
                } else {
                    if (currentNode.right == null) {
                        currentNode.right = newNode;
                        newNode.parent = currentNode;
                        break;
                    } else {
                        currentNode = currentNode.right;
                    }
                }
            }
        }

        Node getNodeByKey(int key) {
            Node currentNode = this.root;

            while(currentNode != null) {
                if(key == currentNode.key) {
                    return currentNode;
                }

                if (key < currentNode.key) {
                    currentNode = currentNode.left;
                } else {
                    currentNode = currentNode.right;
                }
            }

            return null;
        }
    }

    public static void main(String[] args) {
        Node test = null, succ = null;

        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(20);
        tree.insert(9);
        tree.insert(25);
        tree.insert(5);
        tree.insert(12);
        tree.insert(11);
        tree.insert(14);

        System.out.println(tree.findInOrderSuccessor(tree.root.left).key);
    }
}

