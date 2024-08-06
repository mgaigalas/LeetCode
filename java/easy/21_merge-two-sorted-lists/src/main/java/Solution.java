/**
 * Solution class contains solution for LeetCode problem:
 * #21. Merge Two Sorted Lists.
 *
 * @author Marius Gaigalas on 18/07/2024
 */
public class Solution {
    /**
     * Returns the head of the merged linked list.
     *
     * @param list1 head of first sorted linked list
     * @param list2 head of second sorted linked list
     * @return head of the merged linked list
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        final var dummy = new ListNode();
        var node = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                node.next = list2;
                list2 = list2.next;
            } else {
                node.next = list1;
                list1 = list1.next;
            }
            node = node.next;
        }
        node.next = list1 != null ? list1 : list2;
        return dummy.next;
    }
}