package 25-Feb-prblm;

public class histogramMaxRectangularArea {


    Name Of The Problem :- Histogram Max Rectangular Area

    POTD :- 25-February-2025

    You are given a histogram represented by an array arr, where each element of the array denotes the height of the bars in the histogram. All bars have the same width of 1 unit.

Your task is to find the largest rectangular area possible in the given histogram, where the rectangle can be formed using a number of contiguous bars.

Examples:

Input: arr[] = [60, 20, 50, 40, 10, 50, 60]
 Largest-Rectangular-Area-in-a-Histogram
Output: 100
Explanation: We get the maximum by picking bars highlighted above in green (50, and 60). The area is computed (smallest height) * (no. of the picked bars) = 50 * 2 = 100.
Input: arr[] = [3, 5, 1, 7, 5, 9]
Output: 15
Explanation:  We get the maximum by picking bars 7, 5 and 9. The area is computed (smallest height) * (no. of the picked bars) = 5 * 3 = 15.
Input: arr[] = [3]
Output: 3
Explanation: In this example the largest area would be 3 of height 3 and width 1.
Constraints:
1 ≤ arr.size() ≤ 105
0 ≤ arr[i] ≤ 104

*****************************************************************************************************************************************************

class Solution {
    public static int getMaxArea(int arr[]) {
        // your code here
        
          int n = arr.length;
        Stack<Integer> s = new Stack<>();
        int res = 0;
        int tp, curr;

        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                tp = s.pop();
                int width = s.isEmpty() ? i : i - s.peek() - 1;
                res = Math.max(res, arr[tp] * width);
            }
            s.push(i);
        }

       
        while (!s.isEmpty()) {
            tp = s.pop();
            curr = arr[tp] * (s.isEmpty() ? n : n - s.peek() - 1);
            res = Math.max(res, curr);
        }

        return res;
    }
}

    
}
