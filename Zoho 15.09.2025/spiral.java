public class spiral {
    static Node2 head=new Node2(1);
    static Node2 insertNode2(int value){

        Node2 temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=new Node2(value);
        return temp.next;
    }
    static void formMatrix(int[][] matrix){
        Node2 temp=head;
        int top=0;
        int bottom=matrix.length-1;
        int left=0;
        int right=matrix[0].length-1;
        while(top<=bottom&&left<=right){
            for(int index=left;index<=right;index++){
                matrix[top][index]=(temp==null)?-1:temp.data;
                temp=(temp!=null)?temp.next:temp;
            }
            top++;
            for(int index=top;index<=bottom;index++){
                matrix[index][right]=(temp==null)?-1:temp.data;
                temp=(temp!=null)?temp.next:temp;
            }
            right--;
            if(top<=bottom){
                for(int index=right;index>=left;index--){
                    matrix[bottom][index]=(temp==null)?-1:temp.data;
                    temp=(temp!=null)?temp.next:temp;
                }
            }
            bottom--;
            if(left<=right){
                for(int index=bottom;index>=top;index--){
                    matrix[index][left]=(temp==null)?-1:temp.data;
                    temp=(temp!=null)?temp.next:temp;
                }
            }
            left++;

        }
    }
    public static void main(String[] args) {
    insertNode2(2);
    insertNode2(3);
    insertNode2(4);
    
    
        int matrix[][]=new int[3][2];
        formMatrix(matrix);
        for(int row=0;row<3;row++){
            for(int col=0;col<2;col++){
                System.out.print(matrix[row][col]+" ");
            }
            System.out.println();
        }
    }
}
class Node2{
    int data;
    Node2 next;
    Node2(int data){
        this.data=data;
        this.next=null;
    }
}

