package 18-june-prblm;

public class NumberofRectanglesinaCircle {


    Name Of The Problem :- Number of Rectangles in a Circle

    POTD :- 18-June-2024

    Given a circular sheet of radius, r. Find the total number of rectangles with integral length and width that can be cut from the sheet that can fit on the circle, one at a time.

Examples :

Input: r=1
Output: 1
Explanation: Only 1 rectangle of dimensions 1x1.
Input: r=2
Output: 8
Explanation: The 8 possible rectangles are 
(1x1)(1x2)(1x3)(2x1)(2x2)(2x3)(3x1)(3x2).
Expected Time Complexity: O(r2)
Expected Auxillary Space: O(1)


Constraints:
1<=r<=1000 

*****************************************************************************************************************************************************Auxillary



class Solution {
    int rectanglesInCircle(int radius) {
        // code here
            int rectangleCount = 0;
        for (int x = 1; x < 2 * radius; x++) {
            int y = 1;
            while (4 * radius * radius >= x * x + y * y) {
                rectangleCount++; 
                y++; 
            }
        }

        return rectangleCount; 
    }
};
    
}
