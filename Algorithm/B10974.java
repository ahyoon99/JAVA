package Algorithm;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class B10974 {

    // 방법 1
    // public static void main(String args[]){
    //     Scanner sc = new Scanner(System.in);
    //     int n = sc.nextInt();
    //     int[] arr = new int[n];
    //     int cnt = 1;
    //     for(int i=0, j=n;i<n;i++,j--){
    //         arr[i]=i+1;
    //         cnt*=j;
    //     }

    //     for(int i=0;i<cnt;i++){
    //         if(i==0){
    //             for(int t=0;t<n;t++){
    //                 System.out.print(arr[t]+" ");
    //             }
    //             System.out.println();
    //             continue;
    //         }
    //         int j=n-1;
    //         while(j>0 && arr[j-1]>arr[j]){
    //             j--;
    //         }
    //         int k=n-1;
    //         while(k>0 && arr[k]<arr[j-1]){
    //             k--;
    //         }
    //         int temp = arr[j-1];
    //         arr[j-1]=arr[k];
    //         arr[k]=temp;
    //         Arrays.sort(arr, j,n);
    //         for(int t=0;t<n;t++){
    //             System.out.print(arr[t]+" ");
    //         }
    //         System.out.println();
    //     }
    // }

    // 방법 2 : 순열 (DFS를 이용해 구현)
    static void go(boolean[] visited, int[] result, int n, int idx){
        if(idx==n){
            // [출력 하기]
            // ** System.out.println()로 출력하면 느리다 **
            // for(int i=0;i<n;i++){
            //     System.out.print(result[i]+" ");
            // }
            // System.out.println();

            // ** 여러줄을 한번에 출력할 때는 System.out.println()보다는 StringBuilder를 사용해라 **
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<n;i++){
                 sb.append(result[i]).append(" ");
            }
            System.out.println(sb);
        }
        if(idx>=n){
            return;
        }
        for(int i=0;i<n;i++){
            if(visited[i]==false){
                visited[i]=true;
                result[idx]=i+1;
                go(visited, result, n, idx+1);
                visited[i]=false;
            }
        }
    }
    static public void main(String args[]) throws Exception{
        // [입력 받기]
        // ** Scanner로 입력을 받으면 느리다 **
        // Scanner sc = new Scanner(System.in);
        // int n = sc.nextInt();

        // ** 시간 초과를 해결하기 위해서는 BufferedReader를 사용해라 **
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        boolean[] visited = new boolean[n];
        int[] result = new int[n];
        go(visited, result, n, 0);
    }
}
