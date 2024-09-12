package 12-Sept-prblm;

public class middleofaLinkedList {


    Name Of The Problem :- Middle of a Linked List

    POTD :- 12-September-2024


    Given the head of a linked list, the task is to find the middle. For example, the middle of 1-> 2->3->4->5 is 3. If there are two middle nodes (even count), return the second middle. For example, middle of 1->2->3->4->5->6 is 4.

Examples:

Input: Linked list: 1->2->3->4->5
Output: 3

Explanation: The given linked list is 1->2->3->4->5 and its middle is 3.
Input: Linked list: 2->4->6->7->5->1
Output: 7 

Explanation: The given linked list is 2->4->6->7->5->1 and its middle is 7.
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)

Constraints:
1 <= no. of nodes <= 105

*******************************************************************************************************************************************************************************************************

/* Node of a linked list
 class Node {
   int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}
*/

class Solution {
    int getMiddle(Node head) {
        // Your code here.
        
         Node slow = head, fast = head.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return fast!=null?slow.next.data:slow.data;
    }
}

    
}
