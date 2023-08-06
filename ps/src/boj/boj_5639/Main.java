package boj.boj_5639;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final Input input = new Input();
    private static Node root;

    public static void main(String[] args) throws Exception {
        root = new Node(input.getInteger());
        while (true) {
            String number = input.br.readLine();
            if (number == null || number.isBlank()) {
                break;
            }
            root.add(Integer.parseInt(number));
        }
        postOrder(root);
    }

    private static void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.data);
    }

    static class Node {

        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }

        void add(int number) {
            if (number < this.data) {
                if (this.left == null) {
                    this.left = new Node(number);
                } else {
                    this.left.add(number);
                }
            } else {
                if (this.right == null) {
                    this.right = new Node(number);
                } else {
                    this.right.add(number);
                }
            }
        }
    }

    static class Input {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        public int getInteger() throws Exception {
            if (!st.hasMoreElements()) {
                st = new StringTokenizer(br.readLine());
            }
            return Integer.parseInt(st.nextToken());
        }

        public String getString() throws Exception {
            if (!st.hasMoreElements()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }
    }
}
