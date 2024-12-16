import java.util.Base64.Decoder;

package 16-Dec-prblm;

public class k-thelementoftwoArrays {

    Name Of The Problem :- K-th element of two Arrays

    POTD :- 16-December-2024

    Given two sorted arrays a[] and b[] and an element k, the task is to find the element that would be at the kth position of the combined sorted array.

Examples :

Input: a[] = [2, 3, 6, 7, 9], b[] = [1, 4, 8, 10], k = 5
Output: 6
Explanation: The final combined sorted array would be [1, 2, 3, 4, 6, 7, 8, 9, 10]. The 5th element of this array is 6.
Input: a[] = [100, 112, 256, 349, 770], b[] = [72, 86, 113, 119, 265, 445, 892], k = 7
Output: 256
Explanation: Combined sorted array is [72, 86, 100, 112, 113, 119, 256, 265, 349, 445, 770, 892]. The 7th element of this array is 256.
Constraints:

1 <= a.size(), b.size() <= 106
1 <= k <= a.size() + b.size()
0 <= a[i], b[i] < 108


*****************************************************************************************************************************************************


class Solution {
    public int kthElement(int arr1[], int arr2[], int k) {
        // code here
        
         int n1 = arr1.length, n2 = arr2.length;
        
        if (k == n1 + n2) return Math.max(arr1[n1 - 1], arr2[n2 - 1]);
        if (k == 1) return Math.min(arr1[0], arr2[0]);
        
        int i = 0, j = 0;
        while (i < n1 && j < n2 && k > 1) {
            if (arr1[i] <= arr2[j]) {
                i++;
            } else {
                j++;
            }
            k--;
        }
        
        while (i < n1 && k > 1) {
            i++;
            k--;
        }
        
        while (j < n2 && k > 1) {
            j++;
            k--;
        }
        
        if (i == n1) return arr2[j];
        else if (j == n2) return arr1[i];
        return Math.min(arr1[i], arr2[j]);
    }
}
    
}
