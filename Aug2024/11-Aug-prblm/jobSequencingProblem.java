package 11-Aug-prblm;

public class jobSequencingProblem {



    Name Of The Problem :- Job Sequencing Problem

    POTD :- 11-August-2024

    Given a set of n jobs where each jobi has a deadline and profit associated with it.

Each job takes 1 unit of time to complete and only one job can be scheduled at a time. We earn the profit associated with a job if and only if the job is completed by its deadline.

Find the number of jobs done and the maximum profit.

Note: Jobs will be given in the form (Jobid, Deadline, Profit) associated with that Job. Deadline of the job is the time on or before which job needs to be completed to earn the profit.

Examples :

Input: Jobs = [[1,4,20],[2,1,1],[3,1,40],[4,1,30]]
Output: 2 60
Explanation: Job1 and Job3 can be done with maximum profit of 60 (20+40).
Input: Jobs = [[1,2,100],[2,1,19],[3,2,27],[4,1,25],[5,1,15]]
Output: 2 127
Explanation: 2 jobs can be done with maximum profit of 127 (100+27).
Expected Time Complexity: O(nlogn)
Expected Auxilliary Space: O(n)

Constraints:
1 <= n <= 105
1 <= Deadline,id <= n
1 <= Profit <= 500

*****************************************************************************************************************************************************

class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int ans;
    int[] parent ; 
    int[] size ;
    int[] JobScheduling(Job arr[], int n)
    {
        // Your code here
         parent = new int[n + 1];
          size = new int[n + 1];
          for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }
        //
         Arrays.sort(arr, (a, b) -> b.profit - a.profit);
    
        int profit = 0, jobsDone = 0;

        for (int i = 0; i < n; i++) {
            int availableSlot = find(arr[i].deadline);
            if (availableSlot > 0) {
                Union(availableSlot - 1, availableSlot); // fiiled the slot 
                profit += arr[i].profit;
                jobsDone++;
            }
        }

        return new int[]{jobsDone, profit};
        //
    }
    
    int find(int x) {
        if(x==parent[x])
        return x;
        
        return parent[x] = find(parent[x]); // find path compression
    }

    int Union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

    //union by rank - bigger rank always become parent to avoud chaining
        if (size[rootA] < size[rootB]) {
              ans += size[rootA] * size[rootB];  // only change
            parent[rootA] = rootB;
            size[rootB] += size[rootA];
            
        } else if (size[rootA] > size[rootB]) {
              ans += size[rootA] * size[rootB];
            parent[rootB] = rootA;
            size[rootA] += size[rootB];
        } else {
                ans += size[rootA] * size[rootB];
            parent[rootB] = rootA;
            size[rootA] += size[rootB];
        }
        
          return ans;
    }
    
    
}
    
}
