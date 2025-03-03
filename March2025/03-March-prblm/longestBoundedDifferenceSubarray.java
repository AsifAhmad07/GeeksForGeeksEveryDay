package 03-March-prblm;

public class longestBoundedDifferenceSubarray {

    Name Of The Problem :- Longest Bounded-Difference Subarray

    Date :- 03-March-2025

    Given an array of positive integers arr[] and a non-negative integer x, the task is to find the longest sub-array where the absolute difference between any two elements is not greater than x.
If multiple such subarrays exist, return the one that starts at the smallest index.

Examples: 

Input: arr[] = [8, 4, 2, 6, 7], x = 4 
Output: [4, 2, 6] 
Explanation: The sub-array described by index [1..3], i.e. [4, 2, 6] contains no such difference of two elements which is greater than 4.
Input: arr[] = [15, 10, 1, 2, 4, 7, 2], x = 5 
Output: [2, 4, 7, 2] 
Explanation: The sub-array described by indexes [3..6], i.e. [2, 4, 7, 2] contains no such difference of two elements which is greater than 5. 
Constraints:
1 <= arr.size() <= 105
1 <= arr[i] <= 109
0 <= x<= 109


*****************************************************************************************************************************************************


class Solution {

    public ArrayList<Integer> longestSubarray(int[] arr, int x) {
        // code here
        
          Deque<Integer> maxDq = new LinkedList<>();
        Deque<Integer> minDq = new LinkedList<>();
        int str = 0, maxLen = 0, ansStr = 0;
        for(int end = 0; end<arr.length;end++){
            while(!maxDq.isEmpty() && arr[maxDq.peekLast()] <= arr[end]){
                maxDq.pollLast();
            }
            maxDq.addLast(end);
            while(!minDq.isEmpty() && arr[minDq.peekLast()] >= arr[end]){
                minDq.pollLast();
            }
            minDq.addLast(end);
            
            while(arr[maxDq.peekFirst()]-arr[minDq.peekFirst()] > x){
                str++;
                if(maxDq.peekFirst()<str) maxDq.pollFirst();
                if(minDq.peekFirst()<str) minDq.pollFirst();
            }
            
            if(end-str + 1 > maxLen){
                maxLen = end-str + 1;
                ansStr = str;
            }
        }
        
        ArrayList<Integer> ans = new ArrayList();
        for(int i=ansStr;i<ansStr+maxLen; i++){
            ans.add(arr[i]);
        }
        return ans;
    }
}

    
}
