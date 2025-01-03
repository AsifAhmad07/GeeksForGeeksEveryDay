package 30-dec-prblm;

public class unionofArrayswithDuplicates {

    Na,e Of The Problem :- Union of Arrays with Duplicates

    POTD :- 30-December-2024


    Given two arrays a[] and b[], the task is to find the number of elements in the union between these two arrays.

The Union of the two arrays can be defined as the set containing distinct elements from both arrays. If there are repetitions, then only one element occurrence should be there in the union.

Note: Elements of a[] and b[] are not necessarily distinct.

Examples

Input: a[] = [1, 2, 3, 4, 5], b[] = [1, 2, 3]
Output: 5
Explanation: Union set of both the arrays will be 1, 2, 3, 4 and 5. So count is 5.
Input: a[] = [85, 25, 1, 32, 54, 6], b[] = [85, 2] 
Output: 7
Explanation: Union set of both the arrays will be 85, 25, 1, 32, 54, 6, and 2. So count is 7.
Input: a[] = [1, 2, 1, 1, 2], b[] = [2, 2, 1, 2, 1] 
Output: 2
Explanation: We need to consider only distinct. So count of elements in union set will be 2.
Constraints:
1 ≤ a.size(), b.size() ≤ 106
0 ≤ a[i], b[i] ≤ 105


*****************************************************************************************************************************************************

class Solution {
    public static int findUnion(int a[], int b[]) {
        // code here
        
         int ans=0;
        HashMap<Integer,Integer> mm = new HashMap<>();
        for(int x:a){
            if(mm.get(x)==null)ans++;
            mm.put(x,1);
        }
        for(int x:b){
            if(mm.get(x)==null)ans++;
            mm.put(x,1);
        }
        return ans;
    }
}
    
}