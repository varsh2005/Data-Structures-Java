class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode ptr1 = head, ptr2 = head;
        while(ptr1!=null && ptr1.next!=null){
            ptr1 = ptr1.next.next;
            ptr2 = ptr2.next;
        }
        ListNode prev = null;
        while(ptr2!=null){
            ListNode temp = ptr2.next;
            ptr2.next = prev;
            prev = ptr2;
            ptr2 = temp;
        }

        ListNode left = head, right = prev;
        while(right!=null){
            if(left.val!=right.val) 
            return false;
            left = left.next;
            right = right.next;
        }
        return true;
    }
}
