package Algorithm;

import java.util.*;

public class B2225 {
    // 방법 1 : Bottom up
    // static public void main(String args[]){
    //     Scanner sc = new Scanner(System.in);
    //     int n = sc.nextInt();
    //     int k = sc.nextInt();
    //     long[][] result = new long[n+1][k+1];
    //     for(int i=0;i<=k;i++){
    //         result[0][i]=1;
    //         result[1][i]=i;
    //     }
    //     for(int i=2;i<=n;i++){
    //         result[i][1]=1;
    //     }

    //     for(int i=2;i<=n;i++){
    //         for(int j=2;j<=k;j++){
    //             long med = 0;
    //             for(int l=0;l<=i;l++){
    //                 med=(med+result[i-l][j-1])%1000000000;
    //             }
    //             result[i][j]=med;
    //         }
    //     }
    //     System.out.println(result[n][k]);
    // }   
    
    // 방법 2 : Top down
    static long[][] result;
    static public void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        result = new long[201][201];
        for(int i=0;i<201;i++){
            Arrays.fill(result[i],-1);
        }
        System.out.println(go(n,k));
    }

    static long go(int n, int k){
        if(result[n][k]!=-1){
            return result[n][k];
        }
        if(n==0){
            result[n][k]=1;
            return result[n][k];
        }
        if(n==1){
            result[n][k]=k;
            return result[n][k];
        }
        if(k==0){
            result[n][k]=0;
            return result[n][k];
        }
        if(k==1){
            result[n][k]=1;
            return result[n][k];
        }
        long answer=0L;
        for(int i=0;i<=n;i++){
            answer=(answer+go(i,k-1))%1000000000;
        }
        result[n][k]=answer;
        return answer;
    }
}
