package 12-Dec-prblm;

public class numberofoccurrence {


    Name Of The Problem :- Number of occurrence


    POTD :- 12-December-2024

    Given a sorted array, arr[] and a number target, you need to find the number of occurrences of target in arr[]. 

Examples :

Input: arr[] = [1, 1, 2, 2, 2, 2, 3], target = 2
Output: 4
Explanation: target = 2 occurs 4 times in the given array so the output is 4.
Input: arr[] = [1, 1, 2, 2, 2, 2, 3], target = 4
Output: 0
Explanation: target = 4 is not present in the given array so the output is 0.
Input: arr[] = [8, 9, 10, 12, 12, 12], target = 12
Output: 3
Explanation: target = 12 occurs 3 times in the given array so the output is 3.
Constraints:
1 ≤ arr.size() ≤ 106
1 ≤ arr[i] ≤ 106
1 ≤ target ≤ 106


*****************************************************************************************************************************************************

class Solution {
    int countFreq(int[] arr, int target) {
        // code here
        
         int n=arr.length,low=0,mid=0,high=n-1,firstIndex=-1,lastIndex=-1;
        for(int i=0;i<2;i++){
            low=0;
            high=n-1;
            while(low<=high){
                mid=(low+high)/2;
                if(arr[mid]==target){
                    if(i==0){
                        firstIndex=mid;
                        high=mid-1;
                    }
                    else{
                        lastIndex=mid;
                        low=mid+1;
                    }
                }
                else if(arr[mid]>target)high=mid-1;
                else low=mid+1;
            }
        }
        if(firstIndex==-1)return 0;
        return lastIndex-firstIndex+1;
    }
}

    
}
