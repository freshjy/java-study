package circularlinkedlist2;

import java.util.ArrayList;
import java.util.Iterator;


public class CircularLinkedListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CircularLinkedList<Integer> list = new CircularLinkedList<>();
		
				
		list.add(10);
		list.add(20);
		list.add(30);
		//list.add(40);
		//list.add(50);
		//list.add(60);
		//list.add(70);
		
		//list.remove(2);
		System.out.println(list.get(0));
		
		
		Iterator<Integer> it = list.iterator();
		while(it.hasNext()) {
			int i = it.next();
			System.out.println(i);
		}
	}

}
















