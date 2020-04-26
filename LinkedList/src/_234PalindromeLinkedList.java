public class _234PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        ListNode firstHalfEnd = endOfTheFirstHalf(head);
        ListNode startOfSecondHalf = reverseList(firstHalfEnd.next);
        ListNode p1 = head, p2 = startOfSecondHalf;
        boolean result = true;
        while (result && p2 != null){
            if (p1.val != p2.val)
                return false;
            p1 = p1.next;
            p2 = p2.next;
        }
        firstHalfEnd.next = reverseList(startOfSecondHalf);
        return true;
    }

    private ListNode reverseList(ListNode head){
        if (head == null) return null;
        ListNode currentHead = head;
        while (head.next != null){
            ListNode p = head.next;
            head.next = p.next;
            p.next = currentHead;
            currentHead = p;
        }
        return currentHead;
    }

    private ListNode endOfTheFirstHalf(ListNode head){
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
