package 31-Oct-prblm;

public class insertinSortedwayinaSortedDLL {


    Name Of The Problem :-Insert in Sorted way in a Sorted DLL

    POTD :- 31-October-2024

    
    
    Given a sorted doubly linked list and an element x, you need to insert the element x into the correct position in the sorted Doubly linked list(DLL).

    Note: The DLL is sorted in ascending order
    
    Example:
    
    Input: LinkedList: 3->5->8->10->12 , x = 9
    
    Output: 3->5->8->9->10->12
    
    Explanation: Here node 9 is inserted in the Doubly Linked-List.
    Input: LinkedList: 1->4->10->11 , x = 15
    
    Output: 1->4->10->11->15
    
    Constraints:
    1 <= number of nodes <= 103
    1 <= node -> data , x <= 104


    *************************************************************************************************************************************************


/*class of the node of the DLL is as
/*
class Node {
    int data;
    Node prev, next;
    Node(int data) {
        this.data = data;
        this.prev = this.next = null;
    }
}
*/
class Solution {
    public Node sortedInsert(Node head, int x) {
        // add your code here
         Node newNode = new Node(x);

        if (head == null || head.data >= x) {
            newNode.next = head;
            if (head != null) {
                head.prev = newNode;
            }
            newNode.prev = null;
            return newNode;
        }

        Node current = head;

        while (current.next != null && current.next.data < x) {
            current = current.next;
        }


        if (current.next == null) {
            current.next = newNode;
            newNode.prev = current;
            newNode.next = null;
        } else {

            newNode.next = current.next;
            newNode.prev = current;
            current.next.prev = newNode;
            current.next = newNode;
        }

        return head; 
    }
}

    
}
