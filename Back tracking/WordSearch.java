class Solution {
    static boolean visited[][];
    static int R;
    static int C;
    static int dir[][]={{0,1},{1,0},{0,-1},{-1,0}};
    static boolean isValid(int row,int col){
        return row<R&&col<C&&row>=0&&col>=0;
    }
    static boolean dfs(int row,int col,String word,int index,int n,char board[][]){
        if(index==n-1){
            return true;
        }
        visited[row][col]=true;
        for(int dirs[]:dir){
            int nextrow=row+dirs[0];
            int nextcol=col+dirs[1];
            if(isValid(nextrow,nextcol)&&!visited[nextrow][nextcol]&&board[nextrow][nextcol]==word.charAt(index+1)){
                if(dfs(nextrow,nextcol,word,index+1,n,board)){
                    return true;
                }
            }
        }
        visited[row][col]=false;
        return false;
    }
    public boolean exist(char[][] board, String word) {
        R=board.length;
        C=board[0].length;
        visited=new boolean[R+1][C+1];
        int n=word.length();
        boolean result=false;
        for(int row=0;row<R;row++){
            for(int col=0;col<C;col++){
                if(word.charAt(0)==board[row][col])
                result=result || dfs(row,col,word,0,n,board);
            }
        }
        return result;
    }
}
