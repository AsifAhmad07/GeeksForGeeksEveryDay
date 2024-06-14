package 14-june-prblm;

public class armstrongNumbers {


    Name Of The Problem :- Armstrong Numbers


    POTD :- 14-June-2024

    You are given a 3-digit number n, Find whether it is an Armstrong number or not.

    An Armstrong number of three digits is a number such that the sum of the cubes of its digits is equal to the number itself. 371 is an Armstrong number since 33 + 73 + 13 = 371. 
    
    Note: Return "true" if it is an Armstrong number else return "false".
    
    Examples
    
    Input: n = 153
    Output: true
    Explanation: 153 is an Armstrong number since 13 + 53 + 33 = 153. Hence answer is "true".
    Input: n = 372
    Output: false
    Explanation: 372 is not an Armstrong number since 33 + 73 + 23 = 378. Hence answer is "false".
    Expected Time Complexity: O(1)
    Expected Auxiliary Space: O(1) 
    
    Constraints:
    100 ≤ n <1000 

    *************************************************************************************************************************************************


    class Solution {
        static String armstrongNumber(int n) {
            // code here
             int num=0,temp=n;
            while(temp!=0){
                int digit=temp%10;
                num+=digit*digit*digit;
                temp/=10;
            }
            return num==n?"true":"false";
        }
    }
    
}
