/**
 * Solution class contains solution for LeetCode problem:
 * #3062. Winner of the Linked List Game.
 *
 * @author Marius Gaigalas on 06/08/2024
 */
public class Solution {
    /**
     * Returns the name of the team with the higher points, if the points are equal, return "Tie".
     *
     * @param head head of a linked list
     * @return name of a winner team, or "Tie"
     */
    public String gameResult(ListNode head) {
        int odd = 0;
        int even = 0;
        var oddNode = head.next;
        var evenNode = head;
        while (oddNode != null && evenNode != null) {
            if (oddNode.val > evenNode.val) {
                odd++;
            } else {
                even++;
            }

            if (oddNode.next != null) {
                oddNode = oddNode.next.next;
            }
            if (evenNode.next != null) {
                evenNode = evenNode.next.next;
            }
        }

        if (odd == even) {
            return "Tie";
        }
        return odd > even ? "Odd" : "Even";
    }
}