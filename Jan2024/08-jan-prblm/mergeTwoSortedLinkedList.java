package 08-jan-prblm;

public class mergeTwoSortedLinkedList {
    /*
     * Name Of The Problem :- Merge 2 sorted linked list in reverse order
     * POTD :- 08-01-2024
     * Given two linked lists of size N and M, which are sorted in non-decreasing order. The task is to merge them in such a way that the resulting list is in non-increasing order.

Example 1:

Input:
N = 2, M = 2
list1 = 1->3
list2 = 2->4
Output:
4->3->2->1
Explanation:
After merging the two lists in non-increasing order, we have new lists as 4->3->2->1.
Example 2:

Input:
N = 4, M = 3
list1 = 5->10->15->40 
list2 = 2->3->20
Output:
40->20->15->10->5->3->2
Explanation:
After merging the two lists in non-increasing order, we have new lists as 40->20->15->10->5->3->2.
Your Task:
The task is to complete the function mergeResult() which takes reference to the heads of both linked list and returns the pointer to the merged linked list.

Expected Time Complexity : O(N+M)
Expected Auxiliary Space : O(1)

Constraints:
0 <= N, M <= 104


     */
   /* Structure of the node*/
/* class Node
{
	int data;
	Node next;
	
	Node(int d)
	{
		data = d;
		next = null;
	}
} */

class GfG
{
    Node mergeResult(Node node1, Node node2)
    {
	// Your code here
	if(node1 == null && node2 == null) {
            return null;
        }
        
        Node present = null;
        
        while (node1 != null && node2 != null) {
            if (node1.data <= node2.data) {
                Node temp = node1.next;
                node1.next = present;
                present = node1;
                node1 = temp;
            } else {
                Node temp = node2.next;
                node2.next = present;
                present = node2;
                node2 = temp;
            }
        }
        
        while (node1 != null) {
            Node temp = node1.next;
            node1.next = present;
            present = node1;
            node1 = temp;
        }
        
        while (node2 != null) {
            Node temp = node2.next;
            node2.next = present;
            present = node2;
            node2 = temp;
        }
        
        return present;
	
    }
}


    
}
