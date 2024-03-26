package 26-march-prblm;

public class additiveSequence {


    Name Of The Problem :- Additive sequence



    POTD :- 26-march-2024

    Given a string n, your task is to find whether it contains an additive sequence or not. A string n contains an additive sequence if its digits can make a sequence of numbers in which every number is addition of previous two numbers. You are required to complete the function which returns true if the string is a valid sequence else returns false. For better understanding check the examples.

Note: A valid string should contain at least three digit to make one additive sequence. 

Example 1:

Input:  
n = "1235813"
Output: 
1
Explanation: 
The given string can be splited into a series of numbers  
where each number is the sum of the previous two numbers: 
1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8, and 5 + 8 = 13. Hence, the output would be 1 (true).
Example 2:

Input:  
n = "11235815"
Output: 
0
Explanation: 
We can start with the first two digits: "11".
First number: 1, Second number: 1, Sum: 1 + 1 = 2
Now, we have "2" as the next number.
First number: 1, Second number: 2, Sum: 1 + 2 = 3
Now, we have "3" as the next number.
First number: 2, Second number: 3, Sum: 2 + 3 = 5
Now, we have "5" as the next number.
First number: 3, Second number: 5, Sum: 3 + 5 = 8
Now, we have "8" as the next number.
First number: 5, Second number: 8, Sum: 5 + 8 = 13
At this point, there is no "13" present in the remaining digits "815". Hence, the output would be 0 (or false).
User Task: 
Your task is to complete the function isAdditiveSequence() which takes a single string as input n and returns a boolean value indicating whether the given string contains an additive sequence or not. You need not take any input or print anything.

Expected Time Complexity: O(n3).
Expected Auxiliary Space: O(n).

Constraints:
3 <= length( n ) <= 200
1 <= digits of string <= 9

-----------------------------------------------------------------------------------------------------------------------------------------------------


class Solution {
    
    static String findSum(String a,String b){
      int i=a.length()-1,j=b.length()-1;
      StringBuilder ans = new StringBuilder();
      int carry=0;
      while(i>=0 && j>=0){
          int sum = (a.charAt(i)-'0')+(b.charAt(j)-'0')+carry;
          ans.append((char)sum%10);
          carry=sum/10;
          i--;
          j--;
      }
      while(i>=0){
          int sum = (a.charAt(i)-'0')+carry;
          ans.append((char)sum%10);
          carry=sum/10;
          i--;
      }
      while(j>=0){
          int sum = (b.charAt(j)-'0')+carry;
          ans.append((char)sum%10);
          carry=sum/10;
          j--;
      }
      if(carry!=0){
          ans.append((char)(carry+'0'));
      }
      StringBuilder temp = ans.reverse();
      return temp.toString();
  }
  static boolean help(String a,String b,String c){
      String sum = findSum(a,b);
      int i=0,j=0;
      while(i<c.length() && j<sum.length()){
          if(c.charAt(i)!=sum.charAt(j))return false;
          i++;
          j++;
      }
      if(j!=sum.length())return false;
      if(i==c.length())return true;
      c=c.substring(i);
      return help(b,sum,c);
  }
  public boolean isAdditiveSequence(String n) {
      // code here
       for(int i=0;i<n.length()/2;i++){
          for(int j=i+1;j<n.length()-1;j++){
              String a = n.substring(0,i+1);
              String b = n.substring(i+1,j+1);
              String c = n.substring(j+1);
              if(help(a,b,c))return true;
          }
      }
      return false;
  }
}

    
}
