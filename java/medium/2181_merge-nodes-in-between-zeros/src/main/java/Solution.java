/**
 * Solution class contains solution for LeetCode problem:
 * #2181. Merge Nodes in Between Zeros.
 *
 * @author Marius Gaigalas on 09/07/2024
 */
public class Solution {
    /**
     * Merges linked list values between zero values (back and front).
     *
     * @param head head of linked list
     * @return head of merged linked list
     */
    public ListNode mergeNodes(ListNode head) {
        var curr = head;
        var next = curr.next;
        while (next.next != null) {
            if (next.val == 0) {
                curr = next;
                next = next.next;
                continue;
            }

            curr.val += next.val;
            curr.next = next.next;
            next = next.next;
        }
        curr.next = null;

        return head;
    }
}