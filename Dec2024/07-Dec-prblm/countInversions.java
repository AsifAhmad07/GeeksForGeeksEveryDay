package 07-Dec-prblm;

public class countInversions {

    Name Of The Problem :- Count Inversions


    POTD :- 07-December-2024


    Given an array of integers arr[]. Find the Inversion Count in the array.
Two elements arr[i] and arr[j] form an inversion if arr[i] > arr[j] and i < j.

Inversion Count: For an array, inversion count indicates how far (or close) the array is from being sorted. If the array is already sorted then the inversion count is 0.
If an array is sorted in the reverse order then the inversion count is the maximum. 

Examples:

Input: arr[] = [2, 4, 1, 3, 5]
Output: 3
Explanation: The sequence 2, 4, 1, 3, 5 has three inversions (2, 1), (4, 1), (4, 3).
Input: arr[] = [2, 3, 4, 5, 6]
Output: 0
Explanation: As the sequence is already sorted so there is no inversion count.
Input: arr[] = [10, 10, 10]
Output: 0
Explanation: As all the elements of array are same, so there is no inversion count.
Constraints:
1 ≤ arr.size() ≤ 105
1 ≤ arr[i] ≤ 104


*****************************************************************************************************************************************************

class Solution {
    // Function to count inversions in the array.
    static int inversionCount(int arr[]) {
        // Your Code Here
        int l = 0;
        int h = arr.length - 1;
        int[] temp = new int[arr.length];
        int[] invCnt = new int[1];
        mergeSort(arr, l, h, temp, invCnt);
        return invCnt[0];
    }
    
    static void mergeSort(int[] arr, int l, int h, int[] temp, int[] invCnt){
        if(l >= h){
            return;
        }
        
        int mid = (l + h) / 2;
        mergeSort(arr, l, mid, temp, invCnt);
        mergeSort(arr, mid + 1, h, temp, invCnt);
        merge(arr, l, mid, h, temp, invCnt);
    }
    
    static void merge(int[] arr, int l, int mid, int h, int[] temp, int[] invCnt){
        int i = l;
        int j = mid + 1;
        int k = l;
        while(i <= mid && j <= h){
            if(arr[i] <= arr[j]){
                temp[k++] = arr[i++];
            }
            else{
                invCnt[0] += mid - i + 1;
                temp[k++] = arr[j++];
            }
        }
        
        while(i <= mid){
            temp[k++] = arr[i++];
        }
        
        while(j <= h){
            temp[k++] = arr[j++];
        }
        
        for(int z = l; z <= h; ++z){
            arr[z] = temp[z];
        }        
    }    
}
    
}
