import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

package 20-Nov-prblm;

public class majorityElementII {

    Name Of The Problem :- Majority Element II


    POTD :- 20-Novemeber-2024

    You are given an array of integer arr[] where each number represents a vote to a candidate. Return the candidates that have votes greater than one-third of the total votes, If there's not a majority vote, return an empty array. 

    Note: The answer should be returned in an increasing format.
    
    Examples:
    
    Input: arr[] = [2, 1, 5, 5, 5, 5, 6, 6, 6, 6, 6]
    Output: [5, 6]
    Explanation: 5 and 6 occur more n/3 times.
    Input: arr[] = [1, 2, 3, 4, 5]
    Output: []
    Explanation: no candidate occur more than n/3 times.
    Constraint:
    1 <= arr.size() <= 106
    -109 <= arr[i] <= 109


    *************************************************************************************************************************************************

    
class Solution {
    // Function to find the majority elements in the array
    public List<Integer> findMajority(int[] nums) {
        // Your code goes here.
         List<Integer> list = new ArrayList<>();
        HashMap<Integer,Integer> hm = new HashMap<>();
        int n = nums.length;
        int m = n/3;
        
        for(int i = 0; i < n; i++)
        {
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        }
        
        for(int k : hm.keySet())
        {
            if(hm.get(k) > m)
            {
                list.add(k);
            }
        }
      
        Collections.sort(list);
        return list;
    }
}

    
}
