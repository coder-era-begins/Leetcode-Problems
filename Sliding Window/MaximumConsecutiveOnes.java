class Solution {
    public int longestOnes(int[] nums, int k) {
        if(k==0){
            int cnt=0;
            for(int index=0;index<nums.length;index++){
                if(nums[index]==0){
                    cnt++;
                }
            }
            if(cnt==nums.length){
                return 0;
            }
        }
        int n=nums.length;
        int left=0;
        int zerosCnt=0;
        int maxLength=0;
        for(int right=0;right<n;right++){
            if(nums[right]==0){
                zerosCnt++;
            }
            if(zerosCnt>k){
                while(left<right&&nums[left]==1){
                    left++;
                }
                if(left<right){
                left++;
                zerosCnt--;
                }
            }
            maxLength=Math.max(maxLength,right-left+1);
        }
        return maxLength;
    }
}
