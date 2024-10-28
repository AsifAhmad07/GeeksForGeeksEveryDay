package 28-Oct-prblm;

public class removeduplicatesinarray {


    Name Of The Problem :- Remove duplicates in array

    POTD :- 28-October-2024

    Given an array arr consisting of positive integer numbers, remove all duplicate numbers.

Example:

Input: arr[] = [2, 2, 3, 3, 7, 5] 
Output: [2, 3, 7, 5]
Explanation: After removing the duplicates 2 and 3 we get 2 3 7 5.
Input: arr[] = [2, 2, 5, 5, 7, 7] 
Output: [2, 5, 7]
Input: arr[] = [8, 7] 
Output: [8, 7]
Constraints:
1<= arr.size() <=106
2<= arr[i] <=100


*****************************************************************************************************************************************************


class Solution {
    ArrayList<Integer> removeDuplicate(int arr[]) {
        // code here
         int mm[] = new int[101];
        Arrays.fill(mm,0);
        ArrayList<Integer> ans = new ArrayList<>();
        for(int x:arr){
            if(mm[x]==0){
                ans.add(x);
                mm[x]=1;
            }
        }
        return ans;
    }
}

    
}
