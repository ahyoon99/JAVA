package Algorithm;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class B15651 {

    // 방법 1
    // static int[] num = new int[10];
    // public static StringBuilder go(int index, int n, int m){
    //     if(m<=index){
    //         StringBuilder sb = new StringBuilder();
    //         for(int i=0;i<m;i++){
    //             sb.append(num[i]);
    //             if(i != m-1){
    //                 sb.append(" ");
    //             }
    //         }
    //         sb.append("\n");
    //         return sb;
    //     }

    //     StringBuilder ans = new StringBuilder();
    //     for(int i=0;i<n;i++){
    //         num[index]=i+1;
    //         ans.append(go(index+1, n,m));
    //     }
    //     return ans;
    // }
    // public static void main(String args[]){
    //     Scanner sc = new Scanner(System.in);
    //     int n = sc.nextInt();
    //     int m = sc.nextInt();
    //     System.out.println(go(0,n,m));
    // }

    // 방법 2
    static int[] arr = new int[10];
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void go(int index, int n, int m) throws IOException{
        if(index == m){
            for(int i=0;i<m;i++){
                //System.out.print(arr[i]+" ");
                bw.write(arr[i]+" ");
            }
            //System.out.println();
            bw.write("\n");
            return;
        }
        if(index>=m){
            return;
        }
        for(int i=1;i<=n;i++){
            arr[index]=i;
            go(index+1, n,m);
            arr[index]=0;
        }
        return;
    }

    public static void main(String args[]) throws IOException{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        go(0,n,m);
        bw.flush();
    }
}
