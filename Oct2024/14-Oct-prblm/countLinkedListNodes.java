package 14-Oct-prblm;

public class countLinkedListNodes {



    Name Of The Problem :- Count Linked List Nodes


    POTD :- 14-October-2024

    Given a singly linked list. The task is to find the length of the linked list, where length is defined as the number of nodes in the linked list.

Examples :

Input: LinkedList : 1->2->3->4->5

Output: 5
Explanation: Count of nodes in the linked list is 5, which is its length.
Input: LinkedList : 2->4->6->7->5->1->0
 
Output: 7
Explanation: Count of nodes in the linked list is 7. Hence, the output is 7.
Expected Time Complexity: O(n)
Expected Auxilliary Space: O(1)

Constraints:
1 <= number of nodes <= 105
1 <= node->data <= 103

*****************************************************************************************************************************************************


/*
class Node{
    int data;
    Node next;
    Node(int a){  data = a; next = null; }
  }
}}*/

class Solution {
    // Function to count nodes of a linked list.
    public int getCount(Node head) {
        // code here
         int ans = 0;
        while(head!=null){
            ans++;
            head=head.next;
        }
        return ans;
    }
}
    
}
