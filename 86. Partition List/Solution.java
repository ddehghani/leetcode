import java.util.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().partition(new ListNode<Integer>(new Integer[]{1,4,3,2,5,2}), 3));
   
    }

    public ListNode<Integer> partition(ListNode<Integer> head, int x) {
        ListNode<Integer> lt = new ListNode<Integer>(), geq = new ListNode<Integer>(), currlt = lt, currgeq = geq;

        while (head != null) {
            if (head.getVal() < x) {
                currlt.setNext(new ListNode<Integer>(head.getVal()));
                currlt = currlt.getNext();
            } else {
                currgeq.setNext(new ListNode<Integer>(head.getVal()));
                currgeq = currgeq.getNext();
            }
            head = head.getNext();
        }
        currlt.setNext(geq.getNext());
        return lt.getNext();
    }
}


class ListNode <T> {
    private T val;
    private ListNode<T> next;

    public ListNode() {}
    public ListNode(T val) { this.val = val; }
    public ListNode(T val, ListNode<T> next) { this.val = val; this.next = next; }
    public ListNode(T[] arr) {
        if (arr.length != 0) {
            this.val = arr[0];
            ListNode<T> curr = this;
            for (int i = 1; i < arr.length; i++) {
                curr.next = new ListNode<T>(arr[i]);
                curr = curr.next;
            }
        }
    }

    public ListNode<T> getNext() { return this.next;}
    public void setNext(ListNode<T> node) {this.next = node;}

    public T getVal() { return this.val;}
    public void setVal(T val) { this.val = val;}

    public String toString() {
        ListNode<T> head = this;
        StringBuilder result = new StringBuilder();
        while (head != null) {
            result.append(head.val + (head.next != null ? " -> " : ""));
            head = head.next;
        }
        return result.toString();
    }
}