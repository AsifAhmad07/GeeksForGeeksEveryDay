package 03-march-prblm;

public class largestNumberFormedFromAnArray {


    Name Of The Problem :- Largest Number formed from an Array


    POTD :- 03-march-2024


    Given an array of strings arr[] of length n representing non-negative integers, arrange them in a manner, such that, after concatanating them in order, it results in the largest possible number. Since the result may be very large, return it as a string.

Example 1:

Input: 
n = 5
arr[] =  {"3", "30", "34", "5", "9"}
Output: "9534330"
Explanation: 
Given numbers are  {"3", "30", "34", "5", "9"}, 
the arrangement "9534330" gives the largest value.
Example 2:

Input: 
n = 4
arr[] =  {"54", "546", "548", "60"}
Output: "6054854654"
Explanation: 
Given numbers are {"54", "546", "548", "60"}, the 
arrangement "6054854654" gives the largest value.
Your Task:  
You don't need to read input or print anything. Your task is to complete the function printLargest() which takes the array of strings arr[] as a parameter and returns a string denoting the answer.

Expected Time Complexity: O(n*log(n) ).
Expected Auxiliary Space: O(n).

Constraints:
1 ≤ n ≤ 105
0 ≤ arr[i] ≤ 1018
Sum of all the elements of the array is greater than 0.

-----------------------------------------------------------------------------------------------------------------------------------------------------


class Solution {
    String printLargest(int n, String[] arr) {
        // code here
        
      Arrays.sort(arr, new Comparator<String>(){
          @Override public int compare(String a , String b){
              String ab = a + b; 
              String ba = b + a;
              return ba.compareTo(ab);
          }
      });
        StringBuilder sb = new StringBuilder();
        for(String str:arr)
        sb.append(str);
        return sb.toString();
    }
}
    
}
