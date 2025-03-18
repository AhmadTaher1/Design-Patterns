package Visitor;

import java.util.LinkedList;
import java.util.Queue;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;

    }
};

public class Main2 {
//
//    Queue<Node>q=new LinkedList<>();
//    public void BFS2(Node node,int level){
//
//
//            if(node==null){
//                return;
//            }
//
//            if(node.left !=null || node.right!=null){
//                level++;
//                if(node.left!=null){
//                    BFS2(node.left,level);
//                }
//                if(node.right!=null){
//                    BFS2(node.right,level);
//                }
//            }
//    }

    public Node connect(Node node) {

        Queue<Node> q = new LinkedList<>();
        q.add(node);

        while (!q.isEmpty()) {

            int size = q.size();

            for (int i = 0; i < size; i++) {
                Node temp = q.poll();
                if (i < size - 1) {
                    temp.next = q.peek();
                } else {
                    temp.next = null;

                    if (temp.left != null) {
                        q.add(temp.left);
                    }
                    if (temp.right != null) {
                        q.add(temp.right);
                    }

                }
            }
            return node;
        }

return node;
    }
    }

//    public static void main(String[] args) {
//
//    }

