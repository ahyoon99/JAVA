package Algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class B15990 {
    // 1. Bottom-up
    // static public void main(String args[]){
    //     Scanner sc = new Scanner(System.in);
    //     long[][] result = new long[100001][4];
    //     result[1][1]=1;
    //     result[2][2]=1;
    //     result[3][1]=1;
    //     result[3][2]=1;
    //     result[3][3]=1;
    //     for(int j=4;j<100001;j++){
    //         result[j][1]=(result[j-1][2]+result[j-1][3])%1000000009;
    //         result[j][2]=(result[j-2][1]+result[j-2][3])%1000000009;
    //         result[j][3]=(result[j-3][1]+result[j-3][2])%1000000009;
    //     }

    //     int cnt = sc.nextInt();
    //     for(int i=0;i<cnt;i++){
    //         int num = sc.nextInt();
    //         System.out.println((result[num][1]+result[num][2]+result[num][3])%1000000009);
    //     }   
    // }

    // 2. Top-down
    static long go(int n,int m, long[][] result){
        if(result[n][m]!=-1){
            return result[n][m];
        }
        else if(n==1){
            if(m==1){
                result[n][m]=1;
                return 1;
            }
            else{
                result[n][m]=0;
                return 0;
            }
        }
        else if(n==2){
            if(m==2){
                result[n][m]=1;
                return 1;
            }
            else{
                result[n][m]=0;
                return 0;
            }
        }
        else if(n==3){
            result[n][m]=1;
            return 1;
        }
        else{
            if(m==1){
                result[n][1]=(go(n-1,2,result)+go(n-1,3,result))%1000000009;
                return result[n][1];
            }
            else if(m==2){
                result[n][2]=(go(n-2,1,result)+go(n-2,3,result))%1000000009;
                return result[n][2];
            }
            else if(m==3){
                result[n][3]=(go(n-3,1,result)+go(n-3,2,result))%1000000009;
                return result[n][3];
            }
        }
        return -1;
    }
    static public void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        long[][] result = new long[100001][4];
        for(int i=0;i<100001;i++){
            Arrays.fill(result[i], -1);
        }
        for(int i=0;i<cnt;i++){
            int n = sc.nextInt();
            System.out.println((go(n,1,result)+go(n,2,result)+go(n,3,result))%1000000009);
        }
    }
}
