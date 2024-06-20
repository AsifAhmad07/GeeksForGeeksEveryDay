public class integralPointsInsideTriangle {


    Name Of The Problem :- Integral Points Inside Triangle

    POTD :- 20-June-2024

    Given three non-collinear points whose co-ordinates are p(p1, p2), q(q1, q2) and r(r1, r2) in the X-Y plane. Return the number of integral / lattice points strictly inside the triangle formed by these points.
Note: - A point in the X-Y plane is said to be an integral / lattice point if both its coordinates are integral.

Examples

Input: p = (0,0), q = (0,5), r = (5,0)
Output: 6
Explanation: 

As shown in figure, points (1,1) (1,2) (1,3) (2,1) (2,2) and (3,1) are the integral points inside the triangle. So total 6 are there.
Input: p = (62,-3), q = (5,-45), r = (-19,-23)
Output: 1129
Explanation: There are 1129 integral points in the triangle formed by p, q and r.
Expected Time Complexity: O(Log2109)
Expected Auxillary Space: O(1)

Constraints:
-109 ≤ x-coordinate, y-coordinate ≤ 109

*****************************************************************************************************************************************************


class Solution {
    private long gcd(long a, long b) {
      if (b == 0) {
          return a;
      }
      return gcd(b, a % b);
  }
  long InternalCount(long p[], long q[], long r[]) {
      // code here
       long area = Math.abs(p[0] * (q[1] - r[1]) + q[0] * (r[1] - p[1]) + r[0] * (p[1] - q[1])) / 2;

      long b1 = gcd(Math.abs(p[0] - q[0]), Math.abs(p[1] - q[1]));
      long b2 = gcd(Math.abs(q[0] - r[0]), Math.abs(q[1] - r[1]));
      long b3 = gcd(Math.abs(r[0] - p[0]), Math.abs(r[1] - p[1]));

      long boundaryPoints = b1 + b2 + b3;

      long internalPoints = area - boundaryPoints / 2 + 1;

      return internalPoints;
  }
};
    
}
