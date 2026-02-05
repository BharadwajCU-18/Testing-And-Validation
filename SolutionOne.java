package IsBipartite;
import java.util.Stack;
public class SolutionOne {
    
   
  interface Foo {
   public boolean dfs_color(int node, int color);
  }
    
    
    public boolean isBipartite(final int[][] graph) {
    
 
    final int[] visited = new int[graph.length];
        
    Foo gColor = new Foo() {
      @Override public  boolean dfs_color(int node, int color){
        if(visited[node]!=0){  // if colored already; 
            return (visited[node] == color);
        }
        visited[node] = color;

        for(int i = 0; i < graph[node].length; i++){
            int neighbor = graph[node][i];
            boolean res = dfs_color(neighbor, -color);
            if(!res) 
                return false;
        }
        return true;
      };

    };
        
   
    
    for(int i = 0; i < graph.length; i++){
        if(visited[i]!=0){
            continue;
        }else{
            boolean res = gColor.dfs_color(i, 1);
            if(!res) 
                return false;
        }
    }

    return true;
   }

   public static void main(String[] args) {
    SolutionOne s = new SolutionOne();

    int[][] g1 = {{1,3},{0,2},{1,3},{0,2}}; // bipartite => true
    int[][] g2 = {{1,2,3},{0,2},{0,1,3},{0,2}}; // not bipartite => false
    int[][] g3 = {{1,2},{3,4}};

    System.out.println(s.isBipartite(g1));
    System.out.println(s.isBipartite(g2));
    System.out.println(s.isBipartite(g3));
}
    
}