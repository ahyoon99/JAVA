package Algorithm;

import java.util.*;

public class B1051 {
    static public void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] board = new int[n][m];
        for(int i=0;i<n;i++){
            String com = sc.next();
            for(int j=0;j<m;j++){
                board[i][j] = com.charAt(j)-'0';
            }
        }

        int len = Math.min(n,m);
        while(len>1){
            for(int i=0;i<=n-len;i++){
                for(int j=0;j<=m-len;j++){
                    int num = board[i][j];
                    if(num==board[i][j+len-1] && num==board[i+len-1][j] && num==board[i+len-1][j+len-1]){
                        System.out.println(len*len);
                        return;
                    }
                }
            }
            len--;
        }
        System.out.println(1);
    }
}
