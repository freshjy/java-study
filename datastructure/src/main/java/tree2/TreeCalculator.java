package tree2;

import java.util.Stack;

import arraylist.ArrayList;

public class TreeCalculator {
	private String infixExpression;
	private ArrayList<String> postfixExpression = new ArrayList<String>();
	private LinkedTree<String> tree = new LinkedTree<String>();

	public TreeCalculator(String infixExpression) {
		this.infixExpression = infixExpression;
	}

	public String infixToPostfix() {
		Stack<Character> stack = new Stack<Character>();
		char[] arrayExpression = new char[infixExpression.length()];

		for (int i = 0; i < arrayExpression.length; i++) {
			arrayExpression[i] = infixExpression.charAt(i);
		}

		for (int i = 0; i < arrayExpression.length; i++) {
			if (arrayExpression[i] == '(') {
				stack.push(arrayExpression[i]);
			} else if (arrayExpression[i] >= '0' && arrayExpression[i] <= '9') {
				postfixExpression.add(Character.toString(arrayExpression[i]));
			} else if (arrayExpression[i] == ')') {
				while (stack.peek() != '(') {
					postfixExpression.add(Character.toString(stack.pop()));
				}
				stack.pop();
			} else { // operator
				if (stack.empty() || stack.peek() == '(')
					stack.push(arrayExpression[i]);
				else if (comparePriority(arrayExpression[i], stack.peek()) > 0) {
					stack.push(arrayExpression[i]);
				} else {
					while (stack.size() != 0 && stack.peek() != '(') {
						postfixExpression.add(Character.toString(stack.pop()));
					}
					stack.push(arrayExpression[i]);
				}
			}
		}
		while (stack.size() != 0) {
			postfixExpression.add(Character.toString(stack.pop()));
		}
		String s = "";
		for (String i : postfixExpression) {
			s += i;
		}
		return s;
	}

	public LinkedTree<String> makeExpressionTree() {
		Stack<LinkedTree.TreeNode<String>> stack = new Stack<LinkedTree.TreeNode<String>>();

		LinkedTree.TreeNode<String> node;
		for (String s : postfixExpression) {
			if (s.equals("*") || s.equals("/") || s.equals("+") || s.equals("-")) {
				node = new LinkedTree.TreeNode<String>(s);
				tree.insertRight(node, stack.pop());
				tree.insertLeft(node, stack.pop());
				stack.push(node);
			} else {
				stack.push(new LinkedTree.TreeNode<String>(s));
			}
		}
		tree.setRoot(stack.pop());
		return tree;
	}

	public int evaluateExpressionTree(LinkedTree.TreeNode<String> node) {

		switch (node.getData()) {
		case "*":
			return evaluateExpressionTree(node.getLeft()) * evaluateExpressionTree(node.getRight());
		case "/":
			return evaluateExpressionTree(node.getLeft()) / evaluateExpressionTree(node.getRight());
		case "+":
			return evaluateExpressionTree(node.getLeft()) + evaluateExpressionTree(node.getRight());
		case "-":
			return evaluateExpressionTree(node.getLeft()) - evaluateExpressionTree(node.getRight());
		default:
			return Integer.parseInt(node.getData());
		}
	}

	private int comparePriority(char a, char b) {
		if (a == '*' || a == '/') {
			if (b == '*' || b == '/') {
				return 0;
			} else {
				return 1;
			}
		} else {
			if (b == '*' || b == '/') {
				return -1;
			} else {
				return 0;
			}
		}
	}

}
