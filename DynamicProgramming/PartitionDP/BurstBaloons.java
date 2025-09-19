class Solution {
    static int dp[][];
    static int recursion(int nums[],int i,int j){
        if(i+1==j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int coins=0;
        for(int k=i+1;k<j;k++){
            int currentCoins=nums[i]*nums[j]*nums[k]+recursion(nums,i,k)+recursion(nums,k,j);
            coins=Math.max(coins,currentCoins);
        }
        return dp[i][j]=coins;
    }
    public int maxCoins(int[] nums) {
        int n=nums.length;
        int newnums[]=new int[n+2];
        dp=new int[n+2][n+2];
        for(int row=0;row<=n+1;row++){
            Arrays.fill(dp[row],-1);
        }
        newnums[0]=1;
        newnums[n+1]=1;
        for(int index=1;index<=n;index++){
            newnums[index]=nums[index-1];
        }
        return recursion(newnums,0,n+1);
    }
}
