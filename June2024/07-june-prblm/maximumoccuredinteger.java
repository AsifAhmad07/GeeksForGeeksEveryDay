package 07-june-prblm;

public class maximumoccuredinteger {


    Name Of The Problem :- Maximum occured integer

    POTD :- 07-June-2024

    Given n integer ranges, the task is to return the maximum occurring integer in the given ranges. If more than one such integer exists, return the smallest one.
    The ranges are in two arrays l[] and r[].  l[i] consists of the starting point of the range and r[i] consists of the corresponding endpoint of the range & a maxx which is the maximum value of r[].
    
    For example, consider the following ranges.
    l[] = {2, 1, 3}, r[] = {5, 3, 9)
    Ranges represented by the above arrays are.
    [2, 5] = {2, 3, 4, 5}
    [1, 3] = {1, 2, 3}
    [3, 9] = {3, 4, 5, 6, 7, 8, 9}
    The maximum occurred integer in these ranges is 3.
    
    Examples :
    
    Input: n = 4, l[] = {1,4,3,1}, r[] = {15,8,5,4}, maxx = 15
    Output: 4
    Explanation: The given ranges are [1,15] [4, 8] [3, 5] [1, 4]. The smallest number that is most common or appears most times in the ranges is 4.
    Input: n = 5, l[] = {1,5,9,13,21}, r[] = {15,8,12,20,30}, maxx = 30
    Output: 5
    Explanation: The given ranges are [1, 15] [5, 8] [9, 12] [13, 20] [21, 30]. The smallest number that is most common or appears most times in the ranges is 5.
    Expected Time Complexity: O(n+maxx).
    Expected Auxiliary Space: O(maxx), maxx is maximum element in r[]
    
    Constraints:
    1 ≤ n ≤ 106
    0 ≤ l[i], r[i] ≤ 106

    *************************************************************************************************************************************************


    class Solution {
        // Function to find the maximum occurred integer in all ranges.
        public static int maxOccured(int n, int l[], int r[], int maxx) {
               int arr[] = new int[maxx+2];
            for( int  i = 0; i<n ;i++)
            {
                arr[L[i]]++;
                arr[R[i]+1] --;
                
                
            }
            
            int max = arr[0] , res = 0;
            for( int i  = 1; i<maxx+1; i++)
            {
                arr[i] +=arr[i-1];
                if(max  <arr[i])
                {
                    max =arr[i];
                    res= i;
                }
            }
            return res;
        }
    }
    
}
