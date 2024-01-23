package 13-jan-prblm;

public class insertionsortForSinglyLinkedList {
    /*
     * Name Of The Problem :- Insertion Sort for Singly Linked List
     * POTD :- 13-jan-2024
     * 
     * Given a singly linked list, sort the list (in ascending order) using insertion sort algorithm.

Example 1:

Input:
N = 10
Linked List = 30->23->28->30->11->14->
              19->16->21->25 
Output : 
11 14 16 19 21 23 25 28 30 30 
Explanation :
The resultant linked list is sorted.
Example 2:

Input : 
N = 7
Linked List=19->20->16->24->12->29->30 
Output : 
12 16 19 20 24 29 30 
Explanation : 
The resultant linked list is sorted.
Your task:
You don't need to read input or print anything. Your task is to complete the function insertionSort() which takes the head of the linked list, sorts the list using insertion sort algorithm and returns the head of the sorted linked list.
 
Expected Time Complexity : O(n2)
Expected Auxiliary Space : O(1)
 
Constraints:
0 <= n <= 5*103


     */

//User function Template for Java

/*class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
    */
class Solution
{
    public static Node insertionSort(Node head_ref)
    {
        //code here
        Node dummy = new Node(0);
        dummy.next = head_ref;
        Node curr = head_ref.next;
        Node lastSorted = head_ref;
        while(curr != null){
            if(curr.data < lastSorted.data){
                Node prev = dummy;
                while(prev.next.data < curr.data){
                    prev = prev.next;
                }
                lastSorted.next = curr.next;
                curr.next = prev.next;
                prev.next = curr;
                curr = lastSorted.next;
            }else{
                lastSorted =  curr;
                curr = curr.next;
            }
        }
        return dummy.next;
    }
}
    
}
