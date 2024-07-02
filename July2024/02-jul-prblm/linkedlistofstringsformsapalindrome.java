package 02-jul-prblm;

public class linkedlistofstringsformsapalindrome {


    Name Of The Problem :- Linked list of strings forms a palindrome


    POTD :- 02-July-2024

    Given a linked list with string data, check whether the combined string formed is palindrome. If the combined string is palindrome then return true otherwise return false.

Example:

Input:

Output : true
Explanation: As string "abcddcba" is palindrome the function should return true.
Input:

Output : false
Explanation: As string "abcdba" is not palindrome the function should return false.
Expected Time Complexity:  O(n)
Expected Auxiliary Space: O(n)

Constraints:
1 <= Node.data.length<= 103
1<=list.length<=103

*****************************************************************************************************************************************************


class Solution {
    public boolean compute(Node root) {
        StringBuilder temp = new StringBuilder();
        while(root!=null){
            temp.append(root.data);
            root=root.next;
        }
        String concat = temp.toString();
        int i=0,j=concat.length()-1;
        while(i<j){
            if(concat.charAt(i)!=concat.charAt(j))return false;
            i++;
            j--;
        }
        return true;
    }
}
    
}
