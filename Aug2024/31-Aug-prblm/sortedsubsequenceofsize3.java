package 31-Aug-prblm;

public class sortedsubsequenceofsize3 {


    Name Of The Problem :- Sorted subsequence of size 3

    POTD :- 31-August-2024

    You are given an array arr, you need to find any three elements in it such that arr[i] < arr[j] < arr[k] and i < j < k.

Note:

The output will be 1 if the subsequence returned by the function is present in the array arr
If the subsequence is not present in the array then return an empty array, the driver code will print 0.
If the subsequence returned by the function is not in the format as mentioned then the output will be -1.
Examples :

Input: arr = [1, 2, 1, 1, 3]
Output: 1
Explanation: A subsequence 1 2 3 exist.
Input: arr = [1, 1, 3]
Output: 0
Explanation: No such Subsequence exist, so empty array is returned (the driver code automatically prints 0 in this case).
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(n)

Constraints:
1 <= arr.size() <= 105
1 <= arr[i] <= 106


*****************************************************************************************************************************************************
class Solution {
    // Function to find three numbers such that arr[smaller[i]] < arr[i] <
    // arr[greater[i]]
    public List<Integer> find3Numbers(int[] arr) {
        // code here
         int n = arr.length;
        List<Integer> ans = new ArrayList<>();
        int leftSmall[] = new int[n];
        int rightLarge[] = new int[n];
        leftSmall[0]=arr[0];
        for(int i=1;i<n;i++)leftSmall[i]=Math.min(arr[i],leftSmall[i-1]);
        rightLarge[n-1]=arr[n-1];
        for(int i=n-2;i>=0;i--)rightLarge[i]=Math.max(arr[i],rightLarge[i+1]);
        for(int i=1;i<=n-2;i++){
            if(leftSmall[i-1]<arr[i] && arr[i]<rightLarge[i+1]){
                ans.add(leftSmall[i-1]);
                ans.add(arr[i]);
                ans.add(rightLarge[i+1]);
                break;
            }
        }
        return ans;
    }
}
    
}
