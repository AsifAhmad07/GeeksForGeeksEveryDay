package 28-Dec-prblm;

public class findAllTripletswithZeroSum {


    Name Of The Problem :- Find All Triplets with Zero Sum

    POTD :- 28-December-2024



    Given an array arr[], find all possible triplets i, j, k in the arr[] whose sum of elements is equals to zero. 
Returned triplet should also be internally sorted i.e. i<j<k.

Examples:

Input: arr[] = [0, -1, 2, -3, 1]
Output: [[0, 1, 4], [2, 3, 4]]
Explanation: Triplets with sum 0 are:
arr[0] + arr[1] + arr[4] = 0 + (-1) + 1 = 0
arr[2] + arr[3] + arr[4] = 2 + (-3) + 1 = 0
Input: arr[] = [1, -2, 1, 0, 5]
Output: [[0, 1, 2]]
Explanation: Only triplet which satisfies the condition is arr[0] + arr[1] + arr[2] = 1 + (-2) + 1 = 0
Input: arr[] = [2, 3, 1, 0, 5]
Output: [[]]
Explanation: There is no triplet with sum 0.
Constraints:
3 <= arr.size() <= 103
-104 <= arr[i] <= 104


*****************************************************************************************************************************************************

class Solution {
    public List<List<Integer>> findTriplets(int[] arr) {
        // Your code here
        
         int n = arr.length;
        List<List<Integer>> ans = new ArrayList<>();
        HashMap<Integer,ArrayList<Integer>> mm = new HashMap<>();
        for(int i=0;i<n;i++){
            mm.putIfAbsent(arr[i],new ArrayList<Integer>());
            mm.get(arr[i]).add(i);
        }
        for(int i=0;i<n-2;i++){
            for(int j=i+1;j<n-1;j++){
                int rem = 0-(arr[i]+arr[j]);
                if(mm.get(rem)!=null){
                    int size=mm.get(rem).size();
                    for(int k=size-1;k>=0;k--){
                        if(mm.get(rem).get(k)<=j)break;
                        ans.add(new ArrayList<>(List.of(i,j,mm.get(rem).get(k))));
                    }
                }
            }
        }
        Collections.sort(ans,(o1, o2) -> o1.get(2).compareTo(o2.get(2)));
        return ans;
    }
}
    
}
