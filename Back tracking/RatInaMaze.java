class Solution {
    // Function to find all possible paths
    static int diff[][]={{0,1},{1,0},{0,-1},{-1,0}};
    static String dir[]={"R","D","L","U"};
    static ArrayList<String> ans;
    public ArrayList<String> ratInMaze(int[][] maze) {
        // code here
        ans=new ArrayList<>();
        int n=maze.length;
        maze[0][0]=0;
        dfs(maze,0,0,"",n,ans);
        Collections.sort(ans);
        return ans;
    }
    static boolean isvalid(int r,int c,int n){
        return r>=0&&r<n&&c>=0&&c<n;
    }
    static void dfs(int maze[][],int row,int col,String path,int n,List<String> ans){
        if(row==n-1&&col==n-1){
            ans.add(path);
            return;
        }
        for(int index=0;index<4;index++){
            int newrow=row+diff[index][0];
            int newcol=col+diff[index][1];
            if(isvalid(newrow,newcol,n)&&maze[newrow][newcol]==1){
                maze[newrow][newcol]=0;
                dfs(maze,newrow,newcol,path+dir[index],n,ans);
                maze[newrow][newcol]=1;
            }
        }
    }
    
}
