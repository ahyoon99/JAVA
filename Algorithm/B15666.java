package Algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class B15666 {
    public static void go(int[] num, int[] arr, int start, int index, int n, int m){
        if(index==m){
            for(int i=0;i<m;i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            return;
        }
        for(int i=start;i<n;i++){
            arr[index]=num[i];
            go(num, arr, i, index+1, n,m);
            arr[index]=0;
        }
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] num = new int[n];
        for(int i=0;i<n;i++){
            num[i]=sc.nextInt();
        }
        Arrays.sort(num);

        int[] after_num = new int[n];
        after_num[0]=num[0];
        int cnt=1;
        for(int i=1;i<n;i++){
            if(num[i-1]==num[i]){
                continue;
            }
            else{
                after_num[cnt]=num[i];
                cnt++;
            }
        }

        int[] arr = new int[m];
        //boolean[] check = new boolean[n];
        go(after_num, arr, 0, 0, cnt, m);

        return;
    }
    
}
