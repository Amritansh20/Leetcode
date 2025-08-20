import java.util.*;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

/*
    Approach 1
    T.C = O(nlogn)
    S.C = O(n) for heap storage
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int i=0;i<lists.length;i++){
            ListNode list = lists[i];

            while(list!=null){
                minHeap.offer(list.val);
                list = list.next;
            }
        }

        ListNode head = null;
        ListNode end = null;
        while(!minHeap.isEmpty()){
            if(head==null){
                head = new ListNode(minHeap.poll());
                end=head;
            }else{
                end.next = new ListNode(minHeap.poll());
                end = end.next;
            }
        }
        return head;
    }
}


/*
    Approach 2
    Time = O(kN)
    k = number of listnodes
    N = sum of any two lists at given point
 */
class Solutions {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2){
        if(list1==null)
        return list2;

        if(list2==null)
        return list1;
        
        ListNode head = null;

        if(list1.val<=list2.val){
            head = list1;
            list1=list1.next;
        }else{
            head =list2;
            list2=list2.next;
        }

        ListNode curr =head;
        
        while(list1!=null && list2!=null){
            if(list1.val<=list2.val){
                curr.next=list1;
                curr =list1;
                list1=list1.next;
            }else{
                curr.next=list2;
                curr =list2;
                list2=list2.next;  
            }  
        }

        if(list1!=null)
        curr.next=list1;
        
        if(list2!=null)
        curr.next=list2;

        return head;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0)
        return null;

        ListNode head = lists[0];

        for(int i=1;i<lists.length;i++){
            head = mergeTwoLists(lists[i],head);
        }   
        return head;
    }
}