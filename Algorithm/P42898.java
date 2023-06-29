package Algorithm;

import java.util.*;

public class P42898 {
    static public void main(String args[]){
        int m = 4;
        int n = 3;
        int[][] puddles = {{2,2}};

        int result = solution(m, n, puddles);
        System.out.println(result);
    }

    static public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        
        int[][] result = new int[n+1][m+1];
        boolean[][] water = new boolean[n+1][m+1];
        for(int i=0;i<n+1;i++){
            Arrays.fill(water[i], true);
        }
        for(int i=0;i<puddles.length;i++){
            water[puddles[i][1]][puddles[i][0]]=false;
        }
        
        result[1][1]=1;
     
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(!water[i][j]){
                    continue;
                }
                if(water[i][j-1]){
                    result[i][j]=(result[i][j]+result[i][j-1])%1000000007;
                }
                if(water[i-1][j]){
                    result[i][j]=(result[i][j]+result[i-1][j])%1000000007;
                }
            }
        }
    
        answer = result[n][m]%1000000007;
        return answer;
    }
}
