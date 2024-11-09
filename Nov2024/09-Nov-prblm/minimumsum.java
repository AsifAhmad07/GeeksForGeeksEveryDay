package 09-Nov-prblm;

public class minimumsum {


    Name Of The Problem :- Minimum sum


    POTD :- 09-Novemeber-2024

    Given an array arr[] such that each element is in the range [0 - 9], find the minimum possible sum of two numbers formed using the elements of the array. All digits in the given array must be used to form the two numbers. Return a string without leading zeroes.

Examples :

Input: arr[] = [6, 8, 4, 5, 2, 3]
Output: 604
Explanation: The minimum sum is formed by numbers 358 and 246.
Input: arr[] = [5, 3, 0, 7, 4]
Output: 82
Explanation: The minimum sum is formed by numbers 35 and 047.
Input: arr[] = [9, 4]
Output: 13
Explanation: The minimum sum is formed by numbers 9 and 4.
Constraints:
1 ≤ arr.size() ≤ 106
0 ≤ arr[i] ≤ 9

*****************************************************************************************************************************************************


    
class Solution {
    String minSum(int[] arr) {
        // code here
        
        int n = arr.length;
        Arrays.sort(arr);
        StringBuilder num1=new StringBuilder();
        StringBuilder num2=new StringBuilder();
        for(int i=0;i<n;i++)
        {
            if(i%2==0)num1.append(""+arr[i]);
            else num2.append(""+arr[i]);
        }
        StringBuilder ans=new StringBuilder();
        int m = num2.length();
        n = num1.length();
        String str1 = num1.toString();
        String str2 = num2.toString();
        int i=n-1,j=m-1,carry =0;
        while(i>-1 || j>-1 || carry!=0){
            int temp1 = i>-1?str1.charAt(i)-'0':0;
            int temp2 = j>-1?str2.charAt(j)-'0':0;
            int num = temp1+temp2+carry;
            ans.append(""+num%10);
            carry = num/10;
            i--;
            j--;
        }
        ans.reverse();
        str1 = ans.toString();
        for(i=0;i<str1.length();i++){
            if(str1.charAt(i)!='0')break;
        }
        return str1.substring(i);
    }
}

}
