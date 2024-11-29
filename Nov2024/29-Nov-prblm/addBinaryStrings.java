package 29-Nov-prblm;

public class addBinaryStrings {


    Name Of The Problem :- Add Binary Strings

    POTD :- 29-November-2024

    Given two binary strings s1 and s2 consisting of only 0s and 1s. Find the resultant string after adding the two Binary Strings.
Note: The input strings may contain leading zeros but the output string should not have any leading zeros.

Input: s1 = "1101", s2 = "111"
Output: 10100
Explanation:
 1101
+ 111
10100
Input: s1 = "00100", s2 = "010"
Output: 110
Explanation: 
  100
+  10
  110
Constraints:
1 ≤s1.size(), s2.size()≤ 106



*****************************************************************************************************************************************************


class Solution {
    public String addBinary(String A, String B) {
        // code here
        
        int  i = A.length() -1;
        int  j = B.length() -1;
         StringBuilder res = new StringBuilder();
         int carry=0;
         
         while(i>=0 || j>=0)
         {
             int sum = ((i>=0) ? A.charAt(i)-'0' : 0) + ((j>=0) ? B.charAt(j)-'0' : 0) + carry;
              carry=  sum/2;
              res.append(sum%2);
              
              i--; j--;
          }
          if(carry!=0)
          {
              res.append(carry);
          }
          
          
          // note
          int idx =0;
          for(idx = res.length()-1; idx>=0; idx--)
          {
              if(res.charAt(idx)!=  '0' ) 
              break;
          }
          res.delete(idx+1, res.length()); // del leading zeros;
          
          return res.reverse().toString();
    }
}
    
}
