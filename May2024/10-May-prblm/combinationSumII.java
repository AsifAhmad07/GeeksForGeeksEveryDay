package 10-May-prblm;

public class combinationSumII {


    Name Of The Problem :- Combination Sum II

    POTD :- 10-May-2024

    Given an array of integers arr, the length of the array n, and an integer k, find all the unique combinations in arr where the sum of the combination is equal to k. Each number can only be used once in a combination.
Return the combinations in the lexicographically sorted order, where each combination is in non-decreasing order.

Example 1:

Input: 
n = 5, k = 7
arr[] = { 1, 2, 3, 3, 5 }
Output:
{ { 1, 3, 3 }, { 2, 5 } }
Explanation:
1 + 3 + 3 = 7
2 + 5 = 7
Example 2:

Input:
n = 6, k = 30
arr[] = { 5, 10, 15, 20, 25, 30 }
Output:
{ { 5, 10, 15 }, { 5, 25 }, { 10, 20 }, { 30 } }
Explanation:
5 + 10 + 15 = 30
5 + 25 = 30
10 + 20 = 30
Your Task:
You don't need to read input or print anything. Your task is to complete the function CombinationSum2() which takes arr[],n, and k as input parameters and returns all the unique combinations.
 

Constraints:
1 <= n <= 100
1 <= arr[i] <= 50
1 <= k <= 30

let p = number of elements, at maximum, can sum up to the given value k.

Expected Time Complexity: O(2min(n,p))
Expected Auxiliary Space: O(n)


*****************************************************************************************************************************************************

// User function Template for Java

class Solution {
       void help(int arr[],int n,int k,int i,int sum,List<Integer> temp,Set<List<Integer>> st){
        if(sum==k){
            List<Integer> temp2 = new ArrayList<>();
            temp2.addAll(temp);
            st.add(temp2);
            return;
        }
        if(i==n)return;
        help(arr,n,k,i+1,sum,temp,st);
        if(sum+arr[i]<=k){
            temp.add(arr[i]);
            help(arr,n,k,i+1,sum+arr[i],temp,st);
            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> CombinationSum2(int arr[], int n, int k) {
        // Code Here.
         Arrays.sort(arr);
        List<Integer> temp = new ArrayList<>();
        Set<List<Integer>> st = new HashSet<List<Integer>>();
        help(arr,n,k,0,0,temp,st);
        List<List<Integer>> ans = new ArrayList<>();
        for(List<Integer> lis:st){
            ans.add(lis);
        }
        Collections.sort(ans, new Comparator<List<Integer>>() {    
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                int i=0,j=0,a=o1.size(),b=o2.size();
                while(i<a && j<b){
                    if(o1.get(i)!=o2.get(j))return o1.get(i).compareTo(o2.get(j));
                    i++;
                    j++;
                }
                if(i<a)return -1;
                return 1;
                
            }               
        });
        return ans;
    }
}
}