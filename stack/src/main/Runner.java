package main;

public class Runner {
	public static void main(String arv[]) {
		stack<Integer> stack = new stack<Integer>(); 
		stack.push(10);
		stack.push(20);
		System.out.println("Stack: ");
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		
		Queue<Integer> queue = new Queue<Integer>();
		queue.enqueue(10);
		queue.enqueue(20);
		System.out.println("Queue: ");
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
	}
}
