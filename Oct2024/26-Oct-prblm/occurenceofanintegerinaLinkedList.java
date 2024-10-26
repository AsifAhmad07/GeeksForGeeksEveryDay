package 26-Oct-prblm;

public class occurenceofanintegerinaLinkedList {



    Name Of The Problem :- Occurence of an integer in a Linked List


    POTD :- 26-October-2024

    Given a singly linked list and a key, count the number of occurrences of the given key in the linked list.

Examples:

Input: Linked List: 1->2->1->2->1->3->1, key = 1

Output: 4
Explanation: 1 appears 4 times. 
Input: Linked List: 1->2->1->2->1, key = 3

Output: 0
Explanation: 3 appears 0 times.
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ number of nodes, key ≤ 105
1 ≤ data of node ≤ 105


*****************************************************************************************************************************************************
/* 
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}*/
// complete the below function
class Solution {
    public static int count(Node head, int key) {
        // code here
        if (head == null) 
            return 0;
        int ans = count(head.next, key);
        if (head.data == key)
            ans++;
        return ans;
    }
}
    
}
