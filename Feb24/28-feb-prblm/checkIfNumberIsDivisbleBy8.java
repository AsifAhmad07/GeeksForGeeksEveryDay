package 28-feb-prblm;

public class checkIfNumberIsDivisbleBy8 {


    Name Of The Problem :- Check if a number is divisible by 8

    POTD :- 28-feb-2024


    Given a string representation of a decimal number s, check whether it is divisible by 8.

Example 1:

Input:
s = "16"
Output:
1
Explanation:
The given number is divisible by 8,
so the driver code prints 1 as the output.
Example 2:

Input:
s = "54141111648421214584416464555"
Output:
-1
Explanation:
Given Number is not divisible by 8, 
so the driver code prints -1 as the output.
Your Task:
You don't need to read input or print anything.Your task is to complete the function DivisibleByEight() which takes a string s as the input and returns 1 if the number is divisible by 8, else it returns -1.

Expected Time Complexity: O(1).
Expected Auxillary Space: O(1).

Constraints:
1 <= Number represented by the string s < 106



-----------------------------------------------------------------------------------------------------------------------------------------------------



class Solution{
    int DivisibleByEight(String s){
        //code here
        
         int n = s.length();
        if (n < 3) {
            while (n < 3) {
                s = '0' + s;
                n++;
            }
        }

        // Our length is greater than or equal to 3
        int number = 0;
        for (int i = n - 3; i <= n - 1; i++) {
            number = number * 10 + (s.charAt(i) - '0');
        }
        if (number % 8 == 0) {
            return 1;
        } else {
            return -1;
        }
    }
}
    
}
