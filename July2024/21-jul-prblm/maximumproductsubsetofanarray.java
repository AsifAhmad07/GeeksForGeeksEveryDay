package 21-jul-prblm;

public class maximumproductsubsetofanarray {



    Name Of The Problem :- Maximum product subset of an array

    POTD :- 21-July-2024

    Given an array arr. The task is to find and return the maximum product possible with the subset of elements present in the array.

Note:

The maximum product can be a single element also.
Since the product can be large, return it modulo 109 + 7.
Examples:

Input: arr[] = [-1, 0, -2, 4, 3]
Output: 24
Explanation: Maximum product will be ( -1 * -2 * 4 * 3 ) = 24
Input: arr[] = [-1, 0]
Output: 0
Explanation: Maximum product will be ( -1 * 0) = 0
Input: arr[] = [5]
Output: 5
Explanation: Maximum product will be 5.
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)

Constraints:
1 <= arr.size() <= 2 * 104
-10 <= arr[i] <= 10

*****************************************************************************************************************************************************


class Solution {
    public long findMaxProduct(List<Integer> arr) {
        // code here
         if(arr.size()==1)return arr.get(0);
        long pos=1,neg=1,negLar=Long.MIN_VALUE,mod=1000000007,c1=0,c2=0;
        for(Integer x:arr){
            if(x<0){
                neg=(neg*(long)x)%mod;;
                negLar=Math.max((long)x,negLar);
                c1++;
            }
            if(x>0){
                pos=(pos*(long)x)%mod;
                c2++;
            }
        }
        if(c1<=1 && c2==0)return 0;
        if(neg<0)neg/=negLar;
        return (pos*neg)%mod;
    }
}


    
}
