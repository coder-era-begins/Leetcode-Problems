class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        ArrayList<Integer> topo=new ArrayList<>();
        Queue<Integer> queue=new LinkedList<>();
        int indegree[]=new int[V];
        int N=edges.length;
        for(int index=0;index<V;index++){
            adj.add(new ArrayList<>());
        }
        for(int index=0;index<N;index++){
            adj.get(edges[index][0]).add(edges[index][1]);
            indegree[edges[index][1]]++;
        }
        for(int index=0;index<V;index++){
            if(indegree[index]==0){
                queue.add(index);
            }
        }
        while(!queue.isEmpty()){
            int curNode=queue.poll();
            topo.add(curNode);
            for(int nextNode:adj.get(curNode)){
                indegree[nextNode]--;
                if(indegree[nextNode]==0){
                    queue.add(nextNode);
                }
            }
        }
        return topo.size()!=V;
    }
}
