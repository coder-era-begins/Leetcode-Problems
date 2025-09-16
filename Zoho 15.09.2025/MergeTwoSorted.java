import java.util.Arrays;
import java.util.Scanner;

class MergeTwoSorted {
    static boolean check(int i,int j,int n1,int n2){
        return i>=0&&i<n1&&j>=0&&j<n2;
    }
    static int[] merge(int arr[],int arr2[],int n1,int n2){
        int i,j;
        int dir1;
        int dir2;
        int arr3[]=new int[n1+n2];
        i=(arr[0]<=arr[n1-1])?0:n1-1;
        dir1=(arr[0]<=arr[n1-1])?1:-1;
        j=(arr2[0]<=arr2[n2-1])?0:n2-1;
        dir2=(arr2[0]<=arr2[n2-1])?1:-1;
        int k=0;
        while(check(i,j,n1,n2)){
            if(arr[i]<=arr2[j]){
                if(k==0||arr3[k-1]!=arr[i]){
                arr3[k++]=arr[i];
                }
                i=i+dir1;
            }
            else{
                if(k==0||arr3[k-1]!=arr2[j]){
                arr3[k++]=arr2[j];
                }
                j=j+dir2;
            }
        }
        while(i>=0&&i<n1){
            if(k==0||arr3[k-1]!=arr[i]){
            arr3[k++]=arr[i];
            }
            i=i+dir1;
        }
        while(j>=0&&j<n2){
            if(k==0||arr3[k-1]!=arr2[j]){
            arr3[k++]=arr2[j];
            }
            j=j+dir2;
        }
        return arr3;
        
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n1=sc.nextInt();
        int n2=sc.nextInt();
        int arr[]=new int[n1];
        int arr2[]=new int[n2];
        for(int index=0;index<n1;index++){
            arr[index]=sc.nextInt();
        }
        for(int index=0;index<n2;index++){
            arr2[index]=sc.nextInt();
        }
        System.out.println(Arrays.toString(merge(arr,arr2,n1,n2)));
    }
}
