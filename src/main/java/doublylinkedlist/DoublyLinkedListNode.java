package doublylinkedlist;

class DoublyLinkedListNode<ValueType> {
	private DoublyLinkedListNode<ValueType> prev;
	private DoublyLinkedListNode<ValueType> next;
	public ValueType value;

	public DoublyLinkedListNode(ValueType value) {
		this.value = value;
	}

	public void setPrev(DoublyLinkedListNode<ValueType> prev) {
		this.prev = prev;
	}

	public void setNext(DoublyLinkedListNode<ValueType> next) {
		this.next = next;
	}

	public DoublyLinkedListNode<ValueType> getPrev() {
		return this.prev;
	}

	public DoublyLinkedListNode<ValueType> getNext() {
		return this.next;
	}
}
