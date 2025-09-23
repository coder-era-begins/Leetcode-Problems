class Solution {
    public int totalFruit(int[] fruits) {
        int n=fruits.length;
        int left=0;
        Map<Integer,Integer> map=new HashMap<>();
        int maxLength=0;
        for(int right=0;right<n;right++){
            map.put(fruits[right],right);
            if(map.size()>2){
                int minIndex=n;
                for(int num:map.keySet()){
                    minIndex=Math.min(minIndex,map.get(num));
                }
                left=minIndex+1;
                map.remove(fruits[minIndex]);
            }
            maxLength=Math.max(right-left+1,maxLength);
        }
        return maxLength;
    }
}
