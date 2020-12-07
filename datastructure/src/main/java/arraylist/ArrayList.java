package arraylist;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayList<E> implements List<E> {

	private int size; // ��ü ������ ����
	private E[] data; //

	public ArrayList() {
		this.size = 0;
		resize();
	}

	private void resize() {
		if (size == 0) {
			data = (E[]) new Object[10];
		} else {
			E[] newData = (E[]) new Object[size + 10];
			System.arraycopy(data, 0, newData, 0, size);
			data = newData;
		}
	}

	@Override
	public void add(E element) {
		// TODO Auto-generated method stub
		if (data.length == size) {
			resize();
		}

		data[size++] = element;
	}

	@Override
	public void add(int index, E element) {
		/*
		 * checkBoundsInclusive(index); size++; for(int i=size; i>index; i--) {
		 * data[i-1] = data[i-2]; } data[index-1] = element;
		 */
		checkBoundsInclusive(index);
		if (size == data.length)
			resize();
		if (index != size)
			System.arraycopy(data, index, data, index + 1, size - index);
		data[index] = element;
		size++;
	}

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		checkBoundsExclusive(index);
		return data[index];
	}

	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		checkBoundsExclusive(index);
		data[index - 1] = null;
		for (int i = index - 1; i < size - 1; i++) {
			data[i] = data[i + 1];
		}
		size--;
		return null;
		/*
		 * checkBoundsExclusive(index); E r = data[index]; if(index != --size)
		 * System.arraycopy(data, index+1, data, index, size - index);
		 * 
		 * return r;
		 */
	}

	@Override
	public void removeAll() {
		// TODO Auto-generated method stub
		size = 0;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	private void checkBoundsExclusive(int index) {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException("Index:" + index + " Size:" + size);
	}

	private void checkBoundsInclusive(int index) {
		if (index < 0 || index > size)
			throw new IndexOutOfBoundsException("Index:" + index + " Size:" + size);
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return new Iterator<E>() {
			//// private int nextIndex = 0;
			private int pos = 0;
			private int size = size();

			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return pos < size;
				//// return nextIndex < size;
			}

			@Override
			public E next() {
				// TODO Auto-generated method stub
				if (pos == size)
					throw new NoSuchElementException();
				return data[pos++];
				//// return data[nextIndex++];

			}

		};
	}

}
