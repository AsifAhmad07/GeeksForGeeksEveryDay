package 13-Nov-prblm;

public class intersectionPointinYShapedLinkedLists {



    Name Of The Problem ;- Intersection Point in Y Shaped Linked Lists

    POTD :- 13-Novemeber-2024

    Given two singly linked lists, return the point where two linked lists intersect.

Note: If the linked lists do not merge at any point, return -1.

Examples:

Input: Linked list 1: 4->4->4->4->4, Linked list 2: 4->4->4
 
Output: 4
Explanation: From the above image, it is clearly seen that the common part is 4->4 whose starting point is 4.

Input: Linked list 1: 4->1->8->4->5, Linked List 2: 5->6->1->8->4->5
 
Output: 8
Explanation: From the above image, it is clearly seen that the common part is 8->4->5 whose starting point is 8.
Input: Linked list 1: 1->2->3, Linked list 2: 4->5->6
Output: -1
Explanation: There is no common part, so there is no interaction point.
Try to solve the problem without using any extra space.

Constraints:
2 ≤ size of first linkedist + size of second linkedlist ≤ 2*105
-1000 ≤ data of nodes ≤ 1000


*****************************************************************************************************************************************************


/* Node of a linked list
 class Node {
   int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}
 Linked List class
class LinkedList
{
    Node head;  // head of list
}*/

class Intersect {
    // Function to find intersection point in Y shaped Linked Lists.
    static int findLength(Node head){
        Node temp=head;
        int len=0;
        while(temp!=null){
            len++;
            temp=temp.next;
        }
        return len;
    }
    int intersectPoint(Node head1, Node head2) {
        // code here
        int len1=findLength(head1);
        int len2=findLength(head2);
        while(len1>len2){
            head1=head1.next;
            len1--;
        }
        while(len2>len1){
            head2=head2.next;
            len2--;
        }
        while(head1!=null && head2!=null){
            if(head1==head2)return head1.data;
            head1=head1.next;
            head2=head2.next;
        }
        return -1;
    }
}
    
}