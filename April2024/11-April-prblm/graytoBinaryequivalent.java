package 11-April-prblm;

public class graytoBinaryequivalent {



    Name Of The Problem :- Gray to Binary equivalent

    Date :- 11-April-2024

    Given an integer number n, which is a decimal representation of Gray Code. Find the binary equivalent of the Gray Code & return the decimal representation of the binary equivalent.

 

Note: Please visit here to learn How Gray Code is generated.

Example 1:

Input: 
n = 4
Output: 
7
Explanation:
Given 4, its gray code =  110.
Binary equivalent of the gray code 110 is 100.
Return 7 representing gray code 100.
Example 2:

Input: 
n = 15
Output: 
10
Explanation:
Given 15 representing gray code 1000.
Binary equivalent of gray code 1000 is 1111.
Return 10 representing gray code 1111 
ie binary 1010.
Your Task: 
You don't need to read input or print anything. Your task is to complete the function grayToBinary() which accepts an integer n as an input parameter and returns decimal representation of the binary equivalent of the given gray code.

Expected Time Complexity: O(log (n)).
Expected Auxiliary Space: O(1).

Constraints:
0 <= n <= 108

-----------------------------------------------------------------------------------------------------------------------------------------------------

class Solution{
    
    // function to convert a given Gray equivalent n to Binary equivalent.
    public static int grayToBinary(int n) {
        
        // Your code here
        ArrayList<Integer> temp = new ArrayList<>();
        while(n!=0){
            if((n&1)==1)temp.add(1);
            else temp.add(0);
            n>>=1;
        }
        Collections.reverse(temp);
        for(int i=1;i<temp.size();i++){
            temp.set(i,temp.get(i-1)^temp.get(i));
        }
        int ans = 0,j=0;
        for(int i=temp.size()-1;i>=0;i--){
            if(temp.get(i)==1)ans+=Math.pow(2,j);
            j++;
        }
        return ans;
    }
       
}

    
}
