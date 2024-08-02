/**
 * Solution class contains solution for LeetCode problem:
 * #1474. Delete N Nodes After M Nodes of a Linked List.
 *
 * @author Marius Gaigalas on 02/08/2024
 */
public class Solution {
    /**
     * Traverses the linked list and removes some nodes.
     *
     * @param head head of a linked list
     * @param m    consecutive nodes to keep
     * @param n    consecutive nodes to remove
     * @return head of a new linked list
     */
    public ListNode deleteNodes(ListNode head, int m, int n) {
        var node = head;
        var next = node;
        while (node != null) {
            var i = m;
            var j = n;
            while (i > 1 && node != null && next != null) {
                node = node.next;
                next = next.next;
                i--;
            }

            while (j > -1 && next != null) {
                next = next.next;
                j--;
            }

            if (node == null) {
                break;
            }
            node.next = next;
            node = node.next;
        }
        return head;
    }
}