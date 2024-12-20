package 18-Dec-prblm;

public class allocateMinimumPages {

    Name Of The Problem :- Allocate Minimum Pages


    POTD :- 18-December-2024

    You are given an array arr[] of integers, where each element arr[i] represents the number of pages in the ith book. You also have an integer k representing the number of students. The task is to allocate books to each student such that:

Each student receives atleast one book.
Each student is assigned a contiguous sequence of books.
No book is assigned to more than one student.
The objective is to minimize the maximum number of pages assigned to any student. In other words, out of all possible allocations, find the arrangement where the student who receives the most pages still has the smallest possible maximum.

Note: Return -1 if a valid assignment is not possible, and allotment should be in contiguous order (see the explanation for better understanding).

Examples:

Input: arr[] = [12, 34, 67, 90], k = 2
Output: 113
Explanation: Allocation can be done in following ways:
[12] and [34, 67, 90] Maximum Pages = 191
[12, 34] and [67, 90] Maximum Pages = 157
[12, 34, 67] and [90] Maximum Pages = 113.
Therefore, the minimum of these cases is 113, which is selected as the output.
Input: arr[] = [15, 17, 20], k = 5
Output: -1
Explanation: Allocation can not be done.
Input: arr[] = [22, 23, 67], k = 1
Output: 112
Constraints:
1 <=  arr.size() <= 106
1 <= arr[i] <= 103
1 <= k <= 103 

*****************************************************************************************************************************************************

class Solution {
    
    static boolean isPossible(int arr[],int k,int mid){
       int sum=0,student=1;
       for(int x:arr){
           sum+=x;
           if(sum>mid){
               student++;
               sum=x;
           }
       }
       return student<=k;
   }
   public static int findPages(int[] arr, int k) {
       // code here
       
        if(k>arr.length)return -1;
       int sum = 0,mx=Integer.MIN_VALUE;
       for(int x:arr){
           sum+=x;
           mx=Math.max(mx,x);
       }
       int low=mx,high=sum,mid,ans=Integer.MAX_VALUE;
       while(low<=high){
           mid=(low+high)/2;
           if(isPossible(arr,k,mid)){
               high=mid-1;
               ans=Math.min(ans,mid);
           }
           else low=mid+1;
       }
       return ans;
   }
}
    
}
