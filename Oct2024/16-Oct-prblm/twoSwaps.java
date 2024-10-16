package 16-Oct-prblm;

public class twoSwaps {


    Name Of The Problem :- Two Swaps


    POTD :- 16-October-2024


    Given a permutation of some of the first natural numbers in an array arr[], determine if the array can be sorted in exactly two swaps. A swap can involve the same pair of indices twice.

Return true if it is possible to sort the array with exactly two swaps, otherwise return false.

Examples:

Input: arr = [4, 3, 2, 1]
Output: true
Explanation: First, swap arr[0] and arr[3]. The array becomes [1, 3, 2, 4]. Then, swap arr[1] and arr[2]. The array becomes [1, 2, 3, 4], which is sorted.
Input: arr = [4, 3, 1, 2]
Output: false
Explanation: It is not possible to sort the array with exactly two swaps.
Constraints:
1 ≤ arr.size() ≤ 106
1 ≤ arr[i] ≤ arr.size()


*****************************************************************************************************************************************************


class Solution {

    public boolean checkSorted(List<Integer> arr) {
        // code here
        int count=0;
        boolean isSorted = true;

        for (int i = 0; i < arr.size() - 1; i++) {
            if (arr.get(i) > arr.get(i + 1)) {
                isSorted = false;
                break;
            }
        }
        
        if(isSorted) return true;
        //then check if takes exanctly two swaps
        int swap=0;
         for(int i=0;i<arr.size()-1;i++){
              int min=i;
              for(int j=i+1;j<arr.size();j++){
                   if(arr.get(j) < arr.get(min)){
                        min=j;
                   }
              }
              
              //now swap
             if (min != i) {
                Collections.swap(arr, i, min);
                swap++;
            }
            
             if (swap > 2) {
                return false;
            }
               
         }
         
        
         
          return swap==2;
    }
}
    
}
