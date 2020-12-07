package tree;

import arraylist.ArrayList;
import stack.Stack;
import tree.LinkedTree.TreeNode;

public class TreeCalculator {
	
	private String infixExpression;
	
	private LinkedTree<String> tree = new LinkedTree<String>();
	private String success = "";
	private String[] postfixArr;
	
	public TreeCalculator(String infixExpression) {
		this.infixExpression = infixExpression;
	}		
	
	public Stack<Character> bracketInStack(char arr, Stack<Character> stack) {
		if(!stack.empty())		success += stack.pop();
		stack.push(arr);
		return stack ;
	}
	
	public boolean multipleDivedeOperCheck(Stack<Character> stack) {
		boolean check = false;
		if(stack.peak() =='*' || stack.peak() == '/')	check  = true;
		return check;
	}
	
	public boolean plusMinusOperCheck(Stack<Character> stack) {
		boolean check = false;
		if(stack.peak() == '+' || stack.peak() == '-') check = true;
		return check;
	}	
	
	public String infixToPostfix() {
		Stack<Character> stack = new Stack<Character>();
		char[] arr = infixExpression.toCharArray();

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] >= '0' && arr[i] <= '9') {
				success += arr[i];
			} else {
				switch (arr[i]) {
				case '(':
					stack.push(arr[i]);
					break;
				case ')':
					while (stack.peak() != '(')
						success += stack.pop();
					stack.pop();
					break;
				default:
					if (arr[i] == '+' || arr[i] == '-'
							&& !(stack.empty() && multipleDivedeOperCheck(stack) && plusMinusOperCheck(stack))) {
						bracketInStack(arr[i], stack);
					} else if (!stack.empty() && multipleDivedeOperCheck(stack)) {
						bracketInStack(arr[i], stack);
					} else
						stack.push(arr[i]);
				}
			}
		}

		while (!stack.empty()) {
			success += stack.pop();
		}

		
		postfixArr = success.split("");
		//postfixArr = success.toCharArray();
		
		
		return success;
	}	
	
	
	
	
	static boolean isNumber(String str) {
		boolean result = true;
		if (str == null || str.length() == 0) {
			result = false;
		}
		else {
			for (int i = 0; i < str.length(); i++) {
				int c = (int) str.charAt(i);
				if (c < 48 || c > 57) {
					result = false;
				}
			}
		}
		return result;
	}
	
	
	
	public int evaluateExpressionTree(TreeNode<String> treeNode) {
		int lValue = 0;
		int rValue = 0;
		if(treeNode.getLeft()!=null) {
			lValue = evaluateExpressionTree(treeNode.getLeft());
		}
		if(treeNode.getRight()!=null) {
			rValue = evaluateExpressionTree(treeNode.getRight());
		}
		
		switch(treeNode.getData()){
		case "+":
			return lValue+rValue;
		case "-":
			return lValue-rValue;
		case "*":
			return lValue*rValue;
		case "/":
			return lValue/rValue;
		}
		
		return Integer.parseInt(treeNode.getData());
	}
	
	public LinkedTree<String> makeExpressionTree() {
		Stack<LinkedTree.TreeNode<String>> treeStack = new Stack<LinkedTree.TreeNode<String>>();
		LinkedTree.TreeNode<String> newNode;
		
		for(int i=0; i<postfixArr.length; i++) {
			
			if(isNumber(postfixArr[i])) {
				
				newNode = new LinkedTree.TreeNode<String>(postfixArr[i]);
				treeStack.push(newNode);
			}else {
				newNode = new LinkedTree.TreeNode<String>(postfixArr[i]);
				tree.insertRight(newNode, treeStack.pop());
				tree.insertLeft(newNode, treeStack.pop());
				treeStack.push(newNode);
			}
		}
		tree.setRoot(treeStack.pop());
		return tree;
	}

}
