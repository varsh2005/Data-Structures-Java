class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode ptr1 = head;
        ListNode ptr2 = head;
        while(ptr1!=null && ptr1.next!=null){
            ptr1 = ptr1.next.next;
            ptr2 = ptr2.next;
        }
        return ptr2;
    }
}
