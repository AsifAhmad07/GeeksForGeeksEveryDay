package 07-Nov-prblm;

public class splitarrayinthreeequalsumsubarrays {


    Name Of The Problem :- Split array in three equal sum subarrays

    POTD :- 07-Novemeber-2024

    Given an array, arr[], determine if arr can be split into three consecutive parts such that the sum of each part is equal. If possible, return any index pair(i, j) in an array such that sum(arr[0..i]) = sum(arr[i+1..j]) = sum(arr[j+1..n-1]), otherwise return an array {-1,-1}.

Note: Since multiple answers are possible, return any of them. The driver code will print true if it is correct otherwise, it will print false.

Examples :

Input:  arr[] = [1, 3, 4, 0, 4]
Output: true
Explanation: [1, 2] is valid pair as sum of subarray arr[0..1] is equal to sum of subarray arr[2..3] and also to sum of subarray arr[4..4]. The sum is 4, so driver code prints true.
Input: arr[] = [2, 3, 4]
Output: false
Explanation: No three subarrays exist which have equal sum.
Input: arr[] = [0, 1, 1]
Output: false
Constraints:
3 ≤ arr.size() ≤ 106
0 ≤ arr[i] ≤ 106

*****************************************************************************************************************************************************

class Solution {

    public List<Integer> findSplit(int[] arr) {
        // Return an array of possible answer, driver code will judge and return true or
        // false based on
         int n = arr.length,sum=0;
        List<Integer> ans = new ArrayList<>();
        for(int x:arr)sum+=x;
        if(sum%3!=0){
            ans.add(-1);
            ans.add(-1);
            return ans;
        }
        int requiredSum=sum/3;
        sum=0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
            if(sum==requiredSum){
                ans.add(i);
                if(ans.size()==2)break;
                sum=0;
            }
        }
        if(ans.size()==2)return ans;
        ans.clear();
        ans.add(-1);
        ans.add(-1);
        return ans;
    }
}
    
}
