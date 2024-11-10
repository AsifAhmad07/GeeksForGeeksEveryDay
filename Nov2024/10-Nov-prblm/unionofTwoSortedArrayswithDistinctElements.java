package 10-Nov-prblm;

public class unionofTwoSortedArrayswithDistinctElements {


    Name Of The Problem :- Union of Two Sorted Arrays with Distinct Elements

    POTD :- 10-Novemeber-2024

    Given two sorted arrays a[] and b[], where each array contains distinct elements , the task is to return the elements in the union of the two arrays in sorted order.

Union of two arrays can be defined as the set containing distinct common elements that are present in either of the arrays.
Examples:

Input: a[] = [1, 2, 3, 4, 5], b[] = [1, 2, 3, 6, 7]
Output: 1 2 3 4 5 6 7
Explanation: Distinct elements including both the arrays are: 1 2 3 4 5 6 7.
Input: a[] = [2, 3, 4, 5], b[] = [1, 2, 3, 4]
Output: 1 2 3 4 5
Explanation: Distinct elements including both the arrays are: 1 2 3 4 5.
Input: a[] = [1], b[] = [2]
Output: 1 2
Explanation: Distinct elements including both the arrays are: 1 2.
Constraints:
1  <=  a.size(), b.size()  <=  105
-109  <=  a[i] , b[i]  <=  109

*****************************************************************************************************************************************************

// User function Template for Java

// a,b : the arrays
class Solution {
    // Function to return a list containing the union of the two arrays.
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        // add your code here
        
         int i=0,j=0,n=a.length,m=b.length;
        ArrayList<Integer> ans = new ArrayList<>();
        while(i<n || j<m){
            int num1 = i<n?a[i]:Integer.MAX_VALUE;
            int num2 = j<m?b[j]:Integer.MAX_VALUE;
            if(num1<num2){
                ans.add(num1);
                i++;
            }
            else if(num2<num1){
                ans.add(num2);
                j++;
            }
            else{
                ans.add(num1);
                i++;
                j++;
            }
        }
        return ans;
    }
}

    
}
