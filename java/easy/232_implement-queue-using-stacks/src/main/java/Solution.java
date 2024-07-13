import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Solution class contains solution for LeetCode problem:
 * #232. Implement Queue using Stacks.
 *
 * @author Marius Gaigalas on 12/07/2024
 */
public class Solution {
    private final Deque<Integer> d1;
    private final Deque<Integer> d2;

    /**
     * Constructor.
     */
    public Solution() {
        d1 = new ArrayDeque<>();
        d2 = new ArrayDeque<>();
    }

    /**
     * Pushes  element on a queue.
     *
     * @param x int element
     */
    public void push(int x) {
        if (d1.isEmpty() && d2.isEmpty()) {
            d1.push(x);
            return;
        }

        var emptyDeque = d1;
        var nonEmptyDeque = d2;
        if (!emptyDeque.isEmpty()) {
            nonEmptyDeque = d1;
            emptyDeque = d2;
        }

        while (!nonEmptyDeque.isEmpty()) {
            emptyDeque.push(nonEmptyDeque.pop());
        }
        nonEmptyDeque.push(x);
        while (!emptyDeque.isEmpty()) {
            nonEmptyDeque.push(emptyDeque.pop());
        }
    }

    /**
     * Pops element from a queue.
     *
     * @return int element
     */
    public int pop() {
        var d = d1;
        if (d.isEmpty()) {
            d = d2;
        }
        return d.isEmpty() ? 0 : d.pop();
    }

    /**
     * Peeks for element in a queue.
     *
     * @return int element
     */
    public int peek() {
        var d = d1;
        if (d.isEmpty()) {
            d = d2;
        }
        return d.isEmpty() ? 0 : d.peek();
    }

    /**
     * Checks if queue is empty.
     *
     * @return empty flag
     */
    public boolean empty() {
        return d1.isEmpty() && d2.isEmpty();
    }
}