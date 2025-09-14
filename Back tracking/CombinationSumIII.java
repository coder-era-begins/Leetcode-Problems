class Solution {
    static List<List<Integer>> result;
    static List<Integer> tempList;
    static void recursion(int index,int sum,int cnt,int k,int target){
        if(cnt==k&&index==10&&sum==target){
            result.add(new ArrayList<>(tempList));
            return;
        }
        if(cnt>k||index==10||sum>target){
            return;
        }
        tempList.add(index);
        recursion(index+1,sum+index,cnt+1,k,target);
        tempList.remove(tempList.size()-1);
        recursion(index+1,sum,cnt,k,target);
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        result=new ArrayList<>();
        tempList=new ArrayList<>();
        recursion(1,0,0,k,n);
        return result;
    }
}
