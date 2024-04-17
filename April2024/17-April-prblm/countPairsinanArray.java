package 17-April-prblm;

public class countPairsinanArray {


    Name Of The Problem :- Count Pairs in an Array

    POTD :- 17-April-2024

    Given an array arr of n integers, count all pairs (arr[i], arr[j]) in it such that i*arr[i] > j*arr[j] and 0 ≤ i < j < n.

Note: 0-based Indexing is followed.

Example 1:

Input :
n = 4
arr[] = {8, 4, 2, 1}
Output :
2
Explanation:
If we see the array after operations
[0*8, 1*4, 2*2, 3*1] => [0, 4, 4, 3]
Pairs which hold the condition i*arr[i] > j*arr[j] are (4,1) and (2,1), so in total 2 pairs are available.
Example 2:

Input :
n = 7
arr[] = {5, 0, 10, 2, 4, 1, 6}
Output:
5
Explanation :
Pairs which hold the condition i*arr[i] > j*arr[j] are (10,2), (10,4), (10,1), (2,1) and (4,1), so in total 5 pairs are there.
Your Task:  
You don't need to read input or print anything. Your task is to complete the function countPairs() which takes the array arr[] and its size n as inputs and returns the required result.

Expected Time Complexity: O(n*log(n))
Expected Auxiliary Space: O(n*log(n))

Constraints:
1 ≤ n ≤ 104
0 ≤ arr[i] ≤ 104

*****************************************************************************************************************************************************


class Solution {  
    static int countPairs(int arr[], int n) 
    {
      for (int i = 0; i < n; i++) 
            arr[i] = i * arr[i]; 
            
           return countInversion(arr, 0,n-1);
    }
      static int countInversion( int arr[]  , int l , int r)
        {
           
        int res = 0;
            if(l<r)
            {
                int  m = (l+r)/2;
                // count inversion in left half
                res  +=  countInversion(arr,l,m);
                // count inversion in right half.
                res  +=  countInversion(arr,m+1,r);
                // count inversion while merging left and right parts.
                res +=  countAndMerge(arr,l,m,r);
            }
            return  res;
        }
    
        static int countAndMerge(int arr[] , int l , int m , int r)
        {
            int n1 = m-l+1;
            int n2 = r-m;
            int left[] = new int [n1];
            int right[] = new int [n2];
            
            for( int i = 0 ;i <n1; i++){
                left[i]  = arr[l+i];
            }
            for( int i = 0 ;i <n2; i++){
                right[i]  = arr[m+1+i];
            }
           
         int ans = 0, i=0 , j=0, k=l;
            
            while(i<n1 && j<n2){
                if(left[i]<=right[j]){
                    arr[k] = left[i] ; i++;k++;
                }
                
                else{
                    arr[k] = right[j]; j++ ;k++ ; ans += (n1-i);
                }
            }
            
            while(i<n1){
                arr[k] =  left[i]; i++;k++;
            }
            while(i<n2){
                arr[k] =right[j]; j++ ;k++;
            }
            return ans;
        }
}
    
}
