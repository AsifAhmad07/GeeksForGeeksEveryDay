package 23-Oct-prblm;

public class findtheSumofLastNnodesoftheLinkedList {


    Name Of The Problem :- Find the Sum of Last N nodes of the Linked List

    POTD :- 23-October-2024

    Given a single linked list, calculate the sum of the last n nodes.

Note: It is guaranteed that n <= number of nodes.

Examples:

Input: Linked List: 5->9->6->3->4->10, n = 3

Output: 17
Explanation: The sum of the last three nodes in the linked list is 3 + 4 + 10 = 17.
Input: Linked List: 1->2, n = 2

Output: 3
Explanation: The sum of the last two nodes in the linked list is 2 + 1 = 3.
Constraints:
1 <= number of nodes, n <= 105
1 <= node->data <= 103

*****************************************************************************************************************************************************
/* 
Node class is as follows:

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

    // Return the sum of last k nodes
    public int sumOfLastN_Nodes(Node head, int n) {
        // write code here
         Node temp = head;
        int count=0,sum=0;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        count-=n;
        temp=head;
        while(temp!=null){
            if(count==0)sum+=temp.data;
            else count--;
            temp=temp.next;
        }
        return sum;
    }
}
    
}
