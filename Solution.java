import java.util.*;

class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        
        //track from n = 1 to n fwd fashion don't worry about duplicates
        List<Integer> temp = new ArrayList<>();
        shot(temp,n,1,k);
        return ans;
    }

    public void shot(List<Integer> list,int n,int i,int k){

        //base condition
        if(i>n)
            return;
        //exclude
        shot(list, n,i+1,k);
        //include
        list.add(i);
        if(list.size()==k)
            {
                ans.add(list);
                return;
            }
        shot(list, n, i+1, k);  
        list.remove(list.size()-1);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.combine(4, 2));

    }
}