package 04-Nov-prblm;

public class findAllTripletswithZeroSum {



    Name Of The Problem :- Find All Triplets with Zero Sum

    POTD :- 04-Novemeber-2024

    Given an array arr[], find all possible indices [i, j, k] of triplets [arr[i], arr[j], arr[k]] in the array whose sum is equal to zero. Return indices of triplets in any order and all the returned triplets indices should also be internally sorted, i.e., for any triplet indices [i, j, k], the condition i < j < k should hold.

Note: Try to solve this using the O(n2) approach.

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
        
        Set<List<Integer>> resSet = new HashSet<>();
        int n = arr.length;
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = arr[i] + arr[j];
                map.putIfAbsent(sum, new ArrayList<>());
                map.get(sum).add(new int[]{i, j});
            }
        }

        for (int i = 0; i < n; i++) {
            int rem = -arr[i];
            if (map.containsKey(rem)) {
                List<int[]> pairs = map.get(rem);
                for (int[] p : pairs) {
                    if (p[0] != i && p[1] != i) {
                        List<Integer> curr = Arrays.asList(i, p[0], p[1]);
                        Collections.sort(curr);
                        resSet.add(curr);
                    }
                }
            }
        }
        return new ArrayList<>(resSet);
    }
}
    
}
