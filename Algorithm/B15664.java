package Algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class B15664 {
    public static void go(int[] num, int[] arr, int[] num_cnt, int index, int start, int n, int m){
        if(index==m){
            for(int i=0;i<m;i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            return;
        }
        for(int i=start;i<n;i++){
            if(num_cnt[i]>0){
                num_cnt[i]--;
                arr[index]=num[i];
                go(num, arr, num_cnt, index+1, i, n, m);
                num_cnt[i]++;
                arr[index]=0;
            }
        }
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc. nextInt();
        int[] num = new int[n];
        
        for(int i=0;i<n;i++){
            num[i]=sc.nextInt();
        }
        Arrays.sort(num);

        int cnt=1;
        int[] after_num = new int[n];
        int[] after_num_cnt = new int[n];
        after_num[0]=num[0];
        after_num_cnt[0]=1;
        for(int i=1;i<n;i++){
            if(num[i-1]==num[i]){
                after_num_cnt[cnt-1]++;
                continue;
            }
            else{
                after_num[cnt]=num[i];
                after_num_cnt[cnt]++;
                cnt++;
            }
        }

        int[] arr = new int[m];
        go(after_num, arr, after_num_cnt, 0, 0, cnt, m);
    }
    
}
