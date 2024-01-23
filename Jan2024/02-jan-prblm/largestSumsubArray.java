package 02-jan-prblm;

public abstract class largestSumsubArray {
    /*
     * Largest Sum Subarray of Size at least K
     * Given an array a of length n and a number k, find the largest sum of the subarray containing at least k numbers. It is guaranteed that the size of array is at-least k.

Example 1:

Input : 
n = 4
a[] = {1, -2, 2, -3}
k = 2
Output : 
1
Explanation :
The sub-array of length at-least 2
that produces greatest sum is {1, -2}
Example 2:
Input :
n = 6 
a[] = {1, 1, 1, 1, 1, 1}
k = 2
Output : 
6
Explanation :
The sub-array of length at-least 2
that produces greatest sum is {1, 1, 1, 1, 1, 1}
Your Task:  
You don't need to read input or print anything. Your task is to complete the function maxSumWithK() which takes the array a[], its size n and an integer k as inputs and returns the value of the largest sum of the subarray containing at least k numbers.

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(n)

Constraints:
1 <= n <= 105
-105 <= a[i] <= 105
1 <= k <= n

LinkOfTheProblem :- https://www.geeksforgeeks.org/problems/largest-sum-subarray-of-size-at-least-k3121/1

     */
    class Solution {
    
        public long maxSumWithK(long a[], long n, long k)
        {
           int N = (int)n;
           int K = (int)k;
           long maxSum[] = new long[N];
           maxSum[0] = a[0];
           long curr_sum = a[0];
           for(int i = 1; i < N; i++){
               curr_sum = Math.max(a[i], a[i] + curr_sum);
               maxSum[i] = curr_sum;
           }
           long ans = 0, sum = 0;
           for(int i = 0; i < K; i++){
               sum += a[i];
           }
           ans = sum;
           for(int i = K; i < N; i++){
               sum += a[i] - a[i-K];
               ans = Math.max(ans , sum);
               ans = Math.max(ans , sum + maxSum[i-K]);
           }
           return ans;
        }
    }

  
}