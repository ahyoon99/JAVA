package Algorithm;

import java.util.*;

public class B2579 {
    // 방법 1 : Bottom up
    static public void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] stair = new int[n];
        for(int i=0;i<n;i++){
            stair[i]=sc.nextInt();
        }

        int[][] result = new int[n][2];

        if(n==1){
            System.out.println(stair[0]);
            return;
        }

        result[0][0]=0;
        result[0][1]=stair[0];
        result[1][0]=stair[1];
        result[1][1]=stair[0]+stair[1];

        for(int i=2;i<n;i++){
            result[i][0] = Math.max(result[i-2][0], result[i-2][1]) + stair[i];
            result[i][1] = result[i-1][0] + stair[i];
        }

        int max = (result[n-1][0]>= result[n-1][1]) ? result[n-1][0] : result[n-1][1];
        System.out.println(max);
    }
}
