package 15-march-prblm;

public class linkedListThatIsShortedAlternatingly {


    Name Of The Problem :- Linked List that is Sorted Alternatingly

    POTD :- 15-march-2024

    You are given a Linked list of size n. The list is in alternating ascending and descending orders. Sort the given linked list in non-decreasing order.

Example 1:

Input:
n = 6
LinkedList = 1->9->2->8->3->7
Output: 1 2 3 7 8 9
Explanation: 
After sorting the given list will be 1->2->3->7->8->9.
Example 2:

Input:
n = 5
LinkedList = 13->99->21->80->50
Output: 13 21 50 80 99
Explanation:
After sorting the given list will be 13->21->50->80->99.
Your Task:
You do not need to read input or print anything. The task is to complete the function sort() which should sort the linked list of size n in non-decreasing order. 

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)

Constraints:
1 <= Number of nodes <= 100
0 <= Values of the elements in linked list <= 103


-----------------------------------------------------------------------------------------------------------------------------------------------------


/*
class Node {
    int data;
    Node next;
    
    public Node (int data){
        this.data = data;
        this.next = null;
    }
}
*/

class Solution {
    
    public Node sort(Node head){
         //your code here, return the head of the sorted list
         
         Node head1 = new Node(0),head2 = new Node(0);
          Node temp1=head1,temp2=head2,temp=head;
          boolean indication=true;
          while(temp!=null){
              if(indication){
                  temp1.next=temp;
                  temp1=temp1.next;
              }
              else{
                  temp2.next=temp;
                  temp2=temp2.next;
              }
              temp=temp.next;
              indication=!indication;
          }
          temp1.next=null;
          temp2.next=null;
          Node curr=head2,prev=null,nxt=head2.next;
          while(curr!=null){
              nxt=curr.next;
              curr.next=prev;
              prev=curr;
              curr=nxt;
          }
          temp=prev;
          while(prev!=null){
              if(prev.next==head2){
                  prev.next=null;
              }
              prev=prev.next;
          }
          Node ans = new Node(0);
          head2=ans;
          head1=head1.next;
          while(head1!=null && temp!=null){
              if(head1.data<=temp.data){
                  ans.next=head1;
                  head1=head1.next;
              }
              else{
                  ans.next=temp;
                  temp=temp.next;
              }
              ans=ans.next;
          }
          while(head1!=null){
              ans.next=head1;
              head1=head1.next;
              ans=ans.next;
          }
          while(temp!=null){
              ans.next=temp;
              temp=temp.next;
              ans=ans.next;
          }
          return head2.next;
    }
 
 
 }
    
}
