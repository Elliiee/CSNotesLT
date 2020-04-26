public class _203RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode prev = sentinel, cur = head;
        while (cur != null){
            if (cur.val == val){
                prev.next = cur.next;
            }
            else {
                prev = cur;
            }
            cur = cur.next;
        }
        return sentinel.next;
    }
}
