package tree;

import stack.Stack;
import tree.LinkedTree;
import tree.LinkedTree.TreeNode;

public class TreeCalculator2 {
	
	private String infixExpression;
	
	
	
	private Stack<Character> stack = new Stack<Character>();
	private Stack<String> treeStack = new Stack<String>();
	private String success = "";
	private String[] postfixArr;
	int calcul = 0;
	
	public TreeCalculator2(String infixExpression) {
		this.infixExpression = infixExpression;
	}		
	
	public Stack<Character> bracketInStack(char arr, Stack<Character> stack) {
		while(!stack.empty()) {
			if(stack.peak()=='(')	break;
			success += stack.pop();
		}
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
		LinkedTree<String> tree = null;
		TreeNode<String> newNode;
		LinkedTree.TreeNode<String> rightNode = null;
		LinkedTree.TreeNode<String> leftNode = null;
		
		boolean first = true;
		int num = 0;
		for(int i=0; i<postfixArr.length; i++) {
			if(isNumber(postfixArr[i])) {
				tree = new LinkedTree<String>(postfixArr[i]);
				newNode = tree.getRoot();
				treeStack.push(newNode.getData()); 
				num++;
			}else {
				if(first) {
					tree = new LinkedTree<String>(postfixArr[i]);
					newNode = tree.getRoot();
					newNode.getLeft();
					tree.insertRight(newNode, treeStack.pop());
					num--;
					tree.insertLeft(newNode, treeStack.pop());
					num--;
					rightNode = newNode;
					treeStack.push(newNode.getData());
					first = false;
				}else {
					tree = new LinkedTree<String>(postfixArr[i]);
					newNode = tree.getRoot();
					if(num==0) {
						newNode.setLeft(leftNode);
						treeStack.pop();
						newNode.setRight(rightNode);
						treeStack.pop();
					}else if(num==1) {
						treeStack.pop();
						newNode.setRight(rightNode);						
						tree.insertLeft(newNode, treeStack.pop());
						num--;
						rightNode = newNode;
						treeStack.push(newNode.getData());
						
					}else {
						tree.insertRight(newNode, treeStack.pop());
						num--;
						tree.insertLeft(newNode, treeStack.pop());
						num--;
						leftNode = newNode;
						treeStack.push(newNode.getData());
					}
					
				}				
			}
		}
		
		
		return tree;
	}

}
