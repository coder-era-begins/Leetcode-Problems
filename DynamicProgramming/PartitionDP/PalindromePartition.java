class Solution {
    static int dp[];
    static boolean isPalindrome(String subString,int i,int j){
        if(i>=j){
            return true;
        }
        if(subString.charAt(i)==subString.charAt(j)){
            return isPalindrome(subString,i+1,j-1);
        }
        else{
            return false;
        }
    }
    static int recursion(int index,String s,int n){
        if(index>n-1){
            return 0;
        }
        if(dp[index]!=-1){
            return dp[index];
        }
        int count=Integer.MAX_VALUE;
        for(int k=index;k<n;k++){
            if(isPalindrome(s,index,k)){
                int currentcut=recursion(k+1,s,n);
                if(currentcut!=Integer.MAX_VALUE){
                    currentcut=1+currentcut;
                }
                count=Math.min(currentcut,count);
            }
        }
        return dp[index]=count;
    }
    public int minCut(String s) {
        dp=new int[s.length()+1];
        Arrays.fill(dp,-1);
        return recursion(0,s,s.length())-1;
    }
}
