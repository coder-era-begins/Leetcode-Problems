class Solution {
    public String minWindow(String s, String t) {
        int n1 = s.length();
        int n2 = t.length();
        if(n1==n2){
            if(s.equals(t)){
                return s;
            }
        }
        int counter = n2;
        Map<Character, Integer> tMap = new HashMap<>();
        Map<Character, Integer> sMap = new HashMap<>();
        for (int index = 0; index < n2; index++) {
            tMap.put(t.charAt(index), tMap.getOrDefault(t.charAt(index), 0) + 1);
        }
        int left = 0;
        int minIndex = -1;
        int minLength = Integer.MAX_VALUE;
        for (int right = 0; right < n1; right++) {
            sMap.put(s.charAt(right),sMap.getOrDefault(s.charAt(right),0)+1);
            if(tMap.containsKey(s.charAt(right))&&tMap.get(s.charAt(right))>=sMap.get(s.charAt(right))){
                counter--;
            }
            while(counter==0){
                if(minLength>(right-left+1)){
                    minLength=right-left+1;
                    minIndex=left;
                }
              
                char cLeft = s.charAt(left);
                sMap.put(cLeft, sMap.get(cLeft) - 1);
                if (tMap.containsKey(cLeft) && sMap.get(cLeft) < tMap.get(cLeft)) {
                    counter++;
                }
                left++;

            }
        }
        return minIndex==-1 ? "": s.substring(minIndex,minIndex+minLength);
        
    }
}
