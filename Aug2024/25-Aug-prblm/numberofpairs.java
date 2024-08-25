package 25-Aug-prblm;

public class numberofpairs {


    Name Of The Problem :- Number of pairs

    POTD :- 25-August-2024

    Given two positive integer arrays arr and brr, find the number of pairs such that xy > yx (raised to power of) where x is an element from arr and y is an element from brr.

Examples :

Input: arr[] = [2, 1, 6], brr[] = [1, 5]
Output: 3
Explanation: The pairs which follow xy > yx are: 21 > 12,  25 > 52 and 61 > 16 .
Input: arr[] = [2 3 4 5], brr[] = [1 2 3]
Output: 5
Explanation: The pairs which follow xy > yx are: 21 > 12 , 31 > 13 , 32 > 23 , 41 > 14 , 51 > 15 .
Expected Time Complexity: O((N + M)log(N)).
Expected Auxiliary Space: O(1).

Constraints:
1 ≤ arr.size(), brr.size() ≤ 105
1 ≤ brr[i], arr[i] ≤ 103

*****************************************************************************************************************************************************


//Back-end complete function Template for Java
class Solution {
    // Function to count number of pairs such that x^y is greater than y^x.
      int binarySearch(int key,int brr[]){
        int low=0,high=brr.length-1,mid,index=-1;
        while(low<=high){
            mid=(low+high)/2;
            if(brr[mid]<=key){
                index=mid;
                low=mid+1;
            }
            else high=mid-1;
        }
        return index;
    }
    public long countPairs(int arr[], int brr[], int M, int N) {
        // code here
         long ans = 0,one=0,two=0,threeFour=0;
        Arrays.sort(brr);
        for(int x:brr){
            if(x==1)one++;
            else if(x==2)two++;
            else if(x==3 || x==4)threeFour++;
        }
        for(int x:arr){
            if(x!=1){
                ans+=one;
                if(x==2)ans-=threeFour;
                if(x==3)ans+=two;
                int index = binarySearch(x,brr);
                ans+=(brr.length-index-1);
            }
        }
        return ans;
    }
}

    
}
