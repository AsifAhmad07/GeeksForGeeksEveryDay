package 04-Aug-prblm;

public class nmeetingsinoneroom {


    Name Of The Problem :- N meetings in one room

    POTD :- 04-August-2024

    You are given timings of n meetings in the form of (start[i], end[i]) where start[i] is the start time of meeting i and end[i] is the finish time of meeting i. Return the maximum number of meetings that can be accommodated in a single meeting room, when only one meeting can be held in the meeting room at a particular time. 

Note: The start time of one chosen meeting can't be equal to the end time of the other chosen meeting.

Examples :

Input: n = 6, start[] = [1, 3, 0, 5, 8, 5], end[] =  [2, 4, 6, 7, 9, 9]
Output: 4
Explanation: Maximum four meetings can be held with given start and end timings. The meetings are - (1, 2), (3, 4), (5,7) and (8,9)
Input: n = 3, start[] = [10, 12, 20], end[] = [20, 25, 30]
Output: 1
Explanation: Only one meetings can be held with given start and end timings.
Expected Time Complexity: O(n*logn)
Expected Auxilliary Space: O(n)

Constraints:
1 ≤ n ≤ 105
0 ≤ start[i] < end[i] ≤ 106


*****************************************************************************************************************************************************

class Solution {
    // Function to find the maximum number of meetings that can
    // be performed in a meeting room.
    public int maxMeetings(int n, int start[], int end[]) {
        // add your code here
         int temp[][] = new int[n][2];
        for(int i=0;i<n;i++){
            temp[i][0]=end[i];
            temp[i][1]=start[i];
        }
        Arrays.sort(temp,new Comparator<int[]>(){
            public int compare(int a[],int b[]){
                return a[0]-b[0];
            }
        });
        int ans = 1,last = temp[0][0];
        for(int i=1;i<n;i++){
            if(temp[i][1]>last){
                ans++;
                last=temp[i][0];
            }
        }
        return ans;
    }
}

    
}
