import java.util.*;
public class Solution {

	public static int kDistinctChars(int k, String str) {
		// Write your code here
		int n=str.length();
		Map<Character,Integer> map=new HashMap<>();
		int left=0;
		int maxLen=0;
		for(int right=0;right<n;right++){
			map.put(str.charAt(right),map.getOrDefault(str.charAt(right),0)+1);
			while(map.size()>k){
				map.put(str.charAt(left),map.get(str.charAt(left))-1);
				if(map.get(str.charAt(left))==0){
					map.remove(str.charAt(left));
				}
				left++;
			}
			maxLen=Math.max(maxLen,right-left+1);
		}
		return maxLen;
	}

}
