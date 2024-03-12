package 12-march-prblm;

public class generalisedFibonacciNumber {


    Name Of The Problem :- Generalised Fibonacci numbers


    POTD :- 12-march-2024


    Consider the generalized Fibonacci number g, which is dependent on a, b and c as follows :-
g(1) = 1, g(2) = 1. For any other number n, g(n) = a*g(n-1) + b*g(n-2) + c.

For a given value of m, determine g(n)%m.

Example 1:

Input:
a = 3
b = 3
c = 3
n = 3
m = 5
Output:
4
Explanation:
g(1) = 1 and g(2) = 1 
g(3) = 3*g(2) + 3*g(1) + 3 = 3*1 + 3*1 + 3 = 9
We need to return answer modulo 5, so 9%5 = 4, is the answer.
Example 2:

Input:
a = 2
b = 2
c = 2
n = 4
m = 100
Output:
16
Explanation:
g(1) = 1 and g(2) = 1
g(3) = 2*g(2) + 2*g(1) + 2 = 2*1 + 2*1 + 2 = 6
g(4) = 2*g(3) + 2*g(2) + 2  = 2*6 + 2*1 + 2 = 16
We need to return answer modulo 100, so 16%100 = 16, is the answer.
Your Task:
You don't need to read input or print anything. Your task is to complete the function genFibNum() which takes 5 Integers a, b, c, n, and m as input and returns g(n)%m.

Expected Time Complexity: O( log(n) ).
Expected Auxiliary Space: O(1).

Constraints:
1 <= a, b, c, n, m <= 109+7

-----------------------------------------------------------------------------------------------------------------------------------------------------



class Solution {
    static long mat[][], M[][];
    static long m;

    static long genFibNum(long a, long b, long c, long n, long mod) {
        m = mod;
        mat = new long[][]{{a, b, 1}, {1, 0, 0}, {0, 0, 1}};
        M = new long[][]{{a, b, 1}, {1, 0, 0}, {0, 0, 1}};

        if (n <= 2) {
            return 1 % m;
        } else {
            power(mat, n - 2);
            return (mat[0][0] + mat[0][1] + c * mat[0][2]) % m;
        }
    }

    static void multiply(long F[][], long M[][]) {

        long result[][] = new long[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    result[i][j] += (F[i][k] * M[k][j]) % m;
                    result[i][j] %= m;
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                F[i][j] = result[i][j];
            }
        }
    }

    static void power(long F[][], long n) {
        if (n == 0 || n == 1)
            return;

        power(F, n / 2);
        multiply(F, F);

        if (n % 2 != 0)
            multiply(F, M);
    }
}
    
}
