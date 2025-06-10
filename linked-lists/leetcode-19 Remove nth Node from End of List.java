/* Given the head of a linked list, remove the nth node from the end of the list 
and return its head.
Example 1:
Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]

Example 2:
Input: head = [1], n = 1
Output: []

Example 3:
Input: head = [1,2], n = 1
Output: [1]

*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head)
    {
        ListNode prev = null ;
        ListNode curr = head ;
        while(curr!=null)
        {
            ListNode temp_next = curr.next ;
            curr.next = prev ;
            prev = curr ;
            curr = temp_next ;
        }
        return prev ;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {

        // REVERSE -> DELETE -> REVERSE                 tc : O(n)       sc : O(1)
        // ListNode temp_list = reverseList(head) ;
        // ListNode temp = temp_list ;
        // if(n==1) 
        //     temp_list = temp_list.next ;
        // else 
        // {
        //     for(int i=1;i<n-1 && temp!=null ;i++)
        //         temp = temp.next ;
        //     if(temp!=null && temp.next!=null)
        //         temp.next = temp.next.next ;
        // }
        // return reverseList(temp_list) ;


        // TWO POINTER APPROACH                         tc : O(n)       sc : O(1)
        ListNode dummy = new ListNode(0,head) ;
        ListNode ahead_pointer = dummy ;
        ListNode behind_pointer = dummy ;
        //ahead_pointer will be n+1 nodes ahead of behind_pointer 
        for(int i=1; i<= n+1 ;i++)
            ahead_pointer = ahead_pointer.next ;
        while(ahead_pointer != null )
        {
            ahead_pointer = ahead_pointer.next ;
            behind_pointer = behind_pointer.next ;
        }
        //now behind_pointer is right before the node to delete
        behind_pointer.next = behind_pointer.next.next ;
        return dummy.next ;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

