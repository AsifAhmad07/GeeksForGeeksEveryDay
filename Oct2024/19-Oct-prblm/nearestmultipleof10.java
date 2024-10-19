package 19-Oct-prblm;

public class nearestmultipleof10 {


    Name Of The Problem :- Nearest multiple of 10


    POTD :- 19-October-2024

    A string str is given to represent a positive number. The task is to round str to the nearest multiple of 10.  If you have two multiples equally apart from str, choose the smallest element among them.

Examples:

Input: str = 29 
Output: 30
Explanation: Close multiples are 20 and 30, and 30 is the nearest to 29. 
Input: str = 15
Output: 10
Explanation: 10 and 20 are equally distant multiples from 20. The smallest of the two is 10.
Expected Time Complexity: O(n).
Expected Auxiliary Space: O(1).

Constraints:
1 <= str.size()<= 105

*****************************************************************************************************************************************************

class Solution {

    String roundToNearest(String str) {
        // Complete the function
        int n = str.length()-1;
        char temp[] = str.toCharArray();
        if(temp[n]<='5'){
            temp[n]='0';
            return new String(temp);
        }
        temp[n]='0';
        n--;
        while(n>=0 && temp[n]=='9'){
            temp[n]='0';
            n--;
        }
        if(n==-1)return '1' + new String(temp);
        temp[n]+=1;
        return new String(temp);
    }
}

    
}
