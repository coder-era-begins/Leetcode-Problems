import java.util.*;
public class CourseSchedule {
    static boolean bfs(int[][] prerequesites,int V){
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        Queue<Integer> queue=new LinkedList<>();
        ArrayList<Integer> topo=new ArrayList<>();
        int indegree[]=new int[V];
        int n=prerequesites.length;
        for(int index=0;index<V;index++){
            adj.add(new ArrayList<>());
        }
        for(int index=0;index<n;index++){
            adj.get(prerequesites[index][0]).add(prerequesites[index][1]);
            indegree[prerequesites[index][1]]++;
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
        return topo.size()==V;

    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int V=sc.nextInt();
        int n=sc.nextInt();
        int[][] prerequesites=new int[n][2];
        for(int index=0;index<n;index++){
            System.out.println("Enter first Node:");
            prerequesites[index][0]=sc.nextInt();
            System.out.println("Enter Second Node");
            prerequesites[index][1]=sc.nextInt();

        }
        System.out.println(bfs(prerequesites,V));

        
    }
}
