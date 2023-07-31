package IO;
import java.util.*;

public class practice {
    
    public static void main(String args[]){
        
        // 7 vertices 6 edges
        // 0 1
        // 0 3
        // 3 4
        // 4 5
        // 5 6
        // 1 2
        // 4 7

        Solution sol = new Solution();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int V = 8;
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<Integer>());
        }
        adj.get(0).add(1);
        adj.get(0).add(3);
        adj.get(3).add(4);
        adj.get(4).add(5);
        adj.get(5).add(6);
        adj.get(1).add(2);
        adj.get(4).add(7);
        System.out.println(sol.detectCycle(V,adj));
        
    }
}

class DSU{
    
     int [] rank;
     int[] parent; int N;
     
     
     DSU(int V){
         
         N = V;
         rank = new int[N];
         parent = new int[N];
         Arrays.fill(rank,0);
         
         for(int i=0;i<N;i++)
         parent[i]=i;
     }
     
     int findParent(int i){
         if(parent[i]==i)
         return i;
         
         return parent[i] = findParent(parent[i]);
     }
     
     void unite(int x,int y){
         int p1 = findParent(x);
         int p2 = findParent(y);
         
         if(p1!=p2){
            if(rank[p2]>rank[p1])
             p1 = (p1+p2) - (p2=p1);
             
            parent[p2]=p1;
            rank[p1]+=rank[p2];
         }
     }
     
     boolean isCycle(){
         int par = findParent(0);
         for(int i:parent)
         if(par!=findParent(i))return false;
         return true;
     }
        
}

class Solution
{
    //Function to detect cycle using DSU in an undirected graph.
    public int detectCycle(int V, ArrayList<ArrayList<Integer>> adj)
    {
       
       DSU dsu = new DSU(V);
       
       for(int i=0;i<V;i++){
           
           for(Integer x:adj.get(i)){
               dsu.unite(i,x);
           }
       }
       
       return dsu.isCycle()?1:0;
        
        
    }
}
