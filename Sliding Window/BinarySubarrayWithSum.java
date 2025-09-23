class Solution {
    static int goalFinder(int[] nums,int goal){
        int n=nums.length;
        int left=0;
        int count=0;
        int sum=0;
        for(int right=0;right<n;right++){
            sum+=nums[right];
            while(sum>goal){
                sum-=nums[left++];
            }
            count+=(right-left+1);
        }
        return count;
    }
    public int numSubarraysWithSum(int[] nums, int goal) {
        if(goal==0){
            return goalFinder(nums,goal);
        }
        return goalFinder(nums,goal)-goalFinder(nums,goal-1);
    }
}
