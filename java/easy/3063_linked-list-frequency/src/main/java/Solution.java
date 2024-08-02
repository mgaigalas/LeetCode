import java.util.HashMap;
import java.util.Map;

/**
 * Solution class contains solution for LeetCode problem:
 * #3063. Linked List Frequency.
 *
 * @author Marius Gaigalas on 02/08/2024
 */
public class Solution {
    /**
     * Given the head of a linked list containing k distinct elements, returns the head to a linked list of length k
     * containing the frequency of each distinct element in the given linked list in any order.
     *
     * @param head head of a linked list
     * @return head to a linked list of length k containing the frequency of each distinct element
     */
    public ListNode frequenciesOfElements(ListNode head) {
        final Map<Integer, Integer> counter = new HashMap<>();
        while (head != null) {
            counter.put(head.val, counter.getOrDefault(head.val, 0) + 1);
            head = head.next;
        }

        final var dummy = new ListNode();
        var node = dummy;
        for (var entry : counter.entrySet()) {
            node.next = new ListNode(entry.getValue());
            node = node.next;
        }
        return dummy.next;
    }
}