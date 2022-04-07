package Algorithm;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class B15656 {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void go(int[] num, int[] arr, int index, int n, int m) throws IOException{
        if(index==m){
            for(int i=0;i<m;i++){
                bw.write(arr[i]+" ");
            }
            bw.write("\n");
            return;
        }
        if(index>=n){
            return;
        }
        for(int i=0;i<n;i++){
            arr[index]=num[i];
            go(num,arr,index+1, n,m);
            arr[index]=0;
        }
    }

    public static void main(String args[]) throws IOException{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] num = new int[n];
        int[] arr = new int[m];
        for(int i=0;i<n;i++){
            num[i] = sc.nextInt();
        }
        Arrays.sort(num);
        go(num, arr, 0,n,m);
        bw.flush();
    }
    
}
