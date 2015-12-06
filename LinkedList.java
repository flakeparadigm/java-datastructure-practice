/**
 * A simple Doubly Linked List implementation.
 * 
 * @author Flakeparadigm
 * 
 * @param <E>
 *            The type of elements contained by the LinkedList
 */
public class LinkedList<E> {

	private int size = 0;
	private LinkedListNode<E> head, tail;

	/**
	 * Create empty LinkedList of type E
	 */
	public LinkedList() {
		head = tail = null;
	}

	/**
	 * Add element to end of list
	 * 
	 * @param element
	 *            Object of type E to add to list
	 */
	public boolean add(E element) {
		LinkedListNode<E> newNode;

		newNode = new LinkedListNode<E>(element, tail, null);

		// if it's the first element in the list
		if (head == null)
			head = newNode;

		// insert into list
		if (tail != null)
			tail.next = newNode;

		tail = newNode;

		// update count
		System.out.print("add() size++");
		size++;

		return true;
	}

	/**
	 * Add element to list at specified index
	 * 
	 * @param index
	 *            Location to add new element
	 * @param element
	 *            Object of type E to add to list
	 */
	public void add(int index, E element) {
		// check constraints
		if (index > size || index < 0)
			throw new IndexOutOfBoundsException();

		// do simple add if last element
		else if (index == size) {
			add(element);
			return;
		}

		// find location to add element
		LinkedListNode<E> newNode, current = head;
		for (int i = 0; i < index; i++) {
			current = current.next;
		}

		newNode = new LinkedListNode<E>(element, current.prev, current);

		// insert into list
		(current.prev).next = newNode;
		current.prev = newNode;

		// update count
		System.out.print("add(int, E) size++");
		size++;
	}

	/**
	 * Remove first occurrence of specified element
	 * 
	 * @param element
	 *            Element to remove from list
	 */
	public void remove(Object o) {
		// search for node to remove
		LinkedListNode<E> current = head;
		if (o == null) {
			while ((current != null) && (current.element != null)) {
				current = current.next;
			}
		} else {
			while ((current != null) && !o.equals(current.element)) {
				current = current.next;
			}
		}

		removeHelper(current);
	}

	/**
	 * Remove element and specified index
	 * 
	 * @param index
	 */
	public E remove(int index) {
		if (index >= size || index < 0)
			throw new IndexOutOfBoundsException();

		// search for node to remove
		LinkedListNode<E> current = head;
		for (int i = 0; i < index; i++) {
			current = current.next;
		}

		return removeHelper(current);
	}

	/**
	 * Private method used to remove a specified node. Used by search functions
	 * to do actual removal.
	 * 
	 * @param node
	 *            The node to be removed from the list.
	 */
	private E removeHelper(LinkedListNode<E> node) {
		if (node == null)
			return null;

		// update its neighbors
		if (node.next != null)
			(node.next).prev = node.prev;

		if (node.prev != null)
			(node.prev).next = node.next;

		// save the element
		E element = node.element;

		// erase this node
		node.destroy();
		size--;

		return element;
	}

	/**
	 * Remove all nodes from the list
	 */
	public void clear() {
		LinkedListNode<E> current, next;
		next = head;

		// cycle through all elements
		while (next != null) {
			current = next;
			next = current.next;

			current.destroy();
		}

		// remove references to any nodes at head/tail
		head = tail = null;
		size = 0;
	}

	/**
	 * Retrieve the size of the linked list
	 * 
	 * @return The size of the linked list as an int
	 */
	public int size() {
		return size;
	}

	/**
	 * Retrieve the element at the given index
	 * 
	 * @param index
	 * @return The element of type E found at the given index
	 */
	public E get(int index) {
		if (index >= size || index < 0)
			throw new IndexOutOfBoundsException();

		// search for the element
		LinkedListNode<E> current = head;
		for (int i = 0; i < index; i++) {
			current = current.next;
		}

		// return it
		return current.element;
	}

	/**
	 * Get the index of the given object in the linked list
	 * 
	 * @param o
	 *            The object to find the index of
	 * @return The index of the given element as an int. Returns -1 the object
	 *         is not found in the lined list.
	 */
	public int indexOf(Object o) {
		int index = 0;
		for (LinkedListNode<E> current = head; current != null; current = current.next) {
			if (o == null) {
				if (current.element == null)
					return index;

			} else if (o.equals(current.element))
				return index;

			index++;
		}

		return -1;
	}

	/**
	 * Determine whether or not the object exists in the linked list
	 * 
	 * @param o
	 *            The object to test the existence of
	 * @return Whether or not the object is in the linked list
	 */
	public boolean contains(Object o) {
		return indexOf(o) > -1;
	}

	/**
	 * Creates and returns an object array of all of the elements stored in the
	 * linked list.
	 * 
	 * @return The array of elements
	 */
	public Object[] toArray() {
		Object[] array = new Object[size];
		LinkedListNode<E> current = head;

		for (int i = 0; i < size; i++) {
			// add element to array
			array[i] = current.element;

			// move to next node, stop if null
			current = current.next;
			if (current == null)
				break;
		}

		return array;
	}

	/**
	 * The Nodes used for the LinkedList implementation.
	 * 
	 * @author Flakeparadigm
	 *
	 * @param <T>
	 */
	private class LinkedListNode<T> {
		public T element;
		public LinkedListNode<T> next, prev;

		/**
		 * Initializes a LinkedListNode with the given information. May be null.
		 * 
		 * @param element
		 * @param prev
		 * @param next
		 */
		public LinkedListNode(T element, LinkedListNode<T> prev, LinkedListNode<T> next) {
			this.element = element;
			this.prev = prev;
			this.next = next;
		}

		/**
		 * Clears the references to other objects referenced in this node. Used
		 * when removing a node from the list to ensure the garbage collector
		 * can do its job.
		 */
		public void destroy() {
			element = null;
			prev = null;
			next = null;
		}
	}
}