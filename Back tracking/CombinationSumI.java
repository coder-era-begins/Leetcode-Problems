class Solution {
    // Function to find all combinations of elements
    // in array arr that sum to target.
    static ArrayList<ArrayList<Integer>> result;
    static ArrayList<Integer> tempList;
    static void recursion(int arr[],int index,int n,int sum,int target){
        if(index==n&&sum==target){
            result.add(new ArrayList<>(tempList));
            return;
        }
        if(index==n||sum>target){
            return;
        }
        tempList.add(arr[index]);
        recursion(arr,index,n,sum+arr[index],target);
        tempList.remove(tempList.size()-1);
        recursion(arr,index+1,n,sum,target);
    }
    static ArrayList<ArrayList<Integer>> combinationSum(int[] arr, int target) {
        // add your code here
        result=new ArrayList<>();
        tempList=new ArrayList<>();
        recursion(arr,0,arr.length,0,target);
        return result;
    }
}
