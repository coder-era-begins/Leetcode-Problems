//Greedy 
class Solution {
    public int minMeetingRooms(int[] start, int[] end) {
        // code here
        int n=start.length;
        Arrays.sort(start);
        Arrays.sort(end);
        int i=0;
        int j=0;
        int res=0;
        int count=0;
        while(i<n&&j<n){
            if(start[i]<end[j]){
                count++;
                i++;
            }
            else{
                count--;
                j++;
            }
            res=Math.max(res,count);
        }
        return res;
    }
}
