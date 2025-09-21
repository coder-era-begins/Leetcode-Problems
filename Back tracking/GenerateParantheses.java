class Solution {
    static ArrayList<String> list;
    static void recursion(String result,int openCnt,int closeCnt,int n){
        if(openCnt+closeCnt==2*n){
            list.add(result);
            return;
        }
        if(openCnt<n){
            recursion(result+"(",openCnt+1,closeCnt,n);
        }
        if(closeCnt<openCnt){
            recursion(result+")",openCnt,closeCnt+1,n);
        }
    }
    public ArrayList<String> generateParentheses(int n) {
        // code here
        list=new ArrayList<>();
        recursion("",0,0,n/2);
        return list;
    }
}
