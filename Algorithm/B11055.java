package Algorithm;

import java.util.*;

public class B11055 {
    // 방법 1 : Bottom up
    static public void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] num = new int[n];
        for(int i=0;i<n;i++){
            num[i] = sc.nextInt();
        }
        int[] distance = new int[n];
        int[] sum = new int[n];

        Arrays.fill(sum,-1);

        distance[0]=1;
        sum[0]=num[0];

        for(int i=1;i<n;i++){
            sum[i]=num[i];
            for(int j=i-1;j>=0;j--){
                if(num[j]<num[i] && sum[i]<sum[j]+num[i]){
                    sum[i]=sum[j]+num[i];
                }
            }
        }
        Arrays.sort(sum);
        System.out.println(sum[n-1]);
    }
}
