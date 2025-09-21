import java.util.ArrayList;
import java.util.Scanner;
class StringChain{
    static ArrayList<Integer> list;
    static ArrayList<Integer> result;
    static int visited[];
    static void stringChain(String arr[],int index,int n){
        visited[index]=1;
        list.add(index);
        if(list.size()==n){
            result=new ArrayList<Integer>(list);
        }
        for(int i=0;i<n;i++){
            if(visited[i]==0 && arr[index].charAt(arr[index].length()-1)==arr[i].charAt(0)){
                stringChain(arr,i,n);
            }
        }
        visited[index]=0;
        list.remove(list.size()-1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();
        String arr[]=new String[n];
        for(int i=0;i<n;i++) {
            arr[i] = sc.nextLine();
        }
        list=new ArrayList<Integer>();
        result=new ArrayList<Integer>();
        for(int i=0;i<n;i++){
            visited=new int[n];
            stringChain(arr,i,n);
        }
        for(int num:result){
            System.out.print(num+" ");
        }

    }
}
