package 17-Oct-prblm;

public class splitLinkedListAlternatingly {


    Name Of The Problem :- Split Linked List Alternatingly


    POTD :- 17-October-2024

    Given a singly linked list's head. Your task is to complete the function alternatingSplitList() that splits the given linked list into two smaller lists. The sublists should be made from alternating elements from the original list.
Note: 

The sublist should be in the order with respect to the original list.
Your have to return an array containing the both sub-linked lists.
Examples:

Input: LinkedList = 0->1->0->1->0->1
Output: 0->0->0 , 1->1->1
Explanation: After forming two sublists of the given list as required, we have two lists as: 0->0->0 and 1->1->1.

Input: LinkedList = 2->5->8->9->6
Output: 2->8->6 , 5->9
Explanation: After forming two sublists of the given list as required, we have two lists as: 2->8->6 and 5->9.
Input: LinkedList: 7 
Output: 7 , <empty linked list>
Constraints:
1 <= number of nodes <= 100
1 <= node -> data <= 104

*****************************************************************************************************************************************************


/*
struct Node
{
    int data;
    struct Node* next;

    Node(int x){
        data = x;
        next = NULL;
    }

};
*/

class Solution {
    // Function to append a new node with newData at the end of a linked list
    Node[] alternatingSplitList(Node head) {
        // code here
         Node head1=null,head2=null,temp1=null,temp2=null;
        int count=0;
        while(head!=null){
            if(count%2==1){
                if(head2==null){
                    head2=head;
                    temp2=head;
                }
                else{
                    temp2.next=head;
                    temp2=temp2.next;
                }
            }
            else{
                if(head1==null){
                    head1=head;
                    temp1=head;
                }
                else{
                    temp1.next=head;
                    temp1=temp1.next;
                }
            }
            head=head.next;
            count++;
        }
        temp1.next=null;
        temp2.next=null;
        Node ans[] = new Node[2];
        ans[0]=head1;
        ans[1]=head2;
        return ans;
    }
}

    
}
