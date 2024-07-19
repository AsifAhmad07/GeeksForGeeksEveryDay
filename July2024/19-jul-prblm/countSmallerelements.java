package 19-jul-prblm;

public class countSmallerelements {

    Name Of The Problem :- Count Smaller elements

    POTD :- 19-July-2024


    Given an array arr containing non-negative integers. Count and return an array ans where ans[i] denotes the number of smaller elements on right side of arr[i].

Examples:

Input: arr[] = [12, 1, 2, 3, 0, 11, 4]
Output: [6, 1, 1, 1, 0, 1, 0]
Explanation: There are 6 smaller elements right after 12. There is 1 smaller element right after 1. And so on.
Input: arr[] = [1, 2, 3, 4, 5]
Output: [0, 0, 0, 0, 0]
Explanation: There are 0 smaller elements right after 1. There are 0 smaller elements right after 2. And so on.
Expected Time Complexity: O(n*logn)
Expected Auxiliary Space: O(n)

Constraints:
1 ≤ arr.size() ≤ 106
0 ≤ arr[i]  ≤ 108

*****************************************************************************************************************************************************


// User function Template for Java

class Solution {
    int binarySearch(ArrayList<Integer> temp,int element){
       int index=-1;
       int low=0,high=temp.size()-1,mid;
       while(low<=high){
           mid=(low+high)/2;
           if(temp.get(mid)==element){
               index=mid;
               high=mid-1;
           }
           else if(temp.get(mid)>element) high=mid-1;
           else low=mid+1;
       }
       return index;
   }
   int[] constructLowerArray(int[] arr) {
       // code here
        int ans[] = new int[arr.length];
       ArrayList<Integer> temp = new ArrayList<>();
       for(int i=0;i<arr.length;i++)temp.add(arr[i]);
       Collections.sort(temp);
       for(int i=0;i<arr.length;i++){
           int index = binarySearch(temp,arr[i]);
           ans[i]=index;
           temp.remove(index);
       }
       return ans;
   

   }
}
    
}
