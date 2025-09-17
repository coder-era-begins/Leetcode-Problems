// User function Template for Java

class Solution {
    static ArrayList<Integer> tempList;
    static ArrayList<ArrayList<Integer>> result;
    static int colFlag[];
    static int rowFlag[];
    static int diag1[];
    static int diag2[];
    static void recursion(int board[][],int n,int col){
        if(col==n){
            result.add(new ArrayList<>(tempList));
            return;
        }
        for(int row=0;row<n;row++){
            int curDiag1=row+col;
            int curDiag2=row-col+(n-1);
            if(board[row][col]==0&&colFlag[col]==0&&rowFlag[row]==0&&diag1[curDiag1]==0&&diag2[curDiag2]==0){
                tempList.add(row+1);
                colFlag[col]=1;
                rowFlag[row]=1;
                diag1[curDiag1]=1;
                diag2[curDiag2]=1;
                board[row][col]=1;
                recursion(board,n,col+1);
                tempList.remove(tempList.size()-1);
                colFlag[col]=0;
                rowFlag[row]=0;
                diag1[curDiag1]=0;
                diag2[curDiag2]=0;
                board[row][col]=0;
            }
        }
    }
    public ArrayList<ArrayList<Integer>> nQueen(int n) {
        // code here
        tempList=new ArrayList<>();
        result=new ArrayList<>();
        int board[][]=new int[n][n];
        colFlag=new int[n];
        rowFlag=new int[n];
        diag1=new int[2*n-1];
        diag2=new int[2*n-1];
        recursion(board,n,0);
        return result;
    }
}
