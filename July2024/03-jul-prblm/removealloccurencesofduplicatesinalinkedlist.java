package 03-jul-prblm;

public class removealloccurencesofduplicatesinalinkedlist {

    Name Of The Problem :- Remove all occurences of duplicates in a linked list

    POTD :- 03-July-2024

    Given a sorted linked list, delete all nodes that have duplicate numbers (all occurrences), leaving only numbers that appear once in the original list, and return the head of the modified linked list. 

Examples:

Input: Linked List = 23->28->28->35->49->49->53->53
Output: 23 35
Explanation: 

The duplicate numbers are 28, 49 and 53 which are removed from the list.
Input: Linked List = 11->11->11->11->75->75
Output: Empty list
Explanation: 

All the nodes in the linked list have duplicates. Hence the resultant list would be empty.
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)
Constraints:
1 ≤ size(list) ≤ 105

*****************************************************************************************************************************************************

class Solution {
    public Node removeAllDuplicates(Node head) {
        // code here
         if(head.next==null)return head;
        Node ans=new Node(-1),prev=head;
        Node temp=ans;
        head=head.next;
        int count=1;
        while(head!=null){
            if(prev.data==head.data)count++;
            else if(count==1){
                temp.next=prev;
                temp=temp.next;
            }
            else count=1;
            prev=head;
            head=head.next;
        }
        if(count==1)temp.next=prev;
        else
        temp.next=null;
        return ans.next;
    }
}
    
}
