import java.time.chrono.JapaneseChronology;

package 16-Jan-prblm;

public class largestsubarrayof0'sand1's {

    Name Of The Problem :- Largest subarray of 0's and 1's

    POTD :- 16-January-2025

    Given an array arr of 0s and 1s. Find and return the length of the longest subarray with equal number of 0s and 1s.

Examples:

Input: arr[] = [1, 0, 1, 1, 1, 0, 0]
Output: 6
Explanation: arr[1...6] is the longest subarray with three 0s and three 1s.
Input: arr[] = [0, 0, 1, 1, 0]
Output: 4
Explnation: arr[0...3] or arr[1...4] is the longest subarray with two 0s and two 1s.
Input: arr[] = [0]
Output: 0
Explnation: There is no subarray with an equal number of 0s and 1s.
Constraints:
1 <= arr.size() <= 105
0 <= arr[i] <= 1


*****************************************************************************************************************************************************

class Solution {
    public int maxLen(int[] arr) {
        // Your code here
        
         HashMap<Integer,Integer> prefixSum = new HashMap<>();
        int n=arr.length,sum=0,ans=0;
        for(int i=0;i<n;i++){
            sum+=arr[i]==1?1:-1;
            if(sum==0){
                ans=i+1;
            }
            if(prefixSum.get(sum)!=null){
                ans=Math.max(ans,i-prefixSum.get(sum));
            }
            else{
                prefixSum.put(sum,i);
            }
        }
        return ans;
    }
}

    
}
