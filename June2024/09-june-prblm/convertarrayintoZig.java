package 09-june-prblm;

public class convertarrayintoZig-Zagfashion {

    Name Of The Problem :- Convert array into Zig-Zag fashion

    POTD :- 09-June-2024


    Given an array arr of distinct elements of size n, the task is to rearrange the elements of the array in a zig-zag fashion so that the converted array should be in the below form: 

arr[0] < arr[1]  > arr[2] < arr[3] > arr[4] < . . . . arr[n-2] < arr[n-1] > arr[n]. 

Note: Modify the given arr[] only, If your transformation is correct, the output will be 1 else the output will be 0. 

Examples

Input: n = 7, arr[] = {4, 3, 7, 8, 6, 2, 1}
Output: 1
Explanation:  After modification the array will look like 3 < 7 > 4 < 8 > 2 < 6 > 1, the checker in the driver code will produce 1.
Input: n = 5, arr[] = {4, 7, 3, 8, 2}
Output: 1
Explanation: After modification the array will look like 4 < 7 > 3 < 8 > 2 hence output will be 1.
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)

Constraints:
1 <= n <= 106
0 <= arri <= 109

*****************************************************************************************************************************************************

class Solution {
    public static void zigZag(int n, int[] arr) {
        // code here
        for(int i=0;i<n-1;i++){
	        if(i%2==0 && arr[i]>arr[i+1]){
	            int temp = arr[i];
	            arr[i]=arr[i+1];
	            arr[i+1]=temp;
	        }
	        else if(i%2==1 && arr[i]<arr[i+1]){
	            int temp = arr[i];
	            arr[i]=arr[i+1];
	            arr[i+1]=temp;
	        }
	    }
    }
}

    
}
