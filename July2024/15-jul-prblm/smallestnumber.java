package 15-jul-prblm;

public class smallestnumber {

    Name Of The Problem :- Smallest number

    POTD :- 15-July-2024

    Given two integers s and d. The task is to find the smallest number such that the sum of its digits is s and the number of digits in the number are d. Return a string that is the smallest possible number. If it is not possible then return -1.

Examples:

Input: s = 9, d = 2
Output: 18 
Explanation: 18 is the smallest number possible with the sum of digits = 9 and total digits = 2.
Input: s = 20, d = 3 
Output: 299 
Explanation: 299 is the smallest number possible with the sum of digits = 20 and total digits = 3.
Expected Time Complexity: O(d)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ s ≤ 100
1 ≤ d ≤ 6

*****************************************************************************************************************************************************



class Solution {
    public String smallestNumber(int s, int d) {
        // code here
        StringBuilder ans = new StringBuilder();
        int i=1;
        while(i<=d){
            int num = s-(d-i)*9<=0?0:s-(d-i)*9;
            if(num>9)return "-1";
            if(i==1 && num==0)num=1;
            ans.append((char)(num+'0'));
            s-=num;
            i++;
        }
        return ans.toString();
    }
}

    
}
