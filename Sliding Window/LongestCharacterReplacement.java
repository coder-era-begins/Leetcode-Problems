class Solution {
    public int characterReplacement(String s, int k) {
        int n=s.length();
        int left=0;
        int freq[]=new int[256];
        int maxLength=0;
        for(int right=0;right<n;right++){
            char currentChar=s.charAt(right);
            freq[currentChar]++;
            int maxFreq=0;
            int windowSize=right-left+1;
            for(int index=0;index<256;index++){
                maxFreq=Math.max(maxFreq,freq[index]);
            }
            while(windowSize-maxFreq>k){
                freq[s.charAt(left)]--;
                left++;
                for(int index=0;index<256;index++){
                    maxFreq=Math.max(maxFreq,freq[index]);
                }
                windowSize=right-left+1;
            }
            maxLength=Math.max(maxLength,right-left+1);
        }
        return maxLength;
    }
}
