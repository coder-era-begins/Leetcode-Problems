class Solution {
    static ArrayList<String> list;
    static void recursion(int index,String str,String res,int n){
        if(index==n){
            list.add(res);
            return;
        }
        if(index==0){
            recursion(index+1,str,res+str.charAt(index),n);
        }
        else{
            recursion(index+1,str,res+" "+str.charAt(index),n);
            recursion(index+1,str,res+str.charAt(index),n);
        }
    }
    ArrayList<String> permutation(String s) {
        // Code Here
        list=new ArrayList<>();
        int n=s.length();
        recursion(0,s,"",n);
        return list;
    }
}
