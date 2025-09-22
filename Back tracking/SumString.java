class Solution {
    static ArrayList<String> list;
    static boolean recursion(String s,int index,int n,int cnt){
        if(index>=n){
            return cnt>=3;
        }
        for(int j=index;j<n;j++){
            if(j-index+1>1 && s.charAt(index)=='0') return false;
            if(cnt<2){
                String subStr=s.substring(index,j+1);
                list.add(subStr);
                if(recursion(s,j+1,n,cnt+1)){
                    return true;
                }
                list.remove(list.size()-1);
            }
            else{
                long firstNum=Long.parseLong(list.get(list.size()-1));
                long secondNum=Long.parseLong(list.get(list.size()-2));
                String subStr=s.substring(index,j+1);
                long currentNum=Long.parseLong(subStr);
                list.add(subStr);
                if(firstNum+secondNum==currentNum && recursion(s,j+1,n,cnt+1)){
                    return true;
                }
                list.remove(list.size()-1);
            }
        }
        return false;
    }
    public boolean isSumString(String s) {
        // code here
        int n=s.length();
        list=new ArrayList<>();
        return recursion(s,0,n,0);
    }
}
