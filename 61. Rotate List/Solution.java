public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.printList(s.rotateRight(s.makeListFromArray(new Integer[] {0, 1, 2}), 3));
    }

    public ListNode<Integer> rotateRight(ListNode<Integer> head, int k) {
        if (head == null) return null;
        int length = 0;
        ListNode<Integer> temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        k %= length;
        if (k == 0) return head;
        ListNode<Integer> resultTail = head;
        for (int i = 0; i < length - k - 1; i++) resultTail = resultTail.next;
        ListNode<Integer> resultHead = resultTail.next;
        resultTail.next = null;
        ListNode<Integer> currTail = resultHead;
        while (currTail.next != null) currTail = currTail.next;
        currTail.next = head;
        return resultHead;
    }

    private <T> void printList(ListNode<T> head) {
        while (head != null) {
            System.out.print(head.val + (head.next != null ? " -> " : ""));
            head = head.next;
        }
        System.out.println();
    }

    private <T> ListNode<T> makeListFromArray(T[] arr) {
        ListNode<T> head = new ListNode<>(arr[0]);
        ListNode<T> curr = head;
        for (int i = 1; i < arr.length; i++) {
            curr.next = new ListNode<T>(arr[i]);
            curr = curr.next;
        }
        return head;
    }
}

class ListNode <T> {
    T val;
    ListNode <T> next;
    ListNode() {}
    ListNode(T val) { this.val = val; }
    ListNode(T val, ListNode<T> next) { this.val = val; this.next = next; }
}