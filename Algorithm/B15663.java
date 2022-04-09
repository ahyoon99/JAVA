package Algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class B15663 {
    public static void go(int[] num, int[] arr, int[] cnt, int index, int n, int m){
        if(index==m){
            for(int i=0;i<m;i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            return;
        }        
        if(index>=m){
            return;
        }
        for(int i=0;i<n;i++){
            if(cnt[i]>0){
                cnt[i]--;
                arr[index]=num[i];
                go(num,arr,cnt,index+1, n,m);
                arr[index]=0;
                cnt[i]++;
            }
        }
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n =  sc.nextInt();
        int m = sc.nextInt();
        int[] num = new int[n];
        for(int i=0;i<n;i++){
            num[i]=sc.nextInt();
        }
        Arrays.sort(num);

        int[] after_num = new int[n];
        int[] cnt = new int[n];
        int count=0;
        after_num[0]=num[0];
        cnt[0]=1;
        for(int i=1;i<n;i++){
            if(num[i-1]==num[i]){
                cnt[count]++;
            }
            else{
                count++;
                after_num[count]=num[i];
                cnt[count]++;
                
            }
        }

        int[] arr = new int[m];
        count++;
        go(after_num, arr, cnt, 0,count,m);
        
        return ;
    }
    
}
