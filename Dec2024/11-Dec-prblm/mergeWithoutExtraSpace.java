package 11-Dec-prblm;

public class mergeWithoutExtraSpace {


    Name Of The Problem :- Merge Without Extra Space


    POTD :- 11-December-2024

    Given two sorted arrays a[] and b[] of size n and m respectively, the task is to merge them in sorted order without using any extra space. Modify a[] so that it contains the first n elements and modify b[] so that it contains the last m elements.

Examples:

Input: a[] = [2, 4, 7, 10], b[] = [2, 3]
Output:
2 2 3 4
7 10
Explanation: After merging the two non-decreasing arrays, we get, 2 2 3 4 7 10
Input: a[] = [1, 5, 9, 10, 15, 20], b[] = [2, 3, 8, 13]
Output:
1 2 3 5 8 9
10 13 15 20
Explanation: After merging two sorted arrays we get 5 10 12 18 20.
Input: a[] = [0, 1], b[] = [2, 3]
Output:
0 1
2 3
Explanation: After merging two sorted arrays we get 0 1 2 3.
Constraints:
1 <= a.size(), b.size() <= 105
0 <= a[i], b[i] <= 107


*****************************************************************************************************************************************************

class Solution {
    // Function to merge the arrays.
    public void mergeArrays(int a[], int b[]) {
        // code here
        
          int n=a.length,m=b.length,i=n-1,j=0;
        while(i>=0 && j<m)
        {
            if(a[i]<=b[j])break;
            int temp = a[i];
            a[i--] = b[j];
            b[j++] = temp;
        }
        Arrays.sort(a);
        Arrays.sort(b);
    }
}

    
}
