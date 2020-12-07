package circularlinkedlist;

import java.util.Iterator;
import java.util.NoSuchElementException;



public class CircularLinkedList <E> implements List<E>{
	
	private int size;
	private Node<E> tail;
	
	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		
		return new Iterator<E>() {
			
			private Node<E> val = tail;
			//private int check = 0;
			private Node<E> position = tail == null ? null : tail.next;
			private boolean isFrist = true;
			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				/*if(check==0) {
					if(val==null)	return false;
					return true;
				}
				else 
					return (val.next==tail.data);
					*/
				if(position == null)
					return false;
				if(isFrist) {
					isFrist = false;
					return true;
				}
				return (position != tail.next);
				
			}

			@Override
			public E next() {
				// TODO Auto-generated method stub
				/*if(val.next == tail) {
					check++;
				}
				E data = val.next.data;
				val = val.next;
				return data;*/
				E data = position.data;
				position = position.next;
				return data;
			}
		};
	}

	@Override
	public void add(E element) {
		// TODO Auto-generated method stub
		//                       newNode
		//       1                   3
		//    head tail    ---->     |
		Node<E> newNode = new Node<>(element);
		if(tail == null) {
			tail = newNode.next = newNode;
		}else {
			newNode.next = tail.next;
			tail.next = newNode;
			tail = tail.next;
		}
		size++;
	}

	@Override
	public void add(int index, E element) {
		// TODO Auto-generated method stub
		/*Node<E> newNode = new Node<>(element);
		int i=0;
		while(i == index) {
			if(i != index)
				tail = tail.next;
			else {
				newNode.next = tail.next;
				tail.next = newNode;
				tail = tail.next;
			}
		}*/
		checkBoundsInclusive(index);
		if(index == size) {
			add(element);
			return;
		}
		
		Node<E> newNode = new Node<E>(element);
		Node<E> x;		
		if(index == 0) {
			x = tail;
		}else {
			x = tail.next;
			for(int i=0; i < index-1; i++) {
				x = x.next;
			}
			newNode.next = x.next;
			x.next = newNode;
		}
		size++;
	}

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		checkBoundsExclusive(index);
		Node<E>x = tail.next;
		
		for(int i=0; i<index; i++) {
			x = x.next;
		}
		return x.data;
	}

	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		/*Node<E> element;
		Node<E> preNode;
		int i=0;
		while(i == index) {
			if(i != index) {
				if(i == index-1)	preNode = tail;
				tail = tail.next;
			}else {
				element = tail;
				tail = tail.next;
				element.next = tail.next;
			}
		}*/
		
		checkBoundsExclusive(index);
		Node<E> x;
		if(index == 0)	
			x = tail;
		else	
			x = tail.next;
		// 1       2      3       4 
		//                        
		//        
		for(int i=0; i<index-1; i++)
			x = x.next;
		if(x.next == tail)	
			tail = x;
		
		Node<E> deleted;
		deleted = x.next;
		x.next = deleted.next;
		size--;
		
		return deleted.data;
	}

	@Override
	public void removeAll() {
		// TODO Auto-generated method stub
		Node<E>x = tail.next;
		
		while(x != tail) {
			Node<E> next = x.next;
			x.next = null;
			x = next;
		}
		
		tail.next = null;
		tail = null;
		size = 0;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}
	private class Node<E> {
		private Node<E> next;
		private E data;
		
		private Node(E element) {
			this.data = element;
			this.next = null;
		}
		
		private Node(E element, Node<E> next) {
			this.data = element;
			this.next = next;
		}
	}
	
	private void checkBoundsExclusive(int index) {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException("Index:" + index + " Size:" + size);
	}

	private void checkBoundsInclusive(int index) {
		if (index < 0 || index > size)
			throw new IndexOutOfBoundsException("Index:" + index + " Size:" + size);
	}	
}


















