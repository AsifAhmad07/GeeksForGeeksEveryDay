package 14-jul-prblm;

public class segregate0sand1s {

    Name Of The Problem :- Segregate 0s and 1s

    POTD:- 14-July-2024

    Given an array arr consisting of only 0's and 1's in random order. Modify the array in-place to segregate 0s onto the left side and 1s onto the right side of the array.

Examples :

Input: arr[] = [0, 0, 1, 1, 0]
Output: [0, 0, 0, 1, 1]
Explanation:  After segregation, all the 0's are on the left and 1's are on the right. Modified array will be [0, 0, 0, 1, 1].
Input: arr[] = [1, 1, 1, 1]
Output: [1, 1, 1, 1]
Explanation: There are no 0s in the given array, so the modified array is [1, 1, 1, 1]
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ arr.size() ≤ 106
0 ≤ arr[i] ≤ 1

*****************************************************************************************************************************************************



class Solution {
    void segregate0and1(int[] nums) {
        // code here
        
         int low=0;
        int high=nums.length-1;
        int mid=0;
        
        while(mid<=high)
        {
            //2 cases
            if(nums[mid]==0)
            {
                int temp=nums[mid];
                nums[mid]=nums[low];
                nums[low]=temp;
                low++;
                mid++;
            }
            
            else  //(nums[mid]==1)
            {
                int temp=nums[mid];
                nums[mid]=nums[high];
                nums[high]=temp;
                
                high--;
            }
        }
    }
}
    
}
