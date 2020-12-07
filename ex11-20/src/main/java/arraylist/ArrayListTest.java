package arraylist;

import java.util.Iterator;

public class ArrayListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = new ArrayList<Integer>();
		List<String> list1 = new ArrayList<String>();
		
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(50);
		list.add(60);
		list.add(3, 100);
		System.out.println(list.size());
		
		
		System.out.println("���� �����ͼ�:"+list.size());
		
		for(int i=0; i < list.size(); i++){
			System.out.println(i+1 + "��° ������:" + list.get(i));
		}
		System.out.println();
				
		//list.removeAll();
		
		
		list1.add("hello");
		list1.add("2");
		list1.add("3");
		list1.add("4");
		list1.add(4,"world");
		list1.add(1,"hihihihi");
		//System.out.println(list1.size());
		list1.remove(2);
		
		for(int i=0; i < list1.size(); i++){
			System.out.println(i+1 + "��° ������:" + list1.get(i));
		}
		
		
		/*try {
			list.get(0);
		}catch(IndexOutOfBoundsException e) {
			e.printStackTrace();
		}*/
		
		//System.out.println("���� �����ͼ�:"+list1.size());
		
		Iterator<Integer> it = list.iterator();
		while(it.hasNext()) {
			int i = it.next();
			System.out.println(i);
		}
		
		
		
		System.out.println();
		
		for(int i : list) {
			System.out.println(i);
		}
		
		
	}
}













