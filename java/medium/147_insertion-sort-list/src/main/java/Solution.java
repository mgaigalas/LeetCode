/**
 * Solution class contains solution for LeetCode problem:
 * #147. Insertion Sort List.
 *
 * <p>
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 * </p>
 *
 * @author Marius Gaigalas on 30/05/2024
 */
public class Solution {
    /**
     * Given the head of a singly linked list, sorts the list using insertion sort, and returns the sorted list's head.
     *
     * @param head linked list head node.
     * @return sorted linked list head node.
     */
    public ListNode insertionSortList(ListNode head) {
        var dummy = new ListNode();
        var curr = head;
        while (curr != null) {
            // point to initial node
            var prev = dummy;

            // search for next prev node, where prev.next.val > curr.val
            // this is an insertion point
            while (prev.next != null && prev.next.val <= curr.val) {
                prev = prev.next;
            }

            // at this point we need to repoint so that prev.next.val < curr.val
            var next = curr.next;
            curr.next = prev.next;
            prev.next = curr;
            curr = next;
        }
        return dummy.next;
    }
}