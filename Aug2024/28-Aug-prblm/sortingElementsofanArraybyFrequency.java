package 28-Aug-prblm;

public class sortingElementsofanArraybyFrequency {


    Name Of The Problem :- Sorting Elements of an Array by Frequency

    POTD :- 28-August-2024

    Given an array of integers arr, sort the array according to the frequency of elements, i.e. elements that have higher frequency comes first. If the frequencies of two elements are the same, then the smaller number comes first.

Examples :

Input: arr[] = [5, 5, 4, 6, 4]
Output: [4, 4, 5, 5, 6]
Explanation: The highest frequency here is 2. Both 5 and 4 have that frequency. Now since the frequencies are the same the smaller element comes first. So 4 4 comes first then comes 5 5. Finally comes 6. The output is 4 4 5 5 6.
Input: arr[] = [9, 9, 9, 2, 5]
Output: [9, 9, 9, 2, 5]
Explanation: The highest frequency here is 3. Element 9 has the highest frequency So 9 9 9 comes first. Now both 2 and 5 have the same frequency. So we print smaller elements first. The output is 9 9 9 2 5.
Expected Time Complexity: O(n*logn)
Expected Space Complexity: O(n)

Constraints:
1 ≤ arr.size() ≤ 105
1 ≤ arr[i]≤ 105


*****************************************************************************************************************************************************
class Solution {
    // Function to sort the array according to frequency of elements.
    public ArrayList<Integer> sortByFreq(int arr[]) {
        // add your code here
        int n = arr.length;
        HashMap<Integer,Integer> mm = new HashMap<>();
        int vec[][] = new int[n][2];
        ArrayList<Integer> ans = new ArrayList<>();
        for(int x:arr)mm.put(x,mm.getOrDefault(x,0)+1);
        for(int i=0;i<n;i++){
            vec[i][0]=arr[i];
            vec[i][1]=mm.get(arr[i]);
        }
        Arrays.sort(vec,new Comparator<int[]>(){
            @Override
            public int compare(int a[],int b[]){
                if(a[1]!=b[1])return b[1]-a[1];
                return a[0]-b[0];
            }
        });
        for(int i=0;i<n;i++)ans.add(vec[i][0]);
        return ans;
    }
}
    
}
