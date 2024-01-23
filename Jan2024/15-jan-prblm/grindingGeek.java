package 15-jan-prblm;

public class grindingGeek {
    /*
     * Name Of The Problem :- Grinding Geek
     * POTD :- 15-01-2024
     * 
     * GeeksforGeeks has introduced a special offer where you can enroll in any course, and if you manage to complete 90% of the course within 90 days, you will receive a refund of 90%.

Geek was fascinated by this offer. This offer was valid for only n days, and each day a new course was available for purchase. Geek decided that if he bought a course on some day, he will complete that course on the same day itself and redeem floor[90% of cost of the course] amount back. Find the maximum number of courses that Geek can complete in those n days if he had total amount initially.

Note: On any day, Geek can only buy the new course that was made available for purchase that day.

Example 1:

Input:
n = 2
total = 10
cost = [10, 9]
Output: 2
Explanation: 
Geek can buy the first course for 10 amount, 
complete it on the same date and redeem 9 back. 
Next, he can buy and complete the 2nd course too.
Example 2:

Input:
n = 11
total = 10
cost = [10, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]
Output: 10
Explanation: 
Geek can buy and complete all the courses that cost 1.
Your Task:
This is a function problem. The input is already taken care of by the driver code. You only need to complete the function max_courses() that takes N the number of days, the total amount, and the cost array as input argument and return the maximum amount of courses that could be purchased.

Expected Time Complexity: O(n*total)
Expected Auxiliary Space: O(n*total)

Constraints:
1 <= n <= 1000
0 <= total <= 1000
1 <= cost[i] <= 1000


     * 
     */
    List<List<Integer>> dp = new ArrayList<>();
    for (int i = 0; i <= n; i++) {
        List<Integer> row = new ArrayList<>();
        for (int j = 0; j <= total; j++) {
            row.add(-1);
        }
        dp.add(row);
    }
    for (int i = n; i >= 0; i--) {
        for (int j = 0; j <= total; j++) {
            if (i == n || j == 0) {
                dp.get(i).set(j, 0);
            } else {
                dp.get(i).set(j, dp.get(i + 1).get(j));
                if (j >= cost[i]) {
                    dp.get(i).set(j, Math.max(dp.get(i).get(j), 1 + dp.get(i + 1).get(j - cost[i] + (9 * cost[i] / 10))));
                }
            }
        }
    }
    return dp.get(0).get(total);
    
}
