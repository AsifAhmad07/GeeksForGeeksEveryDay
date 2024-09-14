package 14-Sept-prblm;

public class alternatepositiveandnegativenumbers {
    
    Name Of The Problem :- Alternate positive and negative numbers

    POTD :- 14-September-2024

    Given an unsorted array arr containing both positive and negative numbers. Your task is to create an array of alternate positive and negative numbers without changing the relative order of positive and negative numbers.
Note: Array should start with a positive number and 0 (zero) should be considered a positive element.

Examples:

Input: arr[] = [9, 4, -2, -1, 5, 0, -5, -3, 2]
Output: 9 -2 4 -1 5 -5 0 -3 2
Explanation: Positive elements : [9,4,5,0,2]
Negative elements : [-2,-1,-5,-3]
As we need to maintain the relative order of postive elements and negative elements we will pick each element from the positive and negative and will store them. If any of the positive and negative numbersare completed. we will continue with the remaining signed elements.
The output is 9,-2,4,-1,5,-5,0,-3,2.
Input: arr[] = [-5, -2, 5, 2, 4, 7, 1, 8, 0, -8]
Output: 5 -5 2 -2 4 -8 7 1 8 0
Explanation : Positive elements : [5,2,4,7,1,8,0]
Negative elements : [-5,-2,-8]
The output is 5, -5, 2, -2, 4, -8, 7, 1, 8, 0.
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(n)

Constraints:
1 ≤ arr.size() ≤ 107
-106 ≤ arr[i] ≤ 107

*****************************************************************************************************************************************************

class Solution {
    void rearrange(ArrayList<Integer> arr) {
        // code here
         ArrayList<Integer> positive = new ArrayList<>();
        ArrayList<Integer> negative = new ArrayList<>();
        for(int x:arr){
            if(x>=0)positive.add(x);
            else negative.add(x);
        }
        int i=0,j=0,k=0;
        while(i<positive.size() && j<negative.size()){
            if(k%2==1)arr.set(k++,negative.get(j++));
            else arr.set(k++,positive.get(i++));
        }
        while(i<positive.size())arr.set(k++,positive.get(i++));
        while(j<negative.size())arr.set(k++,negative.get(j++));
    }
}
}
