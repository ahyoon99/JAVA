package Algorithm;

import java.util.Scanner;

public class B2193 {
    // 방법 1 : Bottom-up
    static public void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[][] num = new long[n+1][2];
        num[1][0]=0;
        num[1][1]=1;
        for(int i=2;i<=n;i++){
            for(int j=0;j<=1;j++){
                if(j==0){
                    num[i][j]=num[i-1][0]+num[i-1][1];
                }
                else if(j==1){
                    num[i][j]=num[i-1][0];
                }
            }
        }
        long result = 0;
        for(int i=0;i<=1;i++){
            result += num[n][i];
        }
        System.out.println(result);
    }
}
