package 20-Jan-prblm;

public class mergetwosortedlinkedlists {


    Name Of The Problem :- Merge two sorted linked lists

    POTD :- 20-January-2025

    Given the head of two sorted linked lists consisting of nodes respectively. The task is to merge both lists and return the head of the sorted merged list.

Examples:

Input: head1 = 5 -> 10 -> 15 -> 40, head2 = 2 -> 3 -> 20
Output: 2 -> 3 -> 5 -> 10 -> 15 -> 20 -> 40
Explanation:

Input: head1 = 1 -> 1, head2 = 2 -> 4
Output: 1 -> 1 -> 2 -> 4
Explanation:

Constraints:
1 <= no. of nodes<= 103
0 <= node->data <= 105



*****************************************************************************************************************************************************

/*
  Node is defined as
    class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
*/

class Solution {
    Node sortedMerge(Node head1, Node head2) {
        // code here
        
          Node p1=head1, p2=head2, temp=new Node(-1),head=temp;
        while(p1!=null && p2!=null){
            if(p1.data<=p2.data){
                temp.next=p1;
                p1=p1.next;
            }
            else{
                temp.next=p2;
                p2=p2.next;
            }
            temp=temp.next;
        }
        temp.next = p1!=null?p1:p2;
        return head.next;
    }
}

    
}
