class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map=new HashMap<>();
        int n=s.length();
        int left=0;
        int length=0;
        for(int right=0;right<n;right++){
            char currentChar=s.charAt(right);
            if(!map.containsKey(currentChar))
            map.put(currentChar,right);
            else{
                if(map.get(currentChar)>=left){
                    left=map.get(currentChar)+1;
                }
                map.put(currentChar,right);
            }
            length=Math.max(length,right-left+1);
        }
        return length;
    }
}
