/**
 * Solution class contains solution for LeetCode problem:
 * #2. Add Two Numbers.
 *
 * @author Marius Gaigalas on 10/07/2024
 */
public class Solution {
    /**
     * Given two non-empty linked lists representing two non-negative integers.
     * The digits are stored in reverse order, and each of their nodes contains a single digit.
     * Adds the two numbers and returns the sum as a linked list.
     *
     * @param l1 head of linked list
     * @param l2 head of linked list
     * @return head of result linked list
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        var node1 = l1;
        var node2 = l2;

        var dummy = new ListNode(0);
        var curr = dummy;
        var carry = false;
        while (node1 != null || node2 != null || carry) {
            var num1 = node1 != null ? node1.val : 0;
            var num2 = node2 != null ? node2.val : 0;
            var sum = num1 + num2;
            if (carry) {
                sum++;
                carry = false;
            }

            if (sum > 9) {
                carry = true;
            }

            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            node1 = node1 != null ? node1.next : null;
            node2 = node2 != null ? node2.next : null;
        }

        return dummy.next;
    }
}