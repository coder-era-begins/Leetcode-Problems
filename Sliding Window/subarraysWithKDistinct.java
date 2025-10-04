class Solution {
   public int SubArraysWithAtMost(int[] nums,int k){
        int n=nums.length;
		Map<Integer,Integer> map=new HashMap<>();
		int left=0;
		int maxLen=0;
		for(int right=0;right<n;right++){
			map.put(nums[right],map.getOrDefault(nums[right],0)+1);
			while(map.size()>k){
				map.put(nums[left],map.get(nums[left])-1);
				if(map.get(nums[left])==0){
					map.remove(nums[left]);
				}
				left++;
			}
			maxLen+=((right-left)+1);
		}
		return maxLen;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        return SubArraysWithAtMost(nums,k)-SubArraysWithAtMost(nums,k-1);
    }
}
