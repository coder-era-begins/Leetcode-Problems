class Solution {
    static int nFactorial(int n){
        int res=1;
        for(int num=n;num>=1;num--){
            res=res*num;
        }
        return res;
    }
    public String getPermutation(int n, int k) {
        ArrayList<Integer> list=new ArrayList<>();
        for(int num=1;num<=n;num++){
            list.add(num);
        }
        int tempK=k-1;
        String result="";
        while(tempK!=0){
            int fact=nFactorial(list.size()-1);
            result+=list.remove(tempK/fact);
            tempK=tempK%fact;
        }
        if(list.size()!=0){
            for(int num:list){
                result+=num;
            }
        }
        return result;
    }
}
