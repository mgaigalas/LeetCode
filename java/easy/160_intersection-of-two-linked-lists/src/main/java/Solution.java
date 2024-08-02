import java.util.HashSet;
import java.util.Set;

/**
 * Solution class contains solution for LeetCode problem:
 * #160. Intersection of Two Linked Lists.
 *
 * @author Marius Gaigalas on 01/08/2024
 */
public class Solution {
    /**
     * Given the heads of two singly linked-lists headA and headB, returns the node at which the two lists intersect.
     * If the two linked lists have no intersection at all, returns null.
     *
     * @param headA linked-list
     * @param headB linked-list
     * @return node at which the two lists intersect
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        final Set<ListNode> set = new HashSet<>();
        ListNode node = headA;
        while (node != null) {
            set.add(node);
            node = node.next;
        }

        node = headB;
        while (node != null) {
            if (set.contains(node)) {
                return node;
            }
            node = node.next;
        }
        return null;
    }
}