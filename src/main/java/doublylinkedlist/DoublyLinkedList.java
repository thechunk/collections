package doublylinkedlist;

import java.util.Iterator;

public class DoublyLinkedList<Type> {
	private DoublyLinkedListNode<Type> first;
	private DoublyLinkedListNode<Type> last;

	public DoublyLinkedList() {
		this.first = null;
		this.last = null;
	}

	public void add(Type val) {
		DoublyLinkedListNode<Type> node = new DoublyLinkedListNode<Type>(val);

		// Case: empty list
		if (first == null && last == null) {
			this.first = node;
			this.last = node;
		}

		// Case: populated list
		if (last != null) {
			this.last.setNext(node);
			node.setPrev(this.last);
			this.last = node;
		}
	}

	public void add(Type val, int idx) {
		if (idx == 0) {
			this.addFirst(val);
			return;
		}

		DoublyLinkedListNode<Type> newNode = new DoublyLinkedListNode<Type>(val);

		int i = 0;
		DoublyLinkedListNode<Type> current = null;
		Iterator<DoublyLinkedListNode<Type>> it = this.iterator();
		while (it.hasNext()) {
			current = it.next();
			if (idx == i) break;
			i++;
		}

		DoublyLinkedListNode<Type> prev = current.getPrev();
		newNode.setPrev(prev);
		newNode.setNext(current);
		prev.setNext(newNode);
		current.setPrev(newNode);
	}

	public void addFirst(Type val) {
		DoublyLinkedListNode<Type> newNode = new DoublyLinkedListNode<Type>(val);

		this.first.setPrev(newNode);
		newNode.setNext(this.first);
		this.first = newNode;
	}

	public void printDescription() {
		String desc = "";
		Iterator<DoublyLinkedListNode<Type>> it = this.iterator();
		while (it.hasNext()) {
			desc += it.next().value + (it.hasNext() ? ", " : "");
		}
		System.out.println("[" + desc + "]");
	}

	public Iterator<DoublyLinkedListNode<Type>> iterator() {
		Iterator<DoublyLinkedListNode<Type>> it = new Iterator<DoublyLinkedListNode<Type>>() {
			private DoublyLinkedListNode<Type> current = null;

			public boolean hasNext() {
				if (first == null && last == null) {
					return false;
				}
				return current == null || current.getNext() != null;
			}

			public DoublyLinkedListNode<Type> next() {
				if (current == null) {
					current = first;
				} else {
					current = current.getNext();
				}
				return current;
			}

			public void remove() {
			}
		};
		return it;
	}
}
