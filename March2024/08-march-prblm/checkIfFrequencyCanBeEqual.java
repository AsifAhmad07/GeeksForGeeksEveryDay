package 08-march-prblm;

public class checkIfFrequencyCanBeEqual {

   Name Of The Problem :- Check if frequencies can be equal

   
   POTD :- 08-march-2024


   Given a string s which contains only lower alphabetic characters, check if it is possible to remove at most one character from this string in such a way that frequency of each distinct character becomes same in the string. Return true if it is possible to do else return false.

Note: The driver code print 1 if the value returned is true, otherwise 0.

Example 1:

Input:
s = "xyyz"
Output: 
1 
Explanation: 
Removing one 'y' will make frequency of each character to be 1.
Example 2:

Input:
s = "xxxxyyzz"
Output: 
0
Explanation: 
Frequency can not be made same by removing at most one character.
Your Task:  
You dont need to read input or print anything. Complete the function sameFreq() which takes a string as input parameter and returns a boolean value denoting if same frequency is possible or not.

Expected Time Complexity: O(|s|) 
Expected Auxiliary Space: O(1)

Constraints:
1 <= |s| <= 105


-----------------------------------------------------------------------------------------------------------------------------------------------------



class Solution {
    boolean sameFreq(String s) {
        // code here
        
      Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        Map<Integer,Integer> hashMap=new HashMap<>();
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(Map.Entry<Character,Integer> m:map.entrySet()){
            min=Math.min(m.getValue(),min);
            max=Math.max(m.getValue(),max);
            hashMap.put(m.getValue(),hashMap.getOrDefault(m.getValue(),0)+1);
        }
        if(hashMap.size()>2)
        return false;
        if(max>min && hashMap.get(max)>1 && min==1)
        return true;
        if(max>min && hashMap.get(max)>1 && min>1)
        return false;
        if(min==max || max==min+1)
        return true;
        return false;
  
    }
}
    
}
