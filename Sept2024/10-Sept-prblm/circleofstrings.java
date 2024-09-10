package 10-Sept-prblm;

public class circleofstrings {


    Name Of The Problem :- Circle of strings

    POTD :- 10-September-2024

    Given an array arr of lowercase strings, determine if the strings can be chained together to form a circle.
A string X can be chained together with another string Y if the last character of X is the same as the first character of Y. If every string of the array can be chained with exactly two strings of the array(one with the first character and the second with the last character of the string), it will form a circle.

For example, for the array arr[] = {"for", "geek", "rig", "kaf"} the answer will be Yes as the given strings can be chained as "for", "rig", "geek" and "kaf"

Examples

Input: arr[] = ["abc", "bcd", "cdf"]
Output: 0
Explaination: These strings can't form a circle because no string has 'd'at the starting index.
Input: arr[] = ["ab" , "bc", "cd", "da"]
Output: 1
Explaination: These strings can form a circle of strings.
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(n)

Constraints: 
1 ≤ length of strings ≤ 20


*****************************************************************************************************************************************************

class Solution {
    public int isCircle(String arr[]) {
        // code here
         int n = arr.length;
        Queue<Integer> q = new LinkedList<>();
        int vis[] = new int[n];
        int indegree[] = new int[26];
        int outdegree[] = new int[26];
        Map<Character,ArrayList<Integer>> mm = new HashMap<>();
        for(int i=0;i<n;i++){
            mm.putIfAbsent(arr[i].charAt(0),new ArrayList<Integer>());
            mm.get(arr[i].charAt(0)).add(i);
            indegree[arr[i].charAt(0)-'a']++;
            outdegree[arr[i].charAt(arr[i].length()-1)-'a']++;
        }
        for(char x:mm.keySet()){
            if(indegree[x-'a']!=outdegree[x-'a'])return 0;
        }
        q.add(0);
        vis[0]=1;
        int ans = 1;
        while(!q.isEmpty()){
            int index = q.remove();
            char ch = arr[index].charAt(arr[index].length()-1);
            for(int x:mm.get(ch)){
                if(vis[x]==0){
                    q.add(x);
                    ans++;
                    vis[x]=1;
                }
            }
        }
        return ans==n?1:0;
    }
}
    
}
