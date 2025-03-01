package 01-March-prblm;

public class decodethestring {

    
    Name Of The Problem :- Decode the string

    POTD :- 01-March-2025

    Given an encoded string s, the task is to decode it. The encoding rule is :

k[encodedString], where the encodedString inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
Note: The test cases are generated so that the length of the output string will never exceed 105 .

Examples:

Input: s = "1[b]"
Output: "b"
Explanation: "b" is present only one time.
Input: s = "3[b2[ca]]"
Output: "bcacabcacabcaca"
Explanation:
1. Inner substring “2[ca]” breakdown into “caca”.
2. Now, new string becomes “3[bcaca]”
3. Similarly “3[bcaca]” becomes “bcacabcacabcaca ” which is final result.
Constraints:
1 ≤ |s| ≤ 105 



*****************************************************************************************************************************************************


class Solution {
    static String decodeString(String s) {
        // code here
        
         Stack<Integer> count = new Stack();
        Stack<String> result = new Stack();
        char[] arr = s.toCharArray();
        int i=0, num=0;
        String curr = "";
        while(i<s.length()){
            if(Character.isDigit(arr[i])){
                num=0;
                while(Character.isDigit(arr[i])){
                    num = num*10+(arr[i]-'0');
                    i++;
                }
                count.push(num);
            }
            else if(arr[i]=='['){
                result.add(curr);
                curr="";
                i++;
            }
            else if(arr[i]==']'){
                int n=count.pop();
                StringBuilder sb = new StringBuilder(result.pop());
                for(int j=0;j<n;j++){
                    sb.append(curr);
                }
                curr=sb.toString();
                i++;
            }
            else {
                curr+=arr[i];
                i++;
            }
        }
        return curr;
    }
}
}