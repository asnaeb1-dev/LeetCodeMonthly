package May2022;

import java.util.LinkedList;
import java.util.Queue;

/**Question -
 * Implement a last-in-first-out (LIFO) stack using only two queues. The implemented stack should support all the functions of a normal stack (push, top, pop, and empty).
 *
 * Implement the MyStack class:
 *
 * void push(int x) Pushes element x to the top of the stack.
 * int pop() Removes the element on the top of the stack and returns it.
 * int top() Returns the element on the top of the stack.
 * boolean empty() Returns true if the stack is empty, false otherwise.
 * Notes:
 *
 * You must use only standard operations of a queue, which means that only push to back, peek/pop from front, size and is empty operations are valid.
 * Depending on your language, the queue may not be supported natively. You may simulate a queue using a list or deque (double-ended queue) as long as you use only a queue's standard operations.
 */

//Time - Push - O(1); pop - O(N)
public class May5_ImplementStackUsingQueues {
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.pop();
    }
}
 class MyStack {

    Queue<Integer> q1;
    Queue<Integer> q2;

    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(int x) {
        q1.add(x);
    }

    public int pop() {
        if(q1.isEmpty()) return -1;
        while(q1.size() > 1){
            q2.add(q1.remove());
        }
        int removed = q1.remove();
        while(!q2.isEmpty()){
            q1.add(q2.remove());
        }
        return removed;
    }

    public int top() {
        if(q1.isEmpty()) return -1;
        while(q1.size() > 1){
            q2.add(q1.remove());
        }
        int top = q1.remove();
        while(!q2.isEmpty()){
            q1.add(q2.remove());
        }
        q1.add(top);
        return top;
    }

    public boolean empty() {
        return q1.isEmpty();
    }
}
