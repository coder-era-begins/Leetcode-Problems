        
public class Solution {
    static int SubArrayCount(int[] nums,int k){
        int left=0;
        int oddCount=0;
        int count=0;
        int n=nums.Length;
        for(int right=0;right<n;right++){
            if(nums[right]%2==1){
                oddCount++;
            }
            while(oddCount>k){
                if(nums[left]%2==1){
                    oddCount--;
                }
                left++;
            }
            count+=(right-left+1);
        }
        return count;
    }
    public int NumberOfSubarrays(int[] nums, int k) {
        return SubArrayCount(nums,k)-SubArrayCount(nums,k-1);
        
    }
}
