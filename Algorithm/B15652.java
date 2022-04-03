package Algorithm;

import java.util.Scanner;

public class B15652 {

    static int[] arr = new int[10];

    public static void go(int index, int start, int n, int m){
        if(index==m){
            for(int i=0;i<m;i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            return;
        }
        if(index>m){
            return;
        }

        for(int i=start;i<=n;i++){
            arr[index]=i;
            go(index+1, i, n,m);
            arr[index]=0;
        }

    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        go(0,1,n,m);

        return;
    }
    
}
