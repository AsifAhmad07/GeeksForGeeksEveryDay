/*
 * Array Pair Sum Divisibility Problem
 * Given an array of integers nums and a number k, write a function that returns true if given array can be divided into pairs such that sum of every pair is divisible by k.

Example 1 :

Input : 
nums = [9, 5, 7, 3]
k = 6
Output: 
True
Explanation: 
{(9, 3), (5, 7)} is a 
possible solution. 9 + 3 = 12 is divisible
by 6 and 7 + 5 = 12 is also divisible by 6.
Example 2:

Input : 
nums = [4, 4, 4]
k = 4
Output: 
False
Explanation: 
You can make 1 pair at max, leaving a single 4 unpaired.
Your Task:
You don't need to read or print anything. Your task is to complete the function canPair() which takes array nums and k as input parameter and returns true if array can be divided into pairs such that sum of every pair is divisible by k otherwise returns false.

Expected Time Complexity: O(n)
Expected Space Complexity : O(n)

Constraints:
1 <= length( nums ) <= 105
1 <= numsi <= 105
1 <= k <= 105
LinkOfTheProblem :- https://www.geeksforgeeks.org/problems/array-pair-sum-divisibility-problem3257/1

 */
class Solution {
    public boolean canPair(int[] nums, int k) {
        // Code here
          if (nums.length % 2 != 0) {
            return false;
        }
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i : nums) {
            int y = i % k;
            if (mp.getOrDefault((k - y) % k, 0) != 0) {
                mp.put((k - y) % k, mp.get((k - y) % k) - 1);
            } else {
                mp.put(y, mp.getOrDefault(y, 0) + 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            if (entry.getValue() != 0) {
                return false;
            }
        }
        return true;
        // problem of the day 01
    }
}