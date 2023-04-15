package Algorithm;

import java.util.*;

public class B2225 {
    static public void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        long[][] result = new long[n+1][k+1];
        for(int i=0;i<=k;i++){
            result[0][i]=1;
            result[1][i]=i;
        }
        for(int i=2;i<=n;i++){
            result[i][1]=1;
        }

        for(int i=2;i<=n;i++){
            for(int j=2;j<=k;j++){
                long med = 0;
                for(int l=0;l<=i;l++){
                    med=(med+result[i-l][j-1])%1000000000;
                }
                result[i][j]=med;
            }
        }
        System.out.println(result[n][k]);
    }    
}
