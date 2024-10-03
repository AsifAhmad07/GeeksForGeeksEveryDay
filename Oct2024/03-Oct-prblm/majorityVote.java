package 03-Oct-prblm;

public class majorityVote {


    Name Of The Problem :- Majority Vote


    POTD :- 03-October-2024

    You are given an array of integer nums[] where each number represents a vote to a candidate. Return the candidates that have votes greater than one-third of the total votes, If there's not a majority vote, return -1. 

Note: The answer should be returned in an increasing format.

Examples:

Input: nums = [2, 1, 5, 5, 5, 5, 6, 6, 6, 6, 6]
Output: [5, 6]
Explanation: 5 and 6 occur more n/3 times.
Input: nums = [1, 2, 3, 4, 5]
Output: [-1]
Explanation: no candidate occur more than n/3 times.
Expected Time Complexity: O(n)
Expected Space Complexity: O(1)

Constraint:
1 <= nums.size() <= 106
0 <= nums[i] <= 109

*****************************************************************************************************************************************************


class Solution {
    // Function to find the majority elements in the array
    public List<Integer> findMajority(List<Integer> nums) {
        // Your code goes here.
        
        int n=nums.size(), can1=Integer.MIN_VALUE, can2=Integer.MIN_VALUE, counter1 = 0, counter2 = 0;
        for(int i=0;i<n;i++){
            if(nums.get(i)==can1)counter1++;
            else if(nums.get(i)==can2)counter2++;
            else if(counter1==0){
                can1=nums.get(i);
                counter1=1;
            }
            else if(counter2==0){
                can2=nums.get(i);
                counter2=1;
            }
            else{
                counter1--;
                counter2--;
            }
        }
        int vote1=0,vote2=0;
        for(int x:nums){
            if(x==can1)vote1++;
            if(x==can2)vote2++;
        }
        List<Integer> ans = new ArrayList<>();
        if(vote1>n/3)ans.add(can1);
        if(vote2>n/3)ans.add(can2);
        if(ans.isEmpty())ans.add(-1);
        return ans;
    }
}
    
}
