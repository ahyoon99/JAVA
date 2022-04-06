package Algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class B15655 {

    static int[] num;
    static int[] arr;
    static boolean[] check;

    public static void go(int index, int start, int n, int m){
        if(index==m){
            for(int i=0;i<m;i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            return;
        }
        for(int i=start;i<n;i++){
            if(check[i]){
                continue;
            }
            else{
                check[i]=true;
                arr[index]=num[i];
                go(index+1, i+1, n,m);
                check[i]=false;
                arr[index]=0;
            }
        }
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        num = new int[n];
        arr = new int[m];
        check = new boolean[n];
        
        for(int i=0;i<n;i++){
            num[i]=sc.nextInt();
        }
        Arrays.sort(num);
        go(0,0, n,m);
    }
    
}
