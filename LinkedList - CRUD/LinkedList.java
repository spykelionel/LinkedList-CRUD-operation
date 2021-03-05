package features.com;

public class LinkedList {

	static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	Node head;

	public static LinkedList insert(LinkedList list, int data) {

		// Create new node with given data
		Node newnode = new Node(data);

		// if the list is empty, then make the new node as head
		if (list.head == null) {
			list.head = newnode;
		} else {
			// Traverse till the last node
			Node last = list.head;
			while (last.next != null) {
				last = last.next;
			}
			last.next = newnode;
		}
		newnode.next = null;
		return list;
	}

	public static LinkedList deleteIndex(LinkedList list, int index) {
		// check if list is empty
		if (size(list) == 0) {
			System.out.println("List is empty");
			return list;
		}
		Node currnode = list.head;
		Node prevnode = null;

		if (index == 0 && currnode != null) {
			list.head = currnode.next;
			System.out.println("Index found " + index + " deleted " + currnode.data);
		}

		int counter = 0;
		while (currnode != null) {

			if (counter == index) {
				prevnode.next = currnode.next;
				System.out.println("Index found " + index + " deleted " + currnode.data);
				printList(list);
				break;
			} else {
				prevnode = currnode;
				currnode = currnode.next;
				counter++;
			}

		}

		if (currnode == null) {
			System.out.println("Index " + index + " not found ");
		}

		return list;
	}

	public static LinkedList deleteKey(LinkedList list, int key) {
		// check if list is empty
		if (size(list) == 0) {
			System.out.println("List is empty");
			return list;
		}

		// Store the head node
		Node currentnode = list.head;
		Node prev = null;

		// if head node holds the key to be deleted
		if (currentnode != null && currentnode.data == key) {

//			 change the head
			list.head = currentnode.next;
			System.out.println("Key found " + key);
//			return list;
		}

		// if the key is somewhere other than head
		// search for the key to be deleted
		// keep track of the previous node
		// as it is needed to change the currentnode.next

		while (currentnode != null && currentnode.data != key) {

			// if current node does not hold key
			// continue to next node
			prev = currentnode;
			currentnode = currentnode.next;
		}

		// if the key was present, it shall
		// be at current node.
		// therefore the current node shall be deleted
		if (currentnode != null && prev != null) {
			// since the key is at current node
			// unlink current node from the linked list
			prev.next = currentnode.next;
			System.out.println("Key found " + key);
		}

		if (currentnode == null) {
			System.out.println("key " + key + " not found ");
		}

		return list;
	}

	public static int size(LinkedList list) {
		int size = 0;
		Node currentNode = list.head;

		while (currentNode != null) {
			size++;
			currentNode = currentNode.next;
		}
		return size;
	}

	public static LinkedList updateByKey(LinkedList list, int key, int newKey) {
		if (size(list) == 0) {
			System.out.println("List is empty");
			return list;
		}

		Node currentnode = list.head;
		// if the key to update is head.data
		if (currentnode.data == key) {
			currentnode.data = newKey;
			System.out.println("List has been updated by key.. ");
			printList(list);
			return list;
		}

		while (currentnode != null) {
			if (currentnode.data == key) {
				currentnode.data = newKey;
				System.out.println("List has been updated by key.. ");
				printList(list);
				break;
			}
			currentnode = currentnode.next;
		}

		if (currentnode == null) {
			System.out.println("Key not found.. ");
		}

		return list;
	}

	public static LinkedList updateByIndex(LinkedList list, int index, int newKey) {
		// check if list is empty
		if (size(list) == 0) {
			System.out.println("List is empty");
			return list;
		}
		
		Node currnode = list.head;
		
		if(index == 0 && currnode != null) {
			currnode.data = newKey;
			printList(list);
			return list;
		}
		int counter = 0;
		while (currnode != null) {

			if (counter == index) {
				currnode.data = newKey;
				System.out.println("List updated by index...");
				printList(list);
				break;
			} else {
				currnode = currnode.next;
				counter++;
			}
		}
		
		if(currnode == null) {
			System.out.println("Invalid index...");
		}
		
		return list;
	}

	public static void printList(LinkedList list) {

		if (size(list) == 0) {
			System.out.println("List is empty");
			return;
		}
		Node currentNode = list.head;

		System.out.print("Linkedlist: ");
		while (currentNode != null) {
			System.out.print(currentNode.data + " ");
			currentNode = currentNode.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList();

		list = insert(list, 1);
		list = insert(list, 2);
		list = insert(list, 3);
		list = insert(list, 4);
		list = insert(list, 5);
		printList(list);
		deleteIndex(list, 4);
		deleteKey(list, 1);
		updateByIndex(list, 2, 5425);
		updateByKey(list, 2, 15);
		System.out.println();

	}
}

