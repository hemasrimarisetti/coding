A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗
B:     b1 → b2 → b3
for A len=5;
for B len=6;
5+6==11
6+5==11

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
	public ListNode getIntersectionNode(ListNode a, ListNode b) {
        if(a==null||b==null)return null;
        ListNode headA=a;
        ListNode headB=b;
        while(headA!=headB){
            headA=(headA==null)?b:headA.next;//if A reaches the null then it should point to head of B
            headB=(headB==null)?a:headB.next;
        }
        return headA;
	}
}
