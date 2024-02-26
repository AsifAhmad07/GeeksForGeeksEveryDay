package 26-feb-prblm;

public class powerSet {


Name Of The Problem :- Power Set

POTD :- 26-feb-2024

Given a string s of length n, find all the possible subsequences of the string s in lexicographically-sorted order.

Example 1:

Input : 
s = "abc"
Output: 
a ab abc ac b bc c
Explanation : 
There are a total 7 number of subsequences possible 
for the given string, and they are mentioned above 
in lexicographically sorted order.
Example 2:

Input: 
s = "aa"
Output: 
a a aa
Explanation : 
There are a total 3 number of subsequences possible 
for the given string, and they are mentioned above 
in lexicographically sorted order.
Your Task:
You don't need to read input or print anything. Your task is to complete the function AllPossibleStrings() which takes a string s as the input parameter and returns a list of all possible subsequences (non-empty) that can be formed from s in lexicographically-sorted order.

Expected Time Complexity: O( n*2n  )
Expected Space Complexity: O( n * 2n )

Constraints: 
1 <= n <= 16
s will constitute of lower case english alphabets


-----------------------------------------------------------------------------------------------------------------------------------------------------

class Solution
{
    void help(String s,int index,List<String> ans,StringBuilder temp){
	    if(index==s.length()){
	        if(temp.length()!=0)ans.add(temp.toString());
	        return;
	    }
	    help(s,index+1,ans,temp);
	    temp.append(s.charAt(index));
	    help(s,index+1,ans,temp);
	    temp.deleteCharAt(temp.length()-1);
	}
    public List<String> AllPossibleStrings(String s)
    {
        List<String> ans = new ArrayList<>();
        StringBuilder temp = new StringBuilder();
	    help(s,0,ans,temp);
	    Collections.sort(ans);
	    return ans;
    }
}

    
}
