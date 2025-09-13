class BFSonGraph {
    // Function to return Breadth First Search Traversal of given graph.
    static ArrayList<Integer> list;
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        list=new ArrayList<>();
        Queue<Integer> queue=new LinkedList<>();
        int n=adj.size();
        boolean visited[]=new boolean[n];
        queue.add(0);
        visited[0]=true;
        while(!queue.isEmpty()){
            int curNode=queue.poll();
            list.add(curNode);
            for(int nextNode:adj.get(curNode)){
                if(!visited[nextNode]){
                    queue.add(nextNode);
                    visited[nextNode]=true;
                }
            }
        }
        return list;
    }
}
