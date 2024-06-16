import java.util.jar.Attributes.Name;

package 16-june-pblm;

public class primePairwithTargetSum {


    Name Of The Problem :- Prime Pair with Target Sum

    POTD :- 16-June-2024

    Solve today's problem-> Be the comment of the day-> Win a GfG T-Shirt!
Daily rewards up for grabs!

banner
Given a number n, find out if n can be expressed as a+b, where both a and b are prime numbers. If such a pair exists, return the values of a and b, otherwise return [-1,-1] as an array of size 2.
Note: If [a, b] is one solution with a <= b, and [c, d] is another solution with c <= d, and a < c then  [a, b] is considered as our answer.

Examples

Input: n = 10
Output: 3 7
Explanation: There are two possiblities 3, 7 & 5, 5 are both prime & their sum is 10, but we'll pick 3, 7 as 3 < 5.
Input: n = 3
Output: -1 -1
Explanation: There are no solutions to the number 3.
Expected Time Complexity: O(n*loglog(n))
Expected Auxiliary Space: O(n)

Constraints:
2 <= n <= 106

*****************************************************************************************************************************************************Auxiliary

class Solution {
    public static ArrayList<Integer> getPrimes(int n) {
       // code here
        boolean prime[] = new boolean[n + 1];
       Arrays.fill(prime, true);
       prime[0] = false;
       prime[1] = false;
       ArrayList<Integer> ans = new ArrayList<Integer>();
       
       // Implementing Sieve of Eratosthenes to find all prime numbers up to n
       for (int i = 2; i * i <= n; i++) {
           if (prime[i]) {
               for (int j = i * i; j <= n; j += i)
                   prime[j] = false;
           }
       }
       
       // Finding two primes that sum up to n
       for (int i = 2; i <= n; i++) {
           if (prime[i] && prime[n - i]) {
               ans.add(i);
               ans.add(n - i);
               return ans;
           }
       }
       
       // If no such pair is found, return -1, -1
       ans.add(-1);
       ans.add(-1);
       return ans;
   }
}
    
}
