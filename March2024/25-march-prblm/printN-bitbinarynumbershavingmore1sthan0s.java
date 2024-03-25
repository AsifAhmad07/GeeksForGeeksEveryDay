package 25-march-prblm;

public class printN-bitbinarynumbershavingmore1sthan0s {


    Name Of The Problem :- Print N-bit binary numbers having more 1s than 0s


    POTD :- 25-march-2024

    Given a positive integer n. Your task is to generate a string list of all n-bit binary numbers where, for any prefix of the number, there are more or an equal number of 1's than 0's. The numbers should be sorted in decreasing order of magnitude.

Example 1:

Input:  
n = 2
Output: 
"11, 10"
Explanation: Valid numbers are those where each prefix has more 1s than 0s:
11: all its prefixes (1 and 11) have more 1s than 0s.
10: all its prefixes (1 and 10) have more 1s than 0s.
So, the output is "11, 10".
Example 2:

Input:  
n = 3
Output: 
"111, 110, 101"
Explanation: Valid numbers are those where each prefix has more 1s than 0s.
111: all its prefixes (1, 11, and 111) have more 1s than 0s.
110: all its prefixes (1, 11, and 110) have more 1s than 0s.
101: all its prefixes (1, 10, and 101) have more 1s than 0s.
So, the output is "111, 110, 101".
User Task:
Your task is to complete the function NBitBinary() which takes a single number as input n and returns the list of strings in decreasing order. You need not take any input or print anything.

Expected Time Complexity: O(|2n|)
Expected Auxiliary Space: O(2n)

Constraints:
1 <= n <= 15


-----------------------------------------------------------------------------------------------------------------------------------------------------


class Solution {
    
    static void help(ArrayList<String> ans,int zero,int one, StringBuilder temp, int N){
        if(temp.length()==N){
            ans.add(temp.toString());
            return;
        }
        if(one>zero){
            temp.append('0');
            help(ans,zero+1,one,temp,N);
            temp.deleteCharAt(temp.length()-1);
        }
        temp.append('1');
        help(ans,zero,one+1,temp,N);
        temp.deleteCharAt(temp.length()-1);
    }
    ArrayList<String> NBitBinary(int N) {
        // code here
        ArrayList<String> ans = new ArrayList<>();
        StringBuilder temp = new StringBuilder();
        temp.append('1');
	    help(ans,0,1,temp,N);
	    Collections.sort(ans);
	    Collections.reverse(ans);
	    return ans;
    }
}
    
}
