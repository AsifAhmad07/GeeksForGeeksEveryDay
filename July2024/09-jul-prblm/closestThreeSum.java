package 09-jul-prblm;

public class closestThreeSum {

    Name Of The problem :- Closest Three Sum

    POTD :- 09-July-2024

    Given an array, arr of integers, and another number target, find three integers in the array such that their sum is closest to the target. Return the sum of the three integers.

Note: If there are multiple solutions, return the maximum one.

Examples :

Input: arr[] = [-7, 9, 8, 3, 1, 1], target = 2
Output: 2
Explanation: There is only one triplet present in the array where elements are -7,8,1 whose sum is 2.
Input: arr[] = [5, 2, 7, 5], target = 13
Output: 14
Explanation: There is one triplet with sum 12 and other with sum 14 in the array. Triplet elements are 5, 2, 5 and 2, 7, 5 respectively. Since abs(13-12) ==abs(13-14) maximum triplet sum will be preferred i.e 14.
Expected Time Complexity: O(n2)
Expected Auxiliary Space: O(1)

Constraints:
3 ≤ arr.size() ≤ 103
-105 ≤ arr[i] ≤ 105
1 ≤ target ≤ 105


*****************************************************************************************************************************************************Auxiliary


class Solution {
    static int threeSumClosest(int[] array, int target) {
        // code here
        int diff=Integer.MAX_VALUE,ans=0;
        Arrays.sort(array);
        for(int i=0;i<array.length-2;i++){
            int j=i+1,k=array.length-1;
            while(j<k){
                int sum=array[i]+array[j]+array[k];
                int d = Math.abs(sum-target);
                if(d<diff){
                    diff=d;
                    ans=sum;
                }
                else if(d==diff){
                    ans=Math.max(ans,sum);
                }
                if(sum<target)j++;
                else if(sum==target)return sum;
                else k--;
            }
        }
        return ans;
    }
}

    
}
