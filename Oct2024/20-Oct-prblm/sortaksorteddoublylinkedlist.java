package 20-Oct-prblm;

public class sortaksorteddoublylinkedlist {


    Name Of The Problem :- Sort a k sorted doubly linked list

    POTD :- 20-October-2024

    Given a doubly linked list, each node is at most k-indices away from its target position. The problem is to sort the given doubly linked list. The distance can be assumed in either of the directions (left and right).

Examples :

Input: Doubly Linked List : 3 <-> 2 <-> 1 <-> 5 <-> 6 <-> 4 , k = 2
Output: 1 <-> 2 <-> 3 <-> 4 <-> 5 <-> 6

Explanation: After sorting the given 2-sorted list is 1 <-> 2 <-> 3 <-> 4 <-> 5 <-> 6.
Input: Doubly Linked List : 5 <-> 6 <-> 7 <-> 3 <-> 4 <-> 4 , k = 3
Output: 3 <-> 4 <-> 4 <-> 5 <-> 6 <-> 7

Explanation: After sorting the given 3-sorted list is 3 <-> 4 <-> 4 <-> 5 <-> 6 <-> 7.
Expected Time Complexity: O(n*logk)
Expected Auxiliary Space: O(k)
Constraints:
1 <= number of nodes <= 105
1 <= k < number of nodes
1 <= node->data <= 109

*****************************************************************************************************************************************************

class Solution {
    class Compare implements java.util.Comparator<DLLNode> {
    public int compare(DLLNode a, DLLNode b) {
        return a.data - b.data; 
    }
}
    public DLLNode sortAKSortedDLL(DLLNode head, int k) {
        // Code here
        if (head == null)
            return head;
        PriorityQueue<DLLNode> pq = new PriorityQueue<>(new Compare());

        DLLNode newHead = null, last = null;
        for (int i = 0; head != null && i < k + 1; i++) {
            pq.add(head);
            head = head.next;
        }
        while (!pq.isEmpty()) {
            if (newHead == null) {
                newHead = pq.poll();
                newHead.prev = null;
                last = newHead;
            } else {
                last.next = pq.poll();
                last.next.prev = last;
                last = last.next;
            }

            if (head != null) {
                pq.add(head);
                head = head.next;
            }
        }

        last.next = null; 
        return newHead;
    }
}
    
}
