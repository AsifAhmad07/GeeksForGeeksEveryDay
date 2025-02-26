package 26-Feb-prblm;

public class maximumofminimumforeverywindowsize {


    Name Of The Problem :- Maximum of minimum for every window size

    POTD :- 26-February-2026

    Given an array of integers arr[], the task is to find the maximum of the minimum values for every possible window size in the array, where the window size ranges from 1 to arr.size().

More formally, for each window size k, determine the smallest element in all windows of size k, and then find the largest value among these minimums where 1<=k<=arr.size().

Examples :

Input: arr[] = [10, 20, 30, 50, 10, 70, 30]
Output: [70, 30, 20, 10, 10, 10, 10] 
Explanation: 
1. First element in output indicates maximum of minimums of all windows of size 1. Minimums of windows of size 1 are [10], [20], [30], [50], [10], [70] and [30]. Maximum of these minimums is 70. 
2. Second element in output indicates maximum of minimums of all windows of size 2. Minimums of windows of size 2 are [10], [20], [30], [10], [10], and [30]. Maximum of these minimums is 30. 
3. Third element in output indicates maximum of minimums of all windows of size 3. Minimums of windows of size 3 are [10], [20], [10], [10] and [10]. Maximum of these minimums is 20. 
Similarly other elements of output are computed.
Input: arr[] = [10, 20, 30]
Output: [30, 20, 10]
Explanation: First element in output indicates maximum of minimums of all windows of size 1. Minimums of windows of size 1 are [10] , [20] , [30]. Maximum of these minimums are 30 and similarly other outputs can be computed
Constraints:
1 <= arr.size() <= 105
1 <= arr[i] <= 106

*****************************************************************************************************************************************************

class Solution {
    public ArrayList<Integer> maxOfMins(int[] arr) {
        // Your code here
        
          int n = arr.length;
        int[] tempRes = new int[n];
        int[] len = new int[n];
        Stack<Integer> s = new Stack<>();

        // Traverse through array to determine window sizes using a stack
        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                int top = s.pop();
                int windowSize = s.isEmpty() ? i : i - s.peek() - 1;
                len[top] = windowSize;
            }
            s.push(i);
        }

       
        while (!s.isEmpty()) {
            int top = s.pop();
            int windowSize = s.isEmpty() ? n : n - s.peek() - 1;
            len[top] = windowSize;
        }

        for (int i = 0; i < n; i++) {
            int windowSize = len[i] - 1; 
            tempRes[windowSize] = Math.max(tempRes[windowSize], arr[i]);
        }
        for (int i = n - 2; i >= 0; i--) {
            tempRes[i] = Math.max(tempRes[i], tempRes[i + 1]);
        }

    
        ArrayList<Integer> res = new ArrayList<>();
        for (int value : tempRes) {
            res.add(value);
        }
        
        return res;
    }
}
    
}
