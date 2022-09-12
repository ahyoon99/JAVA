package Algorithm;

import java.util.Scanner;

public class B10844 {

    // 방법 1 : Bottom-Up
    // static public void main(String args[]){
    //     Scanner sc = new Scanner(System.in);
    //     int n = sc.nextInt();
    //     int[][] num = new int[n+1][10];
    //     for(int i=1;i<=9;i++){
    //         num[1][i]=1;
    //     }
    //     for(int i=2;i<=n;i++){
    //         for(int j=0;j<=9;j++){
    //             if(j==0){
    //                 num[i][j]=num[i-1][1];
    //             }
    //             else if(j==9){
    //                 num[i][j]=num[i-1][8];
    //             }
    //             else{
    //                 num[i][j]= (num[i-1][j-1]+num[i-1][j+1]) % 1000000000;
    //             }
    //         }
    //     }
    //     long result = 0;
    //     for(int i=0;i<=9;i++){
    //         result = (result + num[n][i]) % 1000000000;
    //     }
    //     System.out.println(result);
    // }

    // 방법 2 : Top down
    static long[][] answer = new long[101][10];

    static long go(int n, int x){
        if(answer[n][x]>0){
            return answer[n][x];
        }
        if(n==1 && x==0){
            return 0;
        }
        if(x==0){
            answer[n][x]=(go(n-1,1)%1000000000);
            return answer[n][x];
        }
        if(x==9){
            answer[n][x]=(go(n-1,8)%1000000000);
            return answer[n][x];
        }
        answer[n][x]=(go(n-1,x-1)+go(n-1,x+1))%1000000000;
        return answer[n][x];
    }

    static public void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=1;i<10;i++){
            answer[1][i]=1;
        }
        for(int i=0;i<10;i++){
            go(n,i);
        }
        long result = 0;
        for(int i=0;i<10;i++){
            result = (result + answer[n][i])%1000000000;
        }
        System.out.println(result);
    }
}
