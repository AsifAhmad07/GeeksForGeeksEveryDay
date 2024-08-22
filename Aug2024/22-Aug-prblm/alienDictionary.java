package 22-Aug-prblm;

public class alienDictionary {


    Name Of The Problem :- Alien Dictionary

    POTD :- 22-August-2024

    Given a sorted dictionary of an alien language having N words and k starting alphabets of standard dictionary. Find the order of characters in the alien language.
Note: Many orders may be possible for a particular test case, thus you may return any valid order and output will be 1 if the order of string returned by the function is correct else 0 denoting incorrect string returned.

Examples :

Input:  n = 5, k = 4, dict = {"baa","abcd","abca","cab","cad"}
Output: 1
Explanation: Here order of characters is 'b', 'd', 'a', 'c' Note that words are sorted and in the given language "baa" comes before "abcd", therefore 'b' is before 'a' in output.
Similarly we can find other orders.
Input: n = 3, k = 3, dict = {"caa","aaa","aab"}
Output: 1
Explanation: Here order of characters is 'c', 'a', 'b' Note that words are sorted and in the given language "caa" comes before "aaa", therefore 'c' is before 'a' in output.
Similarly we can find other orders.
Expected Time Complexity: O(n * |s| + k)
Expected Auxillary Space: O(k)

Constraints:
1 ≤ n≤ 104
1 ≤ k ≤ 26
1 ≤ Length of words ≤ 50


*****************************************************************************************************************************************************

class Solution {
    public String findOrder(String[] dict, int n, int k) {
        // Write your code here
         ArrayList<Integer>[] adj = new ArrayList[k];
        int[] indeg = new int[k];
        
        for (int i = 0; i < k; i++) {
            adj[i] = new ArrayList<>();
        }
        
        // Build the graph
        for (int i = 0; i < n - 1; i++) {
            String s1 = dict[i];
            String s2 = dict[i + 1];
            int len = Math.min(s1.length(), s2.length());
            boolean foundDiff = false;
            for (int j = 0; j < len; j++) {
                if (s1.charAt(j) != s2.charAt(j)) {
                    adj[s1.charAt(j) - 'a'].add(s2.charAt(j) - 'a');
                    indeg[s2.charAt(j) - 'a']++;
                    foundDiff = true;
                    break;
                }
            }
            // Edge case: If no difference was found and s2 is a prefix of s1, it's invalid
            if (!foundDiff && s1.length() > s2.length()) {
                return "";
            }
        }
        
        // Perform topological sort (BFS)
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            if (indeg[i] == 0) q.add(i);
        }
        
        StringBuilder ans = new StringBuilder();
        while (!q.isEmpty()) {
            int node = q.poll();
            ans.append((char)(node + 'a'));
            for (int i : adj[node]) {
                indeg[i]--;
                if (indeg[i] == 0) q.add(i);
            }
        }
        
        // If the answer's length isn't equal to k, it means there was a cycle
        if (ans.length() != k) {
            return "";
        }
        
        return ans.toString();
    }
}
    
}
