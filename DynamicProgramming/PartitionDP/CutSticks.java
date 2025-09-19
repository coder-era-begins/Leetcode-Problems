class Solution {
    static int dp[][];
    static int recursion(int cuts[],int n,int i,int j){
        if(i+1==j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int cost=Integer.MAX_VALUE;
        for(int index=0;index<n;index++){
            if(cuts[index]>i&&cuts[index]<j){
                int curcost=(j-i)+recursion(cuts,n,cuts[index],j)+recursion(cuts,n,i,cuts[index]);
                cost=Math.min(cost,curcost);
            }
        }
        return dp[i][j]=(cost==Integer.MAX_VALUE) ? 0 : cost;
    }
    public int minCost(int n, int[] cuts) {
        dp=new int[n+1][n+1];
        for(int row=0;row<=n;row++){
            Arrays.fill(dp[row],-1);
        }
        return recursion(cuts,cuts.length,0,n);
    }
}
