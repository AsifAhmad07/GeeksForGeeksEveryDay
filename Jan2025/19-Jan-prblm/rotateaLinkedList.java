package 19-Jan-prblm;

public class rotateaLinkedList {

    
    Name Of The Problem :- Rotate a Linked List

    POTD :- 19-January-2025


    Given the head of a singly linked list, your task is to left rotate the linked list k times.

Examples:

Input: head = 10 -> 20 -> 30 -> 40 -> 50, k = 4
Output: 50 -> 10 -> 20 -> 30 -> 40
Explanation:
Rotate 1: 20 -> 30 -> 40 -> 50 -> 10
Rotate 2: 30 -> 40 -> 50 -> 10 -> 20
Rotate 3: 40 -> 50 -> 10 -> 20 -> 30
Rotate 4: 50 -> 10 -> 20 -> 30 -> 40

Input: head = 10 -> 20 -> 30 -> 40 , k = 6
Output: 30 -> 40 -> 10 -> 20 
 
Constraints:

1 <= number of nodes <= 105
0 <= k <= 109
0 <= data of node <= 109




*****************************************************************************************************************************************************



class Solution {
    public Node rotate(Node head, int k) {
        // add code here
        
        int len=1;
        Node tmp = head;
        while(tmp.next!=null){
            len++;
            tmp=tmp.next;
        }
        k=k%len;
        if(k==0)
            return head;
        tmp.next = head;
        tmp=head;
        for(int i=1;i<k;i++){
            tmp=tmp.next;
        }
        head = tmp.next;
        tmp.next = null;
        return head;
    }
}   
}
