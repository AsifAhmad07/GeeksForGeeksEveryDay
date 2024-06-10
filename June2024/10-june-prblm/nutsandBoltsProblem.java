package 10-june-prblm;

public class nutsandBoltsProblem {


    Name Of The Problem :- Nuts and Bolts Problem

    POTD :- 10-June-2024

    Given a set of n nuts & bolts. There is a one-on-one mapping between nuts and bolts. You have to Match nuts and bolts efficiently. Comparison of a nut to another nut or a bolt to another bolt is not allowed. It means the nut can only be compared with the bolt and the bolt can only be compared with the nut to see which one is bigger/smaller.
The elements should follow the following order: { !,#,$,%,&,*,?,@,^ }

Note: Make all the required changes directly in the given arrays, output will be handled by the driver code.

Examples

Input: n = 5, nuts[] = {@, %, $, #, ^}, bolts[] = {%, @, #, $ ^}
Output: 
# $ % @ ^
# $ % @ ^
Explanation: As per the order # should come first after that $ then % then @ and ^. 
Input: n = 9, nuts[] = {^, &, %, @, #, *, $, ?, !}, bolts[] = {?, #, @, %, &, *, $ ,^, !}
Output: 
! # $ % & * ? @ ^
! # $ % & * ? @ ^
Explanation: We'll have to match first ! then  # , $,  %,  &,  *,  @,  ^,  ? as per the required ordering.
Expected Time Complexity: O(n(logn))
Expected Auxiliary Space: O(log(n))

Constraints:
1 <= n <= 9
The arrays 'nuts' and 'bolts' can only consist of the following elements: {'@', '#', '$', '%', '^', '&', '?', '*', '!'}.
All the elements of arrays 'nuts' and 'bolts' should be unique.

*****************************************************************************************************************************************************


class Solution {
    void matchPairs(int n, char nuts[], char bolts[]) {
        // code here
        char temp[]={'!','#','$','%','&','*','?','@','^'};
        Map<Character,Integer> mm = new HashMap<>();
        for(int i=0;i<n;i++)mm.put(nuts[i],1);
        int j=0;
        for(int i=0;i<9;i++){
            if(mm.get(temp[i])!=null){
                nuts[j]=temp[i];
                bolts[j]=temp[i];
                j++;
            }
        }
    }
}
    
}
