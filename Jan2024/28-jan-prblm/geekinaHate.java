package 28-jan-prblm;

public class geekinaHate {

    Name Of The Problem :- Geekina Hate 1s

    Date :- 28-jan-2024

    It is a universal fact that Geekina hates 1s however it is also known that Geekina loves the integers having atmost k 1s (set-bits) in their binary representation. 

Geekina demanded nth such non-negative number from Geek, and being a good friend of Geek, now it's your responsibility to tell him that number.

Note: The test cases are generated such that the answer always exists and will fit in the 64-bit data type.

Example 1:

Input:
n = 5
k = 1
Output:
8
Explanation:
Following numbers are loved by Geekina -
0 = (0)2
1 = (1)2
2 = (10)2
4 = (100)2
8 = (1000)2
Example 2:

Input:
n = 6
k = 2
Output:
5
Explanation:
Following numbers are loved by Geekina -
0 = (0)2
1 = (1)2
2 = (10)2
3 = (11)2
4 = (100)2
5 = (101)2
Your Task:
This is a function problem. The input is already taken care of by the driver code. You only need to complete the function findNthNumer() that takes n and k as input parameters. Return the nth number having at most k set-bits.

Expected Time Complexity: O(k*log(n) + constant)
Expected Auxiliary Space: O(k*log(n) + constant)

Constraints:
1 <= n <= 109
1 <= k <= 63

-----------------------------------------------------------------------------------


class Solution{
    public long findNthNumer(int n, int k){
        // Code Here.
         long low = 0, high = (long)(1e18);
        dp = new Long[2][65][65];
        while(low <= high){
            long mid = low + (high - low) / 2;
            long count = find(mid, k);
            if(count >= n)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return low;
    }
    private long find(long n, int k){
        char s[] = Long.toBinaryString(n).toCharArray();
        reset();
        return dp(s, s.length, 1, k);
    }
    private long dp(char s[], int n, int tight, int k){
        if(k < 0)
            return 0;
        if(n == 0){
            return 1;
        }
        if(dp[tight][k][n] != null)
            return dp[tight][k][n];
        int ub = (tight == 1 ? (int)(s[s.length - n] - '0') : 1);
        long ans = 0;
        for(int dig = 0; dig <= ub; dig++){
            if(dig == ub)
                ans += dp(s, n - 1, tight, k - dig);
            else
                ans += dp(s, n - 1, 0, k - dig);
        }
        return dp[tight][k][n] = ans;
    }
    private void reset(){
        for(int i = 0; i < 65; i++){
            Arrays.fill(dp[0][i], null);
            Arrays.fill(dp[1][i], null);
        }
    }
    private Long dp[][][];
    
}

    
}
