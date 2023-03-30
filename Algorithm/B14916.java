package Algorithm;

import java.util.*;

public class B14916 {
    // 방법 1 : Bottom up
    // static public void main(String args[]){
    //     Scanner sc = new Scanner(System.in);
    //     int n = sc.nextInt();
    //     int[] dp = new int[100001];
    //     dp[2]=1;
    //     dp[4]=2;
    //     dp[5]=1;
    //     for(int i=6;i<=n;i++){
    //         if(dp[i-2]==0){
    //             dp[i]=dp[5]+dp[i-5];
    //         }
    //         else if(dp[i-5]==0){
    //             dp[i]=dp[2]+dp[i-2];
    //         }
    //         else{
    //             dp[i]=Math.min((dp[2]+dp[i-2]),(dp[5]+dp[i-5]));
    //         }
    //     }

    //     if(dp[n]==0){
    //         System.out.println(-1);
    //     }
    //     else{
    //         System.out.println(dp[n]);
    //     }
    // }

    // 방법 2 : Top-down
    static public void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] result = new int[n+1];
        Arrays.fill(result, -1);
        int answer = go(result, n);
        if(answer==0){
            System.out.println(-1);
        }
        else{
            System.out.println(answer);
        }
    }

    static int go(int[] result, int n){
        if(result[n]!=-1){
            return result[n];
        }
        else if(n==1 || n==3){
            result[n]=0;
            return result[n];
        }
        else if(n==2 || n==5){
            result[n]=1;
            return result[n];
        }
        else if(n==4){
            result[n]=2;
            return result[n];
        }
        int num1 = go(result, n-2);
        int num2 = go(result, n-5);
        if(num1==0){
            result[n] = go(result, 5)+num2;
            return result[n];
        }
        else if(num2==0){
            result[n] = go(result, 2)+num1;
            return result[n];
        }
        else{
            result[n] = Math.min(go(result, 2)+go(result, n-2), go(result, 5)+go(result,n-5));
            return result[n];
        }
    }
}
