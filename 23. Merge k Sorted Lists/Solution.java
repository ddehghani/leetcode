import java.util.*;

public class Solution {
    public static void main(String[] args) {
        // [1,4,5],[1,3,4],[2,6]
        ListNode a1 = new ListNode(1, new ListNode(4 , new ListNode(5)));
        ListNode a2 = new ListNode(1, new ListNode(3 , new ListNode(4)));
        ListNode a3 = new ListNode(2, new ListNode(6));
        ListNode result = new Solution().mergeKLists(new ListNode[] {a1, null, null, a2, a3});
        while (result != null) {
            System.out.print(result.val + (result.next == null ? "" : " -> "));
            result = result.next;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0)
            return null;
        if (lists.length == 1)
            return lists[0];
        // at list 2 lists
        ListNode[] mergedLists = new ListNode[(lists.length + 1)/2];
        for (int i = 0; i < lists.length; i += 2) {
            if (i + 1 >= lists.length || lists[i + 1] == null) {
                mergedLists[i/2] = lists[i];
                continue;
            }
            if (lists[i] == null) {
                mergedLists[i/2] = lists[i + 1];
                continue;
            }
            ListNode otherHead, mergedTail;
            if (lists[i].val < lists[i+1].val) {
                mergedLists[i/2] = lists[i];
                otherHead = lists[i+1];
            } else {
                mergedLists[i/2] = lists[i + 1];
                otherHead = lists[i];
            }
            mergedTail = mergedLists[i/2];
            while (otherHead != null) {
                if (mergedTail.next == null) {
                    mergedTail.next = otherHead;
                    break;
                }
                if (otherHead.val < mergedTail.next.val) {
                    ListNode temp = otherHead;
                    otherHead = mergedTail.next;
                    mergedTail.next = temp;
                } else {
                    mergedTail = mergedTail.next;
                }
            }
        }
        return mergeKLists(mergedLists);
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}