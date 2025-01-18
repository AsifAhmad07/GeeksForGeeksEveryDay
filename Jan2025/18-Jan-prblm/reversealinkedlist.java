package 18-Jan-prblm;

public class reversealinkedlist {

    Name Of The Problem :- Reverse a linked list

    POTD :- 18-January-2025


    Given the head of a linked list, the task is to reverse this list and return the reversed head.

Examples:

Input: head: 1 -> 2 -> 3 -> 4 -> NULL
Output: head: 4 -> 3 -> 2 -> 1 -> NULL
Explanation:

Input: head: 2 -> 7 -> 10 -> 9 -> 8 -> NULL
Output: head: 8 -> 9 -> 10 -> 7 -> 2 -> NULL
Explanation:

Input: head: 10 -> NULL
Output: 10 -> NULL
Explanation:

Constraints:
1 <= number of nodes, data of nodes <= 105

*****************************************************************************************************************************************************


class Solution {
    Node reverseList(Node head) {
        // code here
        Node nxt=null,prev=null,cur=head;
        while(cur!=null)
        {
            nxt=cur.next;
            cur.next=prev;
            prev=cur;
            cur=nxt;
        }
        return prev;
    }
}

    
}
