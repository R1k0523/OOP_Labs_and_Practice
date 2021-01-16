package rtu.klokov.labs.lab16;

public class ListNode {
    ListNode next;
    MenuItem value;

    public ListNode(ListNode next, MenuItem value) {
        this.next = next;
        this.value = value;
    }

    public ListNode() {
        next = null;
        value = null;
    }
}
