package 19-june-prblm;

public class findmaximumvolumeofacuboid {


    Name Of The Problem :- Find maximum volume of a cuboid

    POTD :- 19-June-2024


    You are given a perimeter & the area. Your task is to return the maximum volume that can be made in the form of a cuboid from the given perimeter and surface area.
Note: Round off to 2 decimal places and for the given parameters, it is guaranteed that an answer always exists.

Examples

Input: perimeter = 22, area = 15
Output: 3.02
Explanation: The maximum attainable volume of the cuboid is 3.02
Input: perimeter = 20, area = 5
Output: 0.33
Explanation: The maximum attainable volume of the cuboid is 0.33
Expected Time Complexity: O(1)
Expected Auxiliary Space: O(1)
Constraints :
1 ≤ perimeter ≤ 109
1 ≤ area ≤ 109


*****************************************************************************************************************************************************

class Solution {

    double maxVolume(double P, double A) {
        // code here
        
           double l = (double)(P - Math.sqrt(P * P - 24 * A)) / 12;
 
    double height = (P / 4) - (2 * (l));
        
         double ans = l * l* height;
          return ans;
    }
}
    
}
