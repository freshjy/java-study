package Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LinkedTreeTest {

	public static void main(String[] args) {
		/*List<String> list = new ArrayList<String>();
		// TODO Auto-generated method stub
		LinkedTree<String> tree = new LinkedTree<String>("A");
		LinkedTree.TreeNode<String> nodeA = tree.getRoot();
		LinkedTree.TreeNode<String> nodeB = tree.insertLeft(nodeA, "B");
		LinkedTree.TreeNode<String> nodeC = tree.insertRight(nodeA, "C");
		
		LinkedTree.TreeNode<String> nodeD = tree.insertLeft(nodeB, "D");
		LinkedTree.TreeNode<String> nodeE = tree.insertRight(nodeB, "E");
		
		LinkedTree.TreeNode<String> nodeF = tree.insertLeft(nodeC, "F");
		LinkedTree.TreeNode<String> nodeG = tree.insertRight(nodeC, "G");
		
		tree.insertLeft(nodeD, "H");
		tree.insertRight(nodeD, "I");
		
		tree.insertLeft(nodeE, "J");
		
		tree.insertRight(nodeF, "K");
		
		tree.insertLeft(nodeG, "L");
		tree.insertRight(nodeG, "M");
		
		tree.traversalPostorder(list);		
		System.out.println(Arrays.toString(list.toArray()));
		
		list.clear();
		tree.traversalPreorder(list);
		System.out.println(Arrays.toString(list.toArray()));
		
		list.clear();
		tree.traversalInorder(list);
		System.out.println(Arrays.toString(list.toArray()));
		*/
		
		List<String> list = new ArrayList<String>();
		TreeCalculator cal = new TreeCalculator("4*2+7-1+4+6*6");
		
		System.out.println(cal.infixToPostfix());
		
		System.out.println("================================================");
		LinkedTree<String> tree = cal.makeExpressionTree();
		tree.traversalPostorder(list);
		System.out.println(Arrays.toString(list.toArray()));
		int result = cal.evaluateExpressionTree(tree.getRoot());
		System.out.println("Result: " + result);
	
		
		
		
		
	}

}
