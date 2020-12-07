package doublelinkedlist;

public class DoublyLinkedListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
		
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(70);
		
		//System.out.println(list.get(1));
		/*for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}*/
		
		for(int i : list) {
			System.out.println(i);
		}
	}

}
