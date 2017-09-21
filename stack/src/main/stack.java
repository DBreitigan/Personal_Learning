package main;

/* @Author: Daniel Breitigan
 * Basic implementation of a stack. 
 */

public class stack <T>
{
    private int total;
    private node top;

    private class node {
        T obj;
        node next;
    }

    //Pushes a new object onto the stack
    public void push(T newObj) {
        total++;
        node current = new node();
        current.obj = newObj;
        current.next = top;
        top = current;
    }

    //Returns the top object from the stack and removes it from the stack
    public T pop() {
        node popped = top;
        top = top.next;
        return popped.obj;
    }

    public T peek() {
        return top.obj;
    }

}