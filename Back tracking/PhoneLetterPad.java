class Solution {
    static ArrayList<String> result;
    static void recursion(int index,int arr[],Map<Integer,String> map,int n,String word){
        if(index==n){
            result.add(word);
            return;
        }
        if(!map.containsKey(arr[index])){
            recursion(index+1,arr,map,n,word);
        }
        else{
        String currentStr=map.get(arr[index]);
        for(int i=0;i<currentStr.length();i++){
            char ch=currentStr.charAt(i);
            recursion(index+1,arr,map,n,word+ch);
        }
        }
    }
    public ArrayList<String> possibleWords(int[] arr) {
        // code here
        Map<Integer,String> map=new HashMap<>();
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");
        result=new ArrayList<>();
        recursion(0,arr,map,arr.length,"");
        return result;
    }
}
