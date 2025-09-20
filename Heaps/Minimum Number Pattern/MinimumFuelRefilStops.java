class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int n=stations.length;
        Arrays.sort(stations,(a,b)->{
            return a[0]-b[0];
        });
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->{
            return b-a;
        });
        int count=0;
        for(int index=0;index<=n;index++){
            int dist=(index==n)?target:stations[index][0];
            while(startFuel<dist){
                if(pq.size()==0){
                    return -1;
                }
                int prev=pq.poll();
                startFuel+=prev;
                count++;
            }
            if(index<n)
            pq.add(stations[index][1]);
        }
        return count;
    }
}
