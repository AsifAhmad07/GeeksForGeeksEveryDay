package 27-Nov-prblm;

public class smallestPositiveMissingNumber {


    Nama Of The Problem :- Smallest Positive Missing Number
    
    
    POTD :- 27-November-2024


    You are given an integer array arr[]. Your task is to find the smallest positive number missing from the array.

Note: Positive number starts from 1. The array can have negative integers too.

Examples:

Input: arr[] = [2, -3, 4, 1, 1, 7]
Output: 3
Explanation: Smallest positive missing number is 3.
Input: arr[] = [5, 3, 2, 5, 1]
Output: 4
Explanation: Smallest positive missing number is 4.
Input: arr[] = [-8, 0, -1, -4, -3]
Output: 1
Explanation: Smallest positive missing number is 1.
Constraints:  
1 <= arr.size() <= 105
-106 <= arr[i] <= 106

*****************************************************************************************************************************************************



class Solution {
    // Function to find the smallest positive number missing from the array.
    public int missingNumber(int[] arr) {
        // Your code here
        int size = arr.length;
        int i=0,temp=0;
        while(i<size){
            if(arr[i]>0 && arr[i]<=size && arr[i]!=arr[arr[i]-1]){
                temp = arr[i];
                arr[i]=arr[arr[i]-1];
                arr[temp-1]=temp;
            }
            else i++;
        }
        for(i=0;i<size;i++){
            if(arr[i]!=i+1)return i+1;
        }
        return size+1;
    }
}

}
