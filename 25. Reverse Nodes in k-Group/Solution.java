import java.util.*;

public class Solution {
    public static void main(String[] args) {
        ListNode a1 = new ListNode(1, new ListNode(2 , new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(7)))))));
        ListNode result = new Solution().reverseKGroup(a1, 4);
        while (result != null) {
            System.out.print(result.val + (result.next == null ? "" : " -> "));
            result = result.next;
        }
        System.out.println();
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        if (k == 1) return head;
        ListNode originalHead = head, next = head.next;
        for (int i = 0; i < k - 1; i++) {
            head = head.next;
            if (head == null) return originalHead;
        }
        head = originalHead;
        for (int i = 0; i < k - 1; i++) {
            ListNode temp = next.next;
            next.next = head;
            head = next;
            next = temp;
        }
        originalHead.next = reverseKGroup(next, k);
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}