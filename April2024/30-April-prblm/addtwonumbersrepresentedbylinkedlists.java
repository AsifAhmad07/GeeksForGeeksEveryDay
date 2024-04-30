package 30-April-prblm;

public class addtwonumbersrepresentedbylinkedlists {


    Name Of The Problem :- Add two numbers represented by linked lists


    POTD :- 30-April-2024

    Given two decimal numbers, num1 and num2, represented by linked lists of size n and m respectively. The task is to return a linked list that represents the sum of these two numbers.

For example, the number 190 will be represented by the linked list, 1->9->0->null, similarly 25 by 2->5->null. Sum of these two numbers is 190 + 25 = 215, which will be represented by 2->1->5->null. You are required to return the head of the linked list 2->1->5->null.

Note: There can be leading zeros in the input lists, but there should not be any leading zeros in the output list.

Example 1:

Input:
n = 2
num1 = 45 (4->5->null)
m = 3
num2 = 345 (3->4->5->null)
Output: 
3->9->0->null  
Explanation: 
For the given two linked list (4 5) and (3 4 5), after adding the two linked list resultant linked list will be (3 9 0).
Example 2:

Input:
n = 4
num1 = 0063 (0->0->6->3->null)
m = 2
num2 = 07 (0->7->null)
Output: 
7->0->null
Explanation: 
For the given two linked list (0 0 6 3) and (0 7), after adding the two linked list resultant linked list will be (7 0).
Your Task:
The task is to complete the function addTwoLists() which has node reference of both the linked lists and returns the head of the sum list.   

Expected Time Complexity: O(n+m)
Expected Auxiliary Space: O(max(n,m)) for the resultant list.

Constraints:
1 <= n, m <= 104

*****************************************************************************************************************************************************

/* node for linked list

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

*/

class Solution{
    //Function to add two numbers represented by linked list.
    static Node reverse(Node head){
        Node prev=null,curr=head,nxt=null;
        while(curr!=null){
            nxt=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nxt;
        }
        return prev;
    }
    static Node addTwoLists(Node num1, Node num2){
        // code here
        // return head of sum list
        Node temp=null;
        while(num1!=null && num1.data==0){
            temp=num1;
            num1=num1.next;
        }
        if(temp!=null)
        temp.next=null;
        while(num2!=null && num2.data==0){
            temp=num2;
            num2=num2.next;
        }
        if(temp!=null)
        temp.next=null;
        if(num1==null && num2==null)return new Node(0);
        if(num1==null)return num2;
        if(num2==null)return num1;
        num1=reverse(num1);
        num2=reverse(num2);
        Node head1=num1,head2=num2;
        temp=new Node(1);
        Node ans=temp;
        int carry=0;
        while(head1!=null && head2!=null){
            int sum = head1.data+head2.data+carry;
            carry=sum/10;
            temp.next=new Node(sum%10);
            temp=temp.next;
            head1=head1.next;
            head2=head2.next;
        }
        while(head1!=null){
            int sum = head1.data+carry;
            carry=sum/10;
            temp.next=new Node(sum%10);
            temp=temp.next;
            head1=head1.next;
        }
        while(head2!=null){
            int sum = head2.data+carry;
            carry=sum/10;
            temp.next=new Node(sum%10);
            temp=temp.next;
            head2=head2.next;
        }
        if(carry!=0)temp.next=new Node(carry);
        return reverse(ans.next);
    }
}
    
}
