
//   Definition for singly-linked list.
class ListNode {
     int val;
    ListNode next;
    ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode count = head;
        ListNode final_delete = head;

        for(int i=0;i<n;i++)
        count=count.next;

        if(count==null)
        return head.next;

        while(count.next!=null){
            count = count.next;
            final_delete = final_delete.next;
        }
        final_delete.next = final_delete.next.next;
        return head;
    }
}