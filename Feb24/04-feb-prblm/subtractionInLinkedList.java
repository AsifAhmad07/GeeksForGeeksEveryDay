package 04-feb-prblm;

public class subtractionInLinkedList {


    Name Of The Problem :- Subtraction in Linked List


    POTD :- 04-feb-2024



    You are given two linked lists that represent two large positive numbers. From the two numbers represented by the linked lists, subtract the smaller number from the larger one. Look at the examples to get a better understanding of the task.

Example 1:

Input:
L1 = 1->0->0
L2 = 1->2
Output: 88
Explanation:  
First linked list represents 100 and the
second one represents 12. 12 subtracted from 100
gives us 88 as the result. It is represented
as 8->8 in the linked list.
Example 2:

Input:
L1 = 0->0->6->3
L2 = 7->1->0
Output: 647
Explanation: 
First linked list represents 0063 => 63 and 
the second one represents 710. 63 subtracted 
from 710 gives us 647 as the result. It is
represented as 6->4->7 in the linked list.
Your Task:
You do not have to take any input or print anything. The task is to complete the function subLinkedList() that takes heads of two linked lists as input parameters and which should subtract the smaller number from the larger one represented by the given linked lists and return the head of the linked list representing the result.

n and m are the length of the two linked lists respectively.
Expected Time Complexity:  O(n+m)
Expected Auxiliary Space: O(n+m)

Constraints:
1 <= n <= 10000
0 <= values represented by the linked lists < 10n
0 <= values represented by the linked lists < 10m



--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


/*

Definition for singly Link List Node
class Node
{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}

You can also use the following for printing the link list.
Node.printList(Node node);
*/

class Solution {
    public Node subLinkedList(Node head1, Node head2) {
        // code here
        
            while(head1!=null && head1.data==0)
        head1=head1.next;
        
        while(head2!=null && head2.data==0)
        head2=head2.next;
         
        int s1 = getLength(head1), s2 = getLength(head2);
        
        if(s1==0 && s2==0) return new Node(0);
         
        if(s2>s1){
            Node temp = head1; head1=head2; head2=temp;  
        }
        if(s1==s2){
            Node curr1 = head1, curr2=head2;
            while(curr1.data==curr2.data){
                curr1=curr1.next; curr2=curr2.next;
                 
                if(curr1==null)
                return new Node(0);
            }
            if(curr2.data > curr1.data){
                Node temp = head1; head1=head2; head2=temp;  
            }
        }
        
        head1 = reverse(head1); head2=reverse(head2);
        Node ans = null;
        while(head1!=null){
            int n1 = head1.data; int n2=0;
            if(head2!=null)  n2= head2.data;
            
            if(n1<n2){
                if(head1.next!=null){
                    head1.next.data -= 1;
                }
                n1+=10;
            }
         
            Node curr = new Node(n1-n2);
            curr.next = ans;
            ans = curr;
            
            head1 = head1.next;
            if(head2!=null)
                head2 = head2.next;
        }
            
      
        while(ans!=null && ans.next != null )
        {
            if(ans.data==0){
               ans = ans.next;
            }
            else
            break;
        }
        return ans;
 
        
    }
    int getLength(Node head){
         int cnt=0;  
        for(Node curr=head; curr!=null;  curr=curr.next)
        cnt++;
        return cnt;
    }
    Node reverse(Node head){
        Node prev=null, curr=head, next=null;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev=curr;
            curr=next;
        }
        return prev; 
    }
}
 
    
}
