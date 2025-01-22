package 22-Jan-prblm;

public class addNumberLinkedLists {


    Name Of The Problem :- Add Number Linked Lists

    POTD :- 22-January-2025

    Given the head of two singly linked lists num1 and num2 representing two non-negative integers. The task is to return the head of the linked list representing the sum of these two numbers.

For example, num1 represented by the linked list : 1 -> 9 -> 0, similarly num2 represented by the linked list: 2 -> 5. Sum of these two numbers is represented by 2 -> 1 -> 5.

Note: There can be leading zeros in the input lists, but there should not be any leading zeros in the output list.

Examples:

Input: num1 = 4 - > 5, num2 = 3 -> 4 -> 5
Output:  3 -> 9 -> 0
 
Explanation: Given numbers are 45 and 345. There sum is 390.
Input: num1 = 0 -> 0 -> 6 -> 3, num2 = 0 -> 7 
Output: 7 -> 0 
 
Explanation: Given numbers are 63 and 7. There sum is 70.
Constraints:
1 <= size of both linked lists <= 106
0 <= elements of both linked lists <= 9


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

class Solution {
    static Node addTwoLists(Node num1, Node num2) {
        // code here
         Node l1 = reverseList(num1);
        Node l2 = reverseList(num2);
        Node curr = null;
        int carry = 0;
        while(l1!=null || l2!=null || carry >0){
            int v1 = l1!=null ? l1.data : 0;
            int v2 = l2!=null ? l2.data : 0;
            int sum = v1+v2+carry;
            carry = sum/10;
            Node tmp = new Node(sum%10);
            tmp.next = curr;
            curr = tmp;
            if(l1!=null){
                l1=l1.next;
            }
            if(l2!=null){
                l2=l2.next;
            }
        }
        while(curr!=null && curr.data == 0){
            curr=curr.next;
        }
        return curr;
    
    }
    static Node reverseList(Node head) {
        // code here
        Node tmpHead = null;
        while(head!=null){
            Node nex = head.next;
            if(tmpHead == null) {
                tmpHead = head;
                tmpHead.next = null;
            }
            else {
                head.next = tmpHead;
                tmpHead = head;
            }
            head = nex;
        }
        return tmpHead;
    }
}
    
}
