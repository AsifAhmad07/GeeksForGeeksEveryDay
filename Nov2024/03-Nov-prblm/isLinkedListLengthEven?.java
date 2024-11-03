package 03-Nov-prblm;

public class isLinkedListLengthEven? {



    Name Of The Problem :- Is Linked List Length Even?

    POTD :- 03-Novemeber-2024

    Given a linked list, your task is to complete the function isLengthEven() which contains the head of the linked list, and check whether the length of the linked list is even or not. Return true if it is even, otherwise false.

Examples:

Input: Linked list: 12->52->10->47->95->0

Output: true
Explanation: The length of the linked list is 6 which is even, hence returned true.
Input: Linked list: 9->4->3

Output: false
Explanation: The length of the linked list is 3 which is odd, hence returned false.
Expected Time Complexity: O(n)
Expected Auxillary Space: O(1)

Constraints:
1 <= number of nodes <= 105
1 <= elements of the linked list <= 105


*****************************************************************************************************************************************************

class Solution {
    public boolean isLengthEven(Node head) {
        // code here
        
         Node curr = head;
        
        while (curr != null && curr.next != null) {
            curr = curr.next.next;
        }
        
        return curr == null;
    }
}

    
}
