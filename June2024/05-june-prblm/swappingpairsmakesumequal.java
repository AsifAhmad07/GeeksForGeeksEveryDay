package 05-june-prblm;

public class swappingpairsmakesumequal {


    Name Of The Problem :- Swapping pairs make sum equal

    POTD :- 05-June-2024

    Given two arrays of integers a[] and b[] of size n and m, the task is to check if a pair of values (one value from each array) exists such that swapping the elements of the pair will make the sum of two arrays equal.

Note: Return 1 if there exists any such pair otherwise return -1.

Example 1:

Input: n = 6, m = 4, a[] = {4, 1, 2, 1, 1, 2}, b[] = (3, 6, 3, 3)
Output: 1
Explanation: Sum of elements in a[] = 11, Sum of elements in b[] = 15, To get same sum from both arrays, we can swap following values: 1 from a[] and 3 from b[]
Example 2:

Input: n = 4, m = 4, a[] = {5, 7, 4, 6}, b[] = {1, 2, 3, 8}
Output: 1
Explanation: We can swap 6 from array a[] and 2 from array b[]
Expected Time Complexity: O(mlogm+nlogn).
Expected Auxiliary Space: O(1).

Constraints:
1 ≤ n, m ≤ 106
0 <= a[i], b[i] <= 105

*****************************************************************************************************************************************************Auxiliary


class Solution {
    long findSwapValues(long a[], int n, long b[], int m) {
        // Your code goes here
         long suma = 0, sumb = 0;
        
        // Calculate sum of elements in array a
        for (int i = 0; i < n; i++) suma += a[i];
        
        // Calculate sum of elements in array b
        for (int i = 0; i < m; i++) sumb += b[i];
        
        // Check if the difference between sums is even
        if ((suma - sumb) % 2 != 0) return -1;
        
        long target = (suma - sumb) / 2;
        
        // Sort both arrays
        Arrays.sort(a);
        Arrays.sort(b);
        
        int i = 0, j = 0;
        
        // Use two pointers to find the target swap values
        while (i < n && j < m) {
            long diff = a[i] - b[j];
            if (diff == target) return 1;
            else if (diff < target) i++;
            else j++;
        }
        
        return -1;
    }
}

    
}
