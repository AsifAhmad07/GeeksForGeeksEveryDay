package 14-Dec-prblm;

public class searchinRotatedSortedArray {


    Name Of The Problem :- Search in Rotated Sorted Array


    POTD :- 14-December-2024

    Given a sorted and rotated array arr[] of distinct elements, the task is to find the index of a target key. Return -1 if the key is not found.

Examples :

Input: arr[] = [5, 6, 7, 8, 9, 10, 1, 2, 3], key = 3
Output: 8
Explanation: 3 is found at index 8.
Input: arr[] = [3, 5, 1, 2], key = 6
Output: -1
Explanation: There is no element that has value 6.
Input: arr[] = [33, 42, 72, 99], key = 42
Output: 1
Explanation: 42 is found at index 1.
Constraints:
1 ≤ arr.size() ≤ 106
0 ≤ arr[i] ≤ 106
1 ≤ key ≤ 106


*****************************************************************************************************************************************************

class Solution {
    int search(int[] arr, int key) {
        // Complete this function
        
        // Complete this function
         int low=0,high=arr.length-1,mid;
        while(low<=high){
            mid=(low+high)/2;
            if(arr[mid]==key)return mid;
            else if(arr[mid]<arr[0]){
                if(key<=arr[high] && key>arr[mid])low=mid+1;
                else high=mid-1;
            }
            else{
                if(key<arr[mid] && key>=arr[low])high=mid-1;
                else low=mid+1;
            }
        }
        return -1;
    }
}
    
}