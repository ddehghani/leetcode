import javax.print.event.PrintJobListener;

public class Solution {
    public static void main(String[] args) {
        ListNode l1 = makeList(new int[] {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1}),
                l2 = makeList(new int[] {5,6,4});
        printList(addTwoNumbers(l1, l2));
    }

    public static ListNode makeList(int[] list) {
        if (list.length == 0) return null;
        ListNode head = new ListNode(list[0]);
        ListNode curr = head;
        for (int i = 1; i < list.length; i++) {
            ListNode temp = new ListNode(list[i]);
            curr.next = temp;
            curr = temp;
        }
        return head;
    }

    public static void printList(ListNode list) {
        System.out.print("[");
        while (list != null) {
            System.out.print(list.val + (list.next != null ? " ," : "]"));
            list = list.next;    
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null, curr = null;
        int carry = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            ListNode temp = new ListNode(sum % 10);
            if (curr == null) 
                result = temp;
            else 
                curr.next = temp;
            curr = temp;
            carry = sum / 10;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int sum = l1.val + carry;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            carry = sum / 10;
            l1 = l1.next;
        }
        while (l2 != null) {
            int sum = l2.val + carry;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            carry = sum / 10;
            l2 = l2.next;
        }
        if (carry != 0)
            curr.next = new ListNode(carry);
        return result;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
