package 06-Jan-prblm;

public class sumPairclosesttotarget {


    Name Of The Problem :- Sum Pair closest to target

    POTD :- 06-January-2025

    Given an array arr[] and a number target, find a pair of elements (a, b) in arr[], where a<=b whose sum is closest to target.
Note: Return the pair in sorted order and if there are multiple such pairs return the pair with maximum absolute difference. If no such pair exists return an empty array.

Examples:

Input: arr[] = [10, 30, 20, 5], target = 25
Output: [5, 20]
Explanation: As 5 + 20 = 25 is closest to 25.
Input: arr[] = [5, 2, 7, 1, 4], target = 10
Output: [2, 7]
Explanation: As (4, 7) and (2, 7) both are closest to 10, but absolute difference of (2, 7) is 5 and (4, 7) is 3. Hence, [2, 7] has maximum absolute difference and closest to target. 
Input: arr[] = [10], target = 10
Output: []
Explanation: As the input array has only 1 element, return an empty array.
Constraints:
1 <= arr.size() <= 2*105
0 <= target<= 2*105
0 <= arr[i] <= 105

*****************************************************************************************************************************************************

class Solution {
    public List<Integer> sumClosest(int[] arr, int target) {
        // code here
        
          Arrays.sort(arr);
        List<Integer> ans = new ArrayList();
        int st=0, end=arr.length-1, currClose=Integer.MAX_VALUE;
        while(st<end){
            int sum=arr[st]+arr[end];
            if(Math.abs(target-sum)<currClose){
                currClose = Math.abs(target-sum);
                ans.clear();
                ans.add(arr[st]);
                ans.add(arr[end]);
            }
            if(sum<target){
                st++;
            }
            else if(sum>target){
                end--;
            }
            else {
                return ans;
            }
        }
        return ans;
    }
}
    
}
