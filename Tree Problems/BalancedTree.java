class Solution {
    static int height(TreeNode root){
       if(root==null){
            return 0;
        }
        int left=1+height(root.left);
        int right=1+height(root.right);
        return Math.max(left,right);
    }
    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }
        int leftSub=height(root.left);
        int rightSub=height(root.right);
        if(Math.abs(leftSub-rightSub)>1){
            return false;
        }
        return isBalanced(root.right) && isBalanced(root.left);
    }
}
