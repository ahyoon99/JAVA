package Algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class B2193 {
    // 방법 1 : Bottom-up
    // static public void main(String args[]){
    //     Scanner sc = new Scanner(System.in);
    //     int n = sc.nextInt();
    //     long[][] num = new long[n+1][2];
    //     num[1][0]=0;
    //     num[1][1]=1;
    //     for(int i=2;i<=n;i++){
    //         for(int j=0;j<=1;j++){
    //             if(j==0){
    //                 num[i][j]=num[i-1][0]+num[i-1][1];
    //             }
    //             else if(j==1){
    //                 num[i][j]=num[i-1][0];
    //             }
    //         }
    //     }
    //     long result = 0;
    //     for(int i=0;i<=1;i++){
    //         result += num[n][i];
    //     }
    //     System.out.println(result);
    // }

    // 방법 2 : Top-down
    static long[][] answer = new long[91][2];
    static long go(int n, int x){
        if(answer[n][x]!=-1){
            return answer[n][x];
        }
        if(n-1==0){
            answer[n][x]=0;
            return answer[n][x];
        }
        if(x==0){
            answer[n][x]=go(n-1,0)+go(n-1,1);
            return answer[n][x];
        }
        if(x==1){
            answer[n][x]=go(n-1,0);
            return answer[n][x];
        }
        return answer[n][x];
    }
    static public void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        for(int i=0;i<answer.length;i++){
            Arrays.fill(answer[i], -1);
        }
        answer[1][0]=0;
        answer[1][1]=1;

        for(int i=0;i<2;i++){
            go(n,i);
        }

        long result=answer[n][0]+answer[n][1];
        System.out.println(result);
    }
}
