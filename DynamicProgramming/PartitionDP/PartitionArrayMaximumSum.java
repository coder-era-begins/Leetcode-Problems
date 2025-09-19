class Solution {
    static int dp[];
    static int recursion(int index,int[] arr,int k,int n){
        if(index>n-1){
            return 0;
        }
        if(dp[index]!=-1){
            return dp[index];
        }
        int maxPartition=0;
        int maxNum=0;
        for(int j=index;j<index+k;j++){
            if(j<n){
            maxNum=Math.max(maxNum,arr[j]);
            int currentPartition=maxNum*(j-index+1)+recursion(j+1,arr,k,n);
            maxPartition=Math.max(currentPartition,maxPartition);
            }
        }
        return dp[index]=maxPartition;
    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n=arr.length;
        dp=new int[n+1];
        Arrays.fill(dp,-1);
        return recursion(0,arr,k,arr.length);
    }
}
