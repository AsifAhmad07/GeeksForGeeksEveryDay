package 15-May-prblm;

public class accountMerge {


    Name Of The Problem :- Account Merge

    POTD :- 15-May-2024

    Given a list of accounts of size n where each element accounts [ i ] is a list of strings, where the first element account [ i ][ 0 ]  is a name, and the rest of the elements are emails representing emails of the account.
    Geek wants you to merge these accounts. Two accounts belong to the same person if there is some common email to both accounts. Note that even if two accounts have the same name, they may belong to different people as people could have the same name. A person can have any number of accounts initially, but all of their accounts have the same name.
    After merging the accounts, return the accounts in the following format: The first element of each account is the name, and the rest of the elements are emails in sorted order.
    
    Note: Accounts themselves can be returned in any order.
    
    Example 1:
    
    Input:
    n = 4
    accounts [ ] =
    [["John","johnsmith@mail.com","john_newyork@mail.com"],
    ["John","johnsmith@mail.com","john00@mail.com"],
    ["Mary","mary@mail.com"],
    ["John","johnnybravo@mail.com"]]
    Output:
    [["John","john00@mail.com","john_newyork@mail.com", "johnsmith@mail.com"],
    ["Mary","mary@mail.com"],
    ["John","johnnybravo@mail.com"]]
    Explanation:
    The first and second John's are the same person as they have the common email "johnsmith@mail.com". The third John and Mary are different people as none of their email addresses are used by other accounts.We could return these arrays in any order, for example, the answer [['Mary', 'mary@mail.com'], ['John', 'johnnybravo@mail.com'], ['John', 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']] would still be accepted.
    Example 2:
    
    Input:
    n = 5
    accounts [ ] =
    [["Gabe","Gabe00@m.co","Gabe3@m.co","Gabe1@m.co"],
    ["Kevin","Kevin3@m.co","Kevin5@m.co","Kevin0@m.co"],
    ["Ethan","Ethan5@m.co","Ethan4@m.co","Ethan0@m.co"],
    ["Hanzo","Hanzo3@m.co","Hanzo1@m.co","Hanzo0@m.co"],
    ["Fern","Fern5@m.co","Fern1@m.co","Fern0@m.co"]]
    Output:
    [["Ethan","Ethan0@m.co","Ethan4@m.co","Ethan5@m.co"],
    ["Gabe","Gabe0@m.co","Gabe1@m.co","Gabe3@m.co"],
    ["Hanzo","Hanzo0@m.co","Hanzo1@m.co","Hanzo3@m.co"],
    ["Kevin","Kevin0@m.co","Kevin3@m.co","Kevin5@m.co"],
    ["Fern","Fern0@m.co","Fern1@m.co","Fern5@m.co"]]
    Explanation:
    We don't have any common emails in any of the users. We just sorted the emails of each person and we return a array of emails.(The details can be returned in any order).
    Your Task:
    You don't need to read or print anything. Your task is to complete the function accountsMerge() which takes a list of lists of strings representing accounts[][] as a parameter and returns a list of lists of strings denoting the details after merging.
    
    Expected Time Complexity: O(n*m*logn) - where n is the size of accounts and m is the size of the number of strings for a name.
    Expected Auxiliary Space: O(n*m) - where n is the size of accounts and m is the size of the number of strings for a name.
    
    Constraints:
    1 <= n <= 1000
    2 <= accounts[ i ].size <= 10
    1 <= accounts[ i ][ j ].size <= 30
    accounts[i][0] consists of English letters.


    *************************************************************************************************************************************************

    //User function Template for Java
class Solution {
    
    static int[] par;
    static List<List<String>> accountsMerge(List<List<String>> a) {
        
        int n = a.size();
         par = new int[n];
        for (int i = 0; i < n; i++) {
            par[i] = i;
        }
        Map<String,Integer> m1 = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < a.get(i).size(); j++) {
                String mail = a.get(i).get(j);
                if (m1.containsKey(mail)) { 
                    
                    int person = m1.get(mail);
                    union(i, person);
                } 
                else {
                    m1.put(mail, i);
                }
            }
        }
        Map<Integer, TreeSet<String>> map = new HashMap<>(); 
       
        for (int i = 0; i < n; i++) {
            int root = find(i);
            List<String> al = a.get(i);
            if (!map.containsKey(root)) 
                map.put(root, new TreeSet<String>());
            
            map.get(root).addAll(al.subList(1, al.size())); 
        }
        List<List<String>> res = new ArrayList<List<String>>();
        
        for (int root : map.keySet()) {
            String name = a.get(root).get(0);
            ArrayList<String> curr = new ArrayList<>(map.get(root));
            curr.add(0,name);
           
            res.add(curr);
        }
        return res;
    }
    
    static int find(int idx) { 
        
        if (idx == par[idx])
            return idx;
    
        return par[idx] = find(par[idx]);
    }
    static void union(int x, int y){
        int x_rep = find(x), y_rep=find(y);
        if(x_rep==y_rep) return;
        par[y_rep] = x_rep;
    }
}
    
}
