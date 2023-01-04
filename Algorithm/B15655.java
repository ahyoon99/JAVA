package Algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class B15655 {

    // 방법 1
    // static int[] num;
    // static int[] arr;
    // static boolean[] check;

    // public static void go(int index, int start, int n, int m){
    //     if(index==m){
    //         for(int i=0;i<m;i++){
    //             System.out.print(arr[i]+" ");
    //         }
    //         System.out.println();
    //         return;
    //     }
    //     for(int i=start;i<n;i++){
    //         if(check[i]){
    //             continue;
    //         }
    //         else{
    //             check[i]=true;
    //             arr[index]=num[i];
    //             go(index+1, i+1, n,m);
    //             check[i]=false;
    //             arr[index]=0;
    //         }
    //     }
    // }
    // public static void main(String args[]){
    //     Scanner sc = new Scanner(System.in);

    //     int n = sc.nextInt();
    //     int m = sc.nextInt();

    //     num = new int[n];
    //     arr = new int[m];
    //     check = new boolean[n];
        
    //     for(int i=0;i<n;i++){
    //         num[i]=sc.nextInt();
    //     }
    //     Arrays.sort(num);
    //     go(0,0, n,m);
    // }

    // 방법 2
    static void go(int[] num, int[] result, int start, int idx){
        if(idx==result.length){
            for(int i=0;i<result.length;i++){
                System.out.print(result[i]+" ");
            }
            System.out.println();
            return;
        }
        if(start>=num.length){
            return;
        }
        for(int i=start;i<num.length;i++){
            result[idx]=num[i];
            go(num, result, i+1, idx+1);
            
        }
        
    }
    static public void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] num = new int[n];
        for(int i=0;i<n;i++){
            num[i]=sc.nextInt();
        }
        Arrays.sort(num);

        int[] result = new int[m];
        go(num, result, 0,0);

    }
    
}
