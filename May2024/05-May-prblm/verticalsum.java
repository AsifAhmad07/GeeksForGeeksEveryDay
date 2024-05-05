import java.util.jar.Attributes.Name;

package 05-May-prblm;

public class verticalsum {


    Name Of The Problem :-  Vertical sum


    POTD :- 05-May-2024

    Given a binary tree having n nodes, find the vertical sum of the nodes that are in the same vertical line. Return all sums through different vertical lines starting from the left-most vertical line to the right-most vertical line.

Example 1:

Input:
       1
    /    \
  2      3
 /  \    /  \
4   5  6   7
Output: 
4 2 12 3 7
Explanation:
The tree has 5 vertical lines
Line 1 has only one node 4 => vertical sum is 4.
Line 2 has only one node 2 => vertical sum is 2.
Line-3 has three nodes: 1,5,6 => vertical sum is 1+5+6 = 12.
Line-4 has only one node 3 => vertical sum is 3.
Line-5 has only one node 7 => vertical sum is 7.
Example 2:

Input:
          1
         /
        2
       /
      3
     /
    4
   /
  6
 /
7
Output: 
7 6 4 3 2 1
Explanation:
There are six vertical lines each having one node.
Your Task:
You don't need to take input. Just complete the function verticalSum() that takes root node of the tree as parameter and returns an array containing the vertical sum of tree from left to right.

Expected Time Complexity: O(nlogn).
Expected Auxiliary Space: O(n).

Constraints:
1<=n<=104
1<= Node value <= 105

*****************************************************************************************************************************************************


/*Complete the function below
Node is as follows:
class Node{
int data;
Node left, right;
Node(int item)
{
    data = item;
    left = right = null
}
}
*/
class Solution{
     int mn = Integer.MAX_VALUE,mx=Integer.MIN_VALUE;
  void help(Node root,HashMap<Integer,Integer> mm,int vLevel){
      if(root==null)return;
      mn=Math.min(mn,vLevel);
      mx=Math.max(mx,vLevel);
      mm.put(vLevel,mm.getOrDefault(vLevel,0)+root.data);
      help(root.left,mm,vLevel-1);
      help(root.right,mm,vLevel+1);
  }
    public ArrayList <Integer> verticalSum(Node root) {
        // add your code here
          HashMap<Integer,Integer> mm = new HashMap<>();
        help(root,mm,0);
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=mn;i<=mx;i++){
            if(mm.get(i)!=null)ans.add(mm.get(i));
        }
        return ans;
    }
}
    
}
