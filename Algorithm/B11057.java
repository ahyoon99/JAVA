package Algorithm;

import java.util.Scanner;

public class B11057 {
    // 방법 1 : Bottom-up
    static public void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] num = new int[n+1][10]; // num[i][j] = j로 끝나는 i자리인 오르막 수의 개수
        for(int i=0;i<10;i++){
            num[1][i]=1;
        }
        for(int i=2;i<=n;i++){
            for(int j=0;j<=9;j++){
                for(int k=j;k>=0;k--){
                    num[i][j]= (num[i][j] + num[i-1][k]) % 10007;
                }
            }
        }
        long result=0;
        for(int i=0;i<=9;i++){
            result= (result + num[n][i])%10007;
        }
        System.out.println(result);
    }
}
