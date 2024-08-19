package 15-Aug-prblm;

public class add1toaLinkedListNumber {


    Name Of The Problem :- Add 1 to a Linked List Number


    POTD :- 15-August-2024


    You are given a linked list where each element in the list is a node and have an integer data. You need to add 1 to the number formed by concatinating all the list node numbers together and return the head of the modified linked list. 

Note: The head represents the first element of the given array.

Examples :

Input: LinkedList: 4->5->6
Output: 457

Explanation: 4->5->6 represents 456 and when 1 is added it becomes 457. 
Input: LinkedList: 1->2->3
Output: 124
 
Explanation:  1->2->3 represents 123 and when 1 is added it becomes 124. 
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)

Constraints:
1 <= len(list) <= 105
0 <= list[i] <= 9

*****************************************************************************************************************************************************

/*
class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}
*/

class Solution {
    public Node addOne(Node head) {
        // code here.
         Node curr=head,nxt=head.next,prev=null;
        while(curr!=null){
            nxt=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nxt;
        }
        Node lastHead = prev;
        while(prev!=null){
            if(prev.data!=9){
                prev.data+=1;
                break;
            }
            else prev.data=0;
            prev=prev.next;
        }
        if(prev==null)head.next=new Node(1);
        curr=lastHead;
        nxt=lastHead.next;
        prev=null;
        while(curr!=null){
            nxt=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nxt;
        }
        return prev;
    }
}
    
}