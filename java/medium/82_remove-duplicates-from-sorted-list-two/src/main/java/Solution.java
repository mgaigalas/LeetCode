/**
 * Solution class contains solution for LeetCode problem:
 * #82. Remove Duplicates from Sorted List II.
 *
 * @author Marius Gaigalas on 06/08/2024
 */
public class Solution {
    /**
     * Given the head of a sorted linked list, deletes all nodes that have duplicate numbers,
     * leaving only distinct numbers from the original list.
     * Returns the linked list sorted as well.
     *
     * @param head head of a linked list
     * @return linked list
     */
    public ListNode deleteDuplicates(ListNode head) {
        final var dummy = new ListNode(0, head);
        var tail = dummy;
        var node = head;
        while (node != null) {
            if (node.next != null && node.val == node.next.val) {
                while (node.next != null && node.val == node.next.val) {
                    node = node.next;
                }
                tail.next = node.next;
            } else {
                tail = tail.next;
            }
            node = node.next;
        }
        return dummy.next;
    }
}