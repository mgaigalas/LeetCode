/**
 * Solution class contains solution for LeetCode problem:
 * #141. Linked List Cycle.
 *
 * @author Marius Gaigalas on 31/07/2024
 */
public class Solution {
    /**
     * Returns true if there is a cycle in the linked list. Otherwise, returns false.
     *
     * @param head head of a linked list
     * @return flag indicating if there is a cycle in the linked list
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        var slow = head;
        var fast = head.next.next;
        while (fast != null && fast.next != null) {
            if (slow == fast) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
}