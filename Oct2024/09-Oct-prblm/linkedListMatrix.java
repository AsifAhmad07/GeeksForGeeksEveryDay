package 09-Oct-prblm;

public class linkedListMatrix {


    Name Of The Problem :- Linked List Matrix

    POTD :- 09-October-2024

    Given a Matrix mat of n*n size. Your task is constructing a 2D linked list representation of the given matrix.

Input: mat = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
Output: 

Input: mat = [[23, 28], [23, 28]]
Output:

Expected Time Complexity: O(n2)
Expected Space Complexity: O(n2)

Constraints:
1 <= mat.size() <=15
1 <= mat[i][j] <=104


*****************************************************************************************************************************************************

/*class Node

class Node
{
   int data;
   Node right,down;

   Node(int data){
       this.data = data;
       right = null;
       down = null;
   }
}
*/
/*Function should return the head of the 2D LL.*/
class Solution {
    static Node construct(int arr[][]) {
        // Add your code here.
        int n = arr.length;
        Node upper=null, prev=null, start=null, head=null;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                Node temp = new Node(arr[i][j]);
                if(head==null)head=temp;
                if(upper==null)upper=start;
                if(i!=0){
                    upper.down=temp;
                    upper=upper.right;
                }
                if(j==0)start=temp;
                if(j!=0)prev.right=temp;
                prev=temp;
            }
        }
        return head;
    }
}
    
}
