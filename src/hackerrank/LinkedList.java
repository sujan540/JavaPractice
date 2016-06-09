package hackerrank;

public class LinkedList {

	private Node head;
	private Node tail;

	public LinkedList() {
		tail = head;
	}

	public void add(Node node) {
		if (head == null) {
			head = node;
			tail = head;
		} else {
			tail.next = node;
			tail = node;
		}
	}

	public int size() {
		int count = 0;
		while (head.next != null) {
			count += count;
		}
		return count;
	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.add(new Node("1"));
		list.add(new Node("2"));
		list.add(new Node("3"));
		list.add(new Node("4"));
		int count = 0;

		Node current = list.head.next();

		while (current.next() != null) {
			count++;

			current = current.next();
		}

		System.out.println(list.head.data);
		System.out.println(list.tail.data);
		System.out.println(list.tail.next());
		System.out.println(count);

	}

	static class Node {
		private Node next;
		private String data;

		public Node(String data) {
			this.data = data;
		}

		public Node next() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		public String getData() {
			return data;
		}

		public void setData(String data) {
			this.data = data;
		}

		public String toString() {
			return this.data;
		}

	}

}
