class Solution {
    public static int minCost(int[] arr) {
        // code here
        int n=arr.length;
        PriorityQueue<Integer> queue=new PriorityQueue<>();
        for(int index=0;index<n;index++){
            queue.add(arr[index]);
        }
        int sum=0;
        while(true){
            int first=queue.poll();
            if(!queue.isEmpty()){
                break;
            }
            int second=queue.poll();
            int res=first+second;
            queue.add(res);
            sum=sum+res;
        }
        return sum;
    }
}
