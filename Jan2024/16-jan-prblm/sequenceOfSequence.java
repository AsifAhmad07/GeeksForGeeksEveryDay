package 16-jan-prblm;

public class sequenceOfSequence {

    /*
     * Name Of The Problem :- Sequence of Sequence
     * POTD :- 16-jan-2024
     * Given two integers m and n, try making a special sequence of numbers seq of length n such that

seqi+1 >= 2*seqi 
seqi > 0
seqi <= m
Your task is to determine total number of such special sequences possible.

Example 1:

Input: 
m = 10
n = 4
Output: 
4
Explaination: 
There should be n elements and 
value of last element should be at-most m. 
The sequences are {1, 2, 4, 8}, {1, 2, 4, 9}, 
{1, 2, 4, 10}, {1, 2, 5, 10}.
Example 2:

Input: 
m = 5
n = 2
Output: 
6
Explaination: 
The sequences are {1, 2}, 
{1, 3}, {1, 4}, {1, 5}, {2, 4}, {2, 5}.
Your Task:
You do not need to read input or print anything. Your task is to complete the function numberSequence() which takes the number m and n as input parameters and returns the number of possible special sequences.

Expected Time Complexity: O(m*n)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ m, n ≤ 100
     */
    //User function Template for Java

class Solution{
    static int numberSequence(int m, int n)
    {
        // code here
          List<List<Integer>> dp = new ArrayList<>();
        for (int i = 0; i < m + 1; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < n + 1; j++) {
                if (i == 0 || j == 0 || i < j) {
                    row.add(0);
                } else if (j == 1) {
                    row.add(i);
                } else {
                    row.add(dp.get(i - 1).get(j) + dp.get(i / 2).get(j - 1));
                }
            }
            dp.add(row);
        }
        return dp.get(m).get(n);
    }
}
    
}
