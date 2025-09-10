class Solution {
    static ArrayList<Integer> list;
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        list=new ArrayList<>();
        int n=adj.size();
        boolean visited[]=new boolean[n];
        dfs(0,visited,adj);
        return list;
        
    }
    static void dfs(int source,boolean visited[],ArrayList<ArrayList<Integer>> adj){
        visited[source]=true;
        list.add(source);
        for(int nxt:adj.get(source)){
            if(!visited[nxt]){
                dfs(nxt,visited,adj);
            }
        }
    }
}
