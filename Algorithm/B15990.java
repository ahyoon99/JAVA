package Algorithm;

import java.util.Scanner;

public class B15990 {
    // 1. Bottom-up
    static public void main(String args[]){
        Scanner sc = new Scanner(System.in);
        long[][] result = new long[100001][4];
        result[1][1]=1;
        result[2][2]=1;
        result[3][1]=1;
        result[3][2]=1;
        result[3][3]=1;
        for(int j=4;j<100001;j++){
            result[j][1]=(result[j-1][2]+result[j-1][3])%1000000009;
            result[j][2]=(result[j-2][1]+result[j-2][3])%1000000009;
            result[j][3]=(result[j-3][1]+result[j-3][2])%1000000009;
        }

        int cnt = sc.nextInt();
        for(int i=0;i<cnt;i++){
            int num = sc.nextInt();
            System.out.println((result[num][1]+result[num][2]+result[num][3])%1000000009);
        }   
    }
}
