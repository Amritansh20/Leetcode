/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */

class Solution {
public:
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        ListNode* cnt =head, *final_delete=head;

        for(int i=0;i<n;++i)
        cnt = cnt->next;

        if(cnt==NULL)
        return head->next;

        while(cnt->next!=NULL){
            cnt=cnt->next;
            final_delete = final_delete->next;
        }

        final_delete->next = final_delete->next->next;
        return head;
    }
};