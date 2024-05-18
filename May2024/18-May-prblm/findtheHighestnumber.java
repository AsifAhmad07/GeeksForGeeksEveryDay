package 18-May-prblm;

public class findtheHighestnumber {


    Name Of The Problem :- Find the Highest number


    POTD :- 18-May-2024

    Given an integer array a[] of size n, find the highest element of the array. The array will either be strictly increasing or strictly increasing and then strictly decreasing.

Note: a[i] != a[i+1] 

Example 1:

Input:
11
1 2 3 4 5 6 5 4 3 2 1
Output: 
6
Explanation: 
Highest element of array a[] is 6.
Example 2:

Input:
5
1 2 3 4 5
Output:
5
Explanation: 
Highest element of array a[] is 5.
Your Task:
You don't need to read or print anything. Your task is to complete the function findPeakElement() which takes integer n, and the array a[] as the input parameters and returns the highest element of the array.

Expected Time Complexity: O(log(n))
Expected Space Complexity: O(1)

Constraints:
2 <= n <= 106
1 <= a[i] <= 106

*****************************************************************************************************************************************************


class Solution {
    public int findPeakElement(List<Integer> a) {
        // Code here
        
         int low=0,high=a.size()-1,mid=-1,n=a.size();
        boolean temp1=false,temp2=false,temp3=false;
        while(low<=high)
        {
            mid=(low+high)/2;
            temp1=mid!=n-1?a.get(mid)>a.get(mid+1):true;
            temp2=mid!=0?a.get(mid)>a.get(mid-1):true;
            temp3=mid!=0?a.get(mid)<a.get(mid-1):true;
            if(temp1 && temp2)break;
            else if(temp1 && temp3)high=mid-1;
            else low=mid+1;
        }
        return a.get(mid);
    }
}
    
}
