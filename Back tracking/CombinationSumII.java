class Solution {
    static Set<List<Integer>> result;
    static List<Integer> tempList;
    static void recursion(int arr[],int index,int n,int sum,int target){
        if(index==n&&sum==target){
            result.add(new ArrayList<>(tempList));
            return;
        }
        if(index==n||sum>target){
            return;
        }
        tempList.add(arr[index]);
        recursion(arr,index+1,n,sum+arr[index],target);
        tempList.remove(tempList.size()-1);
        recursion(arr,index+1,n,sum,target);
    }
    public List<List<Integer>> combinationSum2(int[] arr, int target) {
        result=new LinkedHashSet<>();
        tempList=new ArrayList<>();
        Arrays.sort(arr);
        recursion(arr,0,arr.length,0,target);
        List<List<Integer>> res=new ArrayList<>();
        for(List<Integer> li:result){
            res.add(li);
        }
        return res;
    }
}
