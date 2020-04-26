public class _206ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null)
            return null;

        ListNode currentHead = head;
        while (head.next != null){
            ListNode p = head.next;
            head.next = p.next;
            p.next = currentHead;
            currentHead = p;
        }
        return currentHead;
    }
}
