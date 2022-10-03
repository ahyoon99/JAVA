package Algorithm;

import java.util.*;

public class B11055 {
    // 방법 1 : Bottom up
    // static public void main(String args[]){
    //     Scanner sc = new Scanner(System.in);
    //     int n = sc.nextInt();
    //     int[] num = new int[n];
    //     for(int i=0;i<n;i++){
    //         num[i] = sc.nextInt();
    //     }
    //     int[] distance = new int[n];
    //     int[] sum = new int[n];

    //     Arrays.fill(sum,-1);

    //     distance[0]=1;
    //     sum[0]=num[0];

    //     for(int i=1;i<n;i++){
    //         sum[i]=num[i];
    //         for(int j=i-1;j>=0;j--){
    //             if(num[j]<num[i] && sum[i]<sum[j]+num[i]){
    //                 sum[i]=sum[j]+num[i];
    //             }
    //         }
    //     }
    //     Arrays.sort(sum);
    //     System.out.println(sum[n-1]);
    // }

    // 방법 2 : Top down
    static int go(int[] num, int[] sum, int n){
        if(sum[n]!=-1){
            return sum[n];
        }
        for(int i=0;i<n;i++){
            int maxNum = go(num, sum, i);
            if(num[i]<num[n] && sum[n]<maxNum+num[n]){
                sum[n]= maxNum+num[n];
            }
        }
        if(sum[n]==-1){
            sum[n]=num[n];
        }
        return sum[n];
    }

    static public void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] num = new int[n];
        for(int i=0;i<n;i++){
            num[i]=sc.nextInt();
        }

        int[] sum = new int[n];
        Arrays.fill(sum, -1);
        sum[0]=num[0];
        
        go(num, sum, n-1);
        Arrays.sort(sum);
        System.out.println(sum[n-1]);
    }
}
