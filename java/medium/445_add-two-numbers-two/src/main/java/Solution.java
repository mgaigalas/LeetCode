import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Solution class contains solution for LeetCode problem:
 * #445. Add Two Numbers II.
 *
 * @author Marius Gaigalas on 11/07/2024
 */
public class Solution {
    /**
     * Adds two numbers and returns the sum as a linked list.
     *
     * @param l1 head of first linked list containing most significant number
     * @param l2 head of second linked list containing most significant number
     * @return head of linked list sum containing most significant number
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        final Deque<Integer> stack1 = new ArrayDeque<>();
        final Deque<Integer> stack2 = new ArrayDeque<>();
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                stack1.push(l1.val);
                l1 = l1.next;
            }

            if (l2 != null) {
                stack2.push(l2.val);
                l2 = l2.next;
            }
        }

        var head = new ListNode();
        var carry = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry > 0) {
            var sum = carry;
            if (!stack1.isEmpty()) {
                sum += stack1.pop();
            }

            if (!stack2.isEmpty()) {
                sum += stack2.pop();
            }
            carry = sum / 10;

            head.val = sum % 10;
            var prev = new ListNode();
            prev.next = head;
            head = prev;
        }

        return head.next;
    }
}