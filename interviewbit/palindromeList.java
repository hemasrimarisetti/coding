 Example Input
 Input 1: 

A = [1, 2, 2, 1]
Input 2:

A = [1, 3, 2]


Example Output
 Output 1: 

 1 
 Output 2: 

 0 


/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public static ListNode reverse(ListNode head){
        if(head==null||head.next==null){
            return head;
        }
        ListNode prev=null;
        while(head!=null){
            ListNode temp=head.next;
            head.next=prev;
            prev=head;
            head=temp;
            }
            return prev;
    }
    public int lPalin(ListNode A) {
        ListNode fast=A;
        ListNode slow=A;
        ListNode temp=A;
        if(A==null||A.next==null){
            return 1;
        }
        while(fast.next!=null&&fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode sh=reverse(slow.next);
        slow.next=null;
        while(A!=null&&sh!=null){
            if(A.val!=sh.val){
                return 0;
            }
            A=A.next;
            sh=sh.next;
        }
        return 1;
        
    }
}
