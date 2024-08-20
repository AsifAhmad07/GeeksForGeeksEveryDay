public class burningTree {



    Name Of The Problem :- Burning Tree

    POTD :- 20-August-2024

    Given a binary tree and a node data called target. Find the minimum time required to burn the complete binary tree if the target is set on fire. It is known that in 1 second all nodes connected to a given node get burned. That is its left child, right child, and parent.
Note: The tree contains unique values.


Examples : 

Input:      
          1
        /   \
      2      3
    /  \      \
   4    5      6
       / \      \
      7   8      9
                   \
                   10
Target Node = 8
Output: 7
Explanation: If leaf with the value 8 is set on fire. 
After 1 sec: 5 is set on fire.
After 2 sec: 2, 7 are set to fire.
After 3 sec: 4, 1 are set to fire.
After 4 sec: 3 is set to fire.
After 5 sec: 6 is set to fire.
After 6 sec: 9 is set to fire.
After 7 sec: 10 is set to fire.
It takes 7s to burn the complete tree.
Input:      
          1
        /   \
      2      3
    /  \      \
   4    5      7
  /    / 
 8    10
Target Node = 10
Output: 5

Expected Time Complexity: O(number of nodes)
Expected Auxiliary Space: O(height of tree)


Constraints:
1 ≤ number of nodes ≤ 105

1 ≤ values of nodes ≤ 105


*****************************************************************************************************************************************************


class Solution
{
    /*class Node {
    	int data;
    	Node left;
    	Node right;
    
    	Node(int data) {
    		this.data = data;
    		left = null;
    		right = null;
    	}
    }*/
    
   
    public Node markParents(Node root, Map<Node, Node> parentTrack, int target) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Node res = null;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.data == target) res = node;
            if (node.left != null) {
                parentTrack.put(node.left, node);
                queue.add(node.left);
            }
            if (node.right != null) {
                parentTrack.put(node.right, node);
                queue.add(node.right);
            }
        }
        return res;
    }

    public int minTime(Node root, int target) {
        Map<Node, Node> parentTrack = new HashMap<>();
        Node targetNode = markParents(root, parentTrack, target);

        Map<Node, Boolean> visited = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(targetNode);
        visited.put(targetNode, true);
        int time = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean burned = false;
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (node.left != null && !visited.containsKey(node.left)) {
                    burned = true;
                    visited.put(node.left, true);
                    queue.add(node.left);
                }
                if (node.right != null && !visited.containsKey(node.right)) {
                    burned = true;
                    visited.put(node.right, true);
                    queue.add(node.right);
                }
                if (parentTrack.containsKey(node) && !visited.containsKey(parentTrack.get(node))) {
                    burned = true;
                    visited.put(parentTrack.get(node), true);
                    queue.add(parentTrack.get(node));
                }
            }
            if (burned) time++;
        }
        return time;
    }
}
    
}
