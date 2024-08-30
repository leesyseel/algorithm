import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb;

	static class Node {

		char value;
		Node left;
		Node right;

		public Node(char value, Node left, Node right) {
			super();
			this.value = value;
			this.left = left;
			this.right = right;
		}
	}

	static void insertNode(Node tmp, char parent, char left, char right) {

		if (tmp.value == parent) {
			tmp.left = (left == '.' ? null : new Node(left, null, null));
			tmp.right = (right == '.' ? null : new Node(right, null, null));
		} else {

			if (tmp.left != null) {
				insertNode(tmp.left, parent, left, right);
			}
			if (tmp.right != null) {
				insertNode(tmp.right, parent, left, right);
			}
		}
	}

	static void preOrder(Node node) {

		if (node == null)
			return;

		sb.append(node.value);
		preOrder(node.left);
		preOrder(node.right);
	}

	static void midOrder(Node node) {

		if (node == null)
			return;

		midOrder(node.left);
		sb.append(node.value);
		midOrder(node.right);
	}
	
	static void postOrder(Node node) {

		if (node == null)
			return;

		postOrder(node.left);
		postOrder(node.right);
		sb.append(node.value);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		Node head = new Node('A', null, null);
		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine());
			char p = stk.nextToken().charAt(0);
			char c1 = stk.nextToken().charAt(0);
			char c2 = stk.nextToken().charAt(0);

			insertNode(head, p, c1, c2);
		}

		preOrder(head);
		sb.append("\n");
		midOrder(head);
		sb.append("\n");
		postOrder(head);

		System.out.println(sb);

	}
}
