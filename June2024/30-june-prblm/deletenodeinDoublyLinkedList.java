package 30-june-prblm;

public class deletenodeinDoublyLinkedList {


    Name Of The Problem :- Delete node in Doubly Linked List

    POTD :- 3-June-2024

    Given a doubly Linked list and a position. The task is to delete a node from a given position (position starts from 1) in a doubly linked list and return the head of the doubly Linked list.

Examples:

Input: LinkedList = 1 <--> 3 <--> 4, x = 3
Output: 1 3  
Explanation: 
After deleting the node at position 3 (position starts from 1),the linked list will be now as 1 <--> 3.
 
Input: LinkedList = 1 <--> 5 <--> 2 <--> 9, x = 1
Output: 5 2 9
Explanation:

Expected Time Complexity: O(n)
Expected Auxilliary Space: O(1)

Constraints:
2 <= size of the linked list(n) <= 105
1 <= x <= n
1 <= node.data <= 109

*****************************************************************************************************************************************************Auxilliary

/* 
Definition for doubly Link List Node
class Node
{
    int data;
    Node next;
    Node prev;
    Node(int x){
        data = x;
        next = null;
        prev = null;
    }
}
*/
class Solution {
    public Node deleteNode(Node head, int x) {
        
          Node temp = head;
        
        while(x-->1){
            temp=temp.next;
        }
        
        if(temp==head)  return head.next;
        
        if(temp.prev!=null)     temp.prev.next = temp.next;
        if(temp.next!=null)     temp.next.prev = temp.prev;
        
        return head;
    }
}

    
}
