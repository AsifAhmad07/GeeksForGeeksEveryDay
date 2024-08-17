package 17-Aug-prblm;

public class productarraypuzzle {



    Name Of The Problem :- Product array puzzle


    POTD :- 17-August-2024

    Given an array nums[], construct a Product Array nums[] such that nums[i] is equal to the product of all the elements of nums except nums[i].

Examples:

Input: nums[] = [10, 3, 5, 6, 2]
Output: [180, 600, 360, 300, 900]
Explanation: For i=0, P[i] = 3*5*6*2 = 180.
For i=1, P[i] = 10*5*6*2 = 600.
For i=2, P[i] = 10*3*6*2 = 360.
For i=3, P[i] = 10*3*5*2 = 300.
For i=4, P[i] = 10*3*5*6 = 900.
Input: nums[] = [12,0]
Output: [0, 12]
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(n)

Constraints:
1 <= nums.size() <= 1000
0 <= nums[i] <= 200
nums[i] may contain duplicates.


*****************************************************************************************************************************************************


class Solution {
    public static long[] productExceptSelf(int nums[]) {
        // code here
         long temp = 1,c=0;
        int n=nums.length,index=-1;
        for(int i=0;i<n;i++){
            if(nums[i]!=0)temp*=nums[i];
            else{
                c++;
                index=i;
            }
        }
        long ans[] = new long[n];
        if(c>1)return ans;
        if(c==1){
            ans[index]=temp;
            return ans;
        }
        for(int i=0;i<n;i++){
            ans[i]=temp/nums[i];
        }
        return ans;
    }
}

    
}
