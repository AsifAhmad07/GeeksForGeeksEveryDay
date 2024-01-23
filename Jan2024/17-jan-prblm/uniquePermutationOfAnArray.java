public class uniquePermutationOfAnArray {

    /*
     * Name Of The Problem :- All Unique Permutations of an array
     * POTD :- 17-jan-2024
     * 
     * Given an array arr[] of length n. Find all possible unique permutations of the array in sorted order. A sequence A is greater than sequence B if there is an index i for which Aj = Bj for all j<i and Ai > Bi.

Example 1:

Input: 
n = 3
arr[] = {1, 2, 1}
Output: 
1 1 2
1 2 1
2 1 1
Explanation:
These are the only possible unique permutations
for the given array.
Example 2:

Input: 
n = 2
arr[] = {4, 5}
Output: 
Only possible 2 unique permutations are
4 5
5 4
Your Task:
You don't need to read input or print anything. You only need to complete the function uniquePerms() that takes an integer n, and an array arr of size n as input and returns a sorted list of lists containing all unique permutations of the array.

Expected Time Complexity:  O(n*n!)
Expected Auxilliary Space: O(n*n!)

Constraints:
1 ≤ n ≤ 9
1 ≤ arri ≤ 10


     * 
     * 

     */
    class Solution {
    
        static void help(ArrayList<Integer> arr,int n,HashSet<ArrayList<Integer>> mm,int index){
         if(index==n){
             ArrayList<Integer> nn = new ArrayList<>(arr);
             mm.add(nn);
             return;
         }
         for(int i=index;i<n;i++){
             int a = arr.get(i);
             int b = arr.get(index);
             arr.set(i,b);
             arr.set(index,a);
             help(arr,n,mm,index+1);
             arr.set(i,a);
             arr.set(index,b);
         }
       }
       static ArrayList<ArrayList<Integer>> uniquePerms(ArrayList<Integer> arr , int n) {
           // code here
           ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
           HashSet<ArrayList<Integer>> mm = new HashSet<>();
           help(arr,n,mm,0);
           for(ArrayList<Integer> temp:mm)ans.add(temp);
           Collections.sort(ans, new Comparator<List<Integer>>() {
               public int compare(List<Integer> a, List<Integer> b) {
                   int i = 0;
                   while(i<n) {
                       if(a.get(i).compareTo(b.get(i)) != 0)
                           return a.get(i).compareTo(b.get(i));
                       i++;
                   }
                   return 0;
               }
           });
           return ans;
       }
   };
}