/**
 * Solution class contains solution for LeetCode problem:
 * #369. Plus One Linked List.
 *
 * @author Marius Gaigalas on 11/07/2024
 */
public class Solution {
    /**
     * Given a non-negative integer represented as a linked list of digits, plus one to the integer.
     *
     * @param head head of a linked list with most significant digit as head
     * @return head of plus one linked list
     */
    public ListNode plusOne(ListNode head) {
        var dummy = new ListNode(0, head);
        var sb = new StringBuilder();

        var node = dummy.next;
        while (node != null) {
            sb.append(node.val);
            node = node.next;
        }

        var n = sb.length() - 1;
        var carry = false;
        ListNode overflowNode = null;
        while (n >= 0 || carry) {
            var digit = toDigitAtIndex(sb, n);
            if (n == sb.length() - 1) {
                digit++;
            }

            if (carry) {
                digit++;
                carry = false;
            }

            if (digit > 9) {
                carry = true;
            }

            if (n >= 0) {
                char c = (char)((digit % 10) + '0');
                sb.setCharAt(n, c);
            } else {
                overflowNode = new ListNode(digit % 10, dummy.next);
                dummy.next = overflowNode;
            }
            n--;
        }

        if (overflowNode == null) {
            node = dummy.next;
        } else {
            node = dummy.next.next;
        }

        n = 0;
        while (node != null) {
            node.val = sb.charAt(n) - '0';
            node = node.next;
            n++;
        }

        return dummy.next;
    }

    /**
     * Utility method for extracting single digit from string builder at provided index.
     *
     * @param sb string builder
     * @param idx index (can be negative value)
     * @return digit as int
     */
    private static int toDigitAtIndex(StringBuilder sb, int idx) {
        if (idx < 0) {
            return 0;
        }
        return sb.charAt(idx) - '0';
    }
}