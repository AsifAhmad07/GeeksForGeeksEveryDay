package 29-Oct-prblm;

public class quickSortonLinkedList {


    Name Of The Problem :- Quick Sort on Linked List

    POTD :- 29-October-2024


    You are given a Linked List. Sort the given Linked List using quicksort. 

Examples:

Input: Linked list: 1->6->2
Output: 1->2->6

Explanation:
After sorting the nodes, we have 1, 2 and 6.
Input: Linked list: 1->9->3->8
Output: 1->3->8->9

Explanation:
After sorting the nodes, we have 1, 3, 8 and 9. 
Constraints:
1<= size of linked list <= 105

*****************************************************************************************************************************************************



/*node class of the linked list
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
// you have to complete this function
class GfG {
    
    static void partition(Node pivot, Node left[], Node right[]){
       Node temp = pivot.next;
       while(temp!=null){
           Node nxt = temp.next;
           if(temp.data<=pivot.data){
               temp.next=left[0];
               left[0]=temp;
           }
           else{
               temp.next=right[0];
               right[0]=temp;
           }
           temp=nxt;
       }
   }
   public static Node quickSort(Node node) {
       // Your code here
       
        if(node==null || node.next==null)return node;
       Node left[]=new Node[1];
       Node right[]=new Node[1];
       partition(node,left,right);
       left[0] = quickSort(left[0]);
       right[0] = quickSort(right[0]);
       Node traversal = left[0];
       while(traversal!=null && traversal.next!=null)traversal=traversal.next;
       if(traversal!=null)traversal.next=node;
       else left[0]=node;
       node.next=right[0];
       return left[0];
   }
}
    
}
