package main;

public class Queue<T> {
	
	private int total;
	private Node first;
	private Node last;
	
	private class Node {
		private T obj;
		private Node next;
	}
	
	public void enqueue(T newObj) {
		total++;
		Node newNode = new Node();
		newNode.obj = newObj;
		newNode.next = null;
		
		
		if(total == 1)
		{
			first = newNode;		
		}
		else
		{
			last.next = newNode;
		}
		last = newNode;
	}
	
	public T dequeue() {
		Node queued = first;
		first = first.next;
		return queued.obj;
	}
	
	public T peek() {
		return first.obj;
	}

}
