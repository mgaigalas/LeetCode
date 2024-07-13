/**
 * ListNode represents a node in a custom linked list.
 * NOTE: this class was provided by LeetCode.
 *
 * @author Marius Gaigalas on 11/07/2024
 */
@SuppressWarnings("unused")
public final class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
