package doublelinkedlist;

import java.util.Iterator;
import java.util.NoSuchElementException;

import arraylist.List;


public class DoublyLinkedList<E> implements List<E> {
	
	private int size;
	private Node<E> head;
	private Node<E> tail;
	
	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return new Iterator<E>() {
			
			private Node<E> pos = head;
			
			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub				
				return (pos != null);
			}

			@Override
			public E next() {
				// TODO Auto-generated method stub
				if(pos == null)
					throw new NoSuchElementException();
				E data = pos.data;
				pos = pos.next;
				return data;
			}
			
		};
	}

	@Override
	public void add(E element) {
		// TODO Auto-generated method stub
		final Node<E> newNode = new Node<E>(element);
		
		if(head == null) {
			head = tail = newNode;
		}else {
			tail.next = newNode;
			newNode.prev = tail;
			
			tail = newNode;
		}
		size++;
	}

	@Override
	public void add(int index, E element) {
		// TODO Auto-generated method stub
		/*Node<E> newNode = new Node<E>(element);
		Node<E> x = head;
		
		if(index == size) {
			add(element);
		}
		
		for(int i=0; i<index-1; i++) {
			x = x.next;
		}
		if(index == 0) {
			head = newNode;
			newNode.next = x;
			head.prev = newNode;
			newNode.prev = null;
		}else {
			newNode.next = x.next;
			x.next = newNode;
			newNode.prev = tail;
			tail = newNode;
		}
		size++;
		*/
		checkBoundsInclusive(index);
		Node<E> newNode = new Node<E>(element);
		Node<E> x = head;
		
		if(index == size) {
			add(element);
			return;
		}
		
		for(int i=0; i<index; i++)
			x = x.next;
		if(index ==0) {
			newNode.prev = x.prev;
			newNode.next = x;
			head = newNode;
		}else {
			x.prev.next = newNode;
			newNode.prev = x.prev;
			newNode.next = x;
			x.prev = newNode;
		}
		size++;
	}
	
	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		if(size <= index)
			checkBoundsExclusive(index);
		Node<E> x = head;
		for(int i=0; i<index; i++)
			x = x.next;
		return x.data;
	}
	
	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		checkBoundsExclusive(index);
		
		/*E element;
		if(index == 0) {
			element = head.data;
			head = head.next;
		}else {
			Node<E> x = head;
			for(int i=0; i<index-1; i++)
				x = x.next;
			
			element = x.next.data;
			x.next = x.next.next;
			x.prev = x.next.prev;
		}
		size--;
		return element;
		*/
		Node<E> x = head;
		for(int i=0; i < index; i++)
			x = x.next;
		
		if(index==0) {
			if(size == 1) {
				head = null;
				tail = null;
			}else {
				x.next.prev = x.prev;
				head = x.next;
			}
		}else if(x==tail) {
			x.prev.next = x.next;
			tail = x.prev;
		}else {
			x.prev.next = x.next;
			x.next.prev = x.prev;
		}
		size--;
		return x.data;
	}
	

	@Override
	public void removeAll() {
		// TODO Auto-generated method stub
		Node<E> x = head;
		
		while(x != null) {
			Node<E> next = x.next;
			x.next = null;
			x.prev = null;
			x = next;
		}
		
		head = null;
		tail = null;
		head = null;
		size = 0;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}
	
	private static class Node<E>{
		private Node<E> next;
		private Node<E> prev;
		private E data;
		
		private Node(E element) {
			this.data = element;
			this.next = null;
			this.prev = null;
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
