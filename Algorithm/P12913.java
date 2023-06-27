package Algorithm;

import java.util.*;

public class P12913 {
    static public void main(String args[]){
        int [][] land = {{1,2,3,5},{5,6,7,8},{4,3,2,1}};

        int result = solution(land);
        System.out.println(result);
    }
    
    static int solution(int[][] land) {
        int answer = 0;

        int [][] dp = new int[land.length][4];
        for(int i=0;i<4;i++){
            dp[0][i]=land[0][i];
        }
        
        for(int i=1;i<dp.length;i++){
            dp[i][0]=Math.max(Math.max(dp[i-1][1],dp[i-1][2]),dp[i-1][3])+land[i][0];
            dp[i][1]=Math.max(Math.max(dp[i-1][0],dp[i-1][2]),dp[i-1][3])+land[i][1];
            dp[i][2]=Math.max(Math.max(dp[i-1][0],dp[i-1][1]),dp[i-1][3])+land[i][2];
            dp[i][3]=Math.max(Math.max(dp[i-1][0],dp[i-1][1]),dp[i-1][2])+land[i][3]; 
        }
        
        answer = Math.max(Math.max(Math.max(dp[land.length-1][0], dp[land.length-1][1]), dp[land.length-1][2]), dp[land.length-1][3]);
        
        return answer;
    }
}
