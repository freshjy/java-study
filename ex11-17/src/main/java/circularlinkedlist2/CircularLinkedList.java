package circularlinkedlist2;

import java.util.Iterator;

public class CircularLinkedList <E> implements List<E>{	
	
	private int size;
	private Node<E> tail;
	
	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return new Iterator<E>() {

			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public E next() {
				// TODO Auto-generated method stub
				return null;
			}
		};
	}
	
	@Override
	public void add(E element) {
		// TODO Auto-generated method stub
		Node<E> newNode = new Node<E>(element);
		
		if(tail==null) {
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
		
	}
	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		Node<E> x = tail.next;
		
		for(int i=0; i<index; i++)
			x = x.next;
		
		return x.data;
	}
	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void removeAll() {
		// TODO Auto-generated method stub
		Node<E> x = tail.next;
		
		while(x!=tail) {
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
	
}
