import java.util.ArrayList;
import java.util.List;

public class Solution {
  public static boolean dfs(List<List<Integer>> adj,int x,boolean[] vst,boolean[] path){
    vst[x]=true;
    path[x]=true;
    for(int v:adj.get(x)){
      if(path[v] )return true;
      if(!vst[v] && dfs(adj,v,vst,path)) return true;
    }
    path[x]=false;
    return false;
  }
  
  public static boolean detectCycleInDirectedGraph(int n, ArrayList < ArrayList < Integer >> edges) {
    // Write your code here.
    List<List<Integer>> adj =new ArrayList<>();
    int m=edges.size();
  for(int i=0;i<n;i++){
    adj.add(new ArrayList<>());
  }
  for(int i=0;i<m;i++){
    adj.get(edges.get(i).get(0)-1).add(edges.get(i).get(1)-1);
  }
   

  boolean[] vst=new boolean[n];
  boolean[] path=new boolean[n];

  for(int i=0;i<n;i++){
    if(!vst[i]&& dfs(adj,i,vst,path)) return true;

  }
return false;

  }
}