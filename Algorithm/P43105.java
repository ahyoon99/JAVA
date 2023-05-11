package Algorithm;

import java.util.*;

public class P43105 {
    static public void main(String args[]){
        int[][] triangle = { {7},
                             {3,8},
                             {8,1,0},
                             {2,7,4,4},
                             {4,5,2,6,5}};

        int result = solution(triangle);
        System.out.println(result);
    }

    static public int solution(int[][] triangle) {
        int answer = 0;
        
        int[][]dp = new int[triangle.length][triangle[triangle.length-1].length];
        dp[0][0]=triangle[0][0];
        
        for(int i=1;i<triangle.length;i++){
            for(int j=0;j<triangle[i].length;j++){
                if(j==0){
                    dp[i][j]=dp[i-1][j]+triangle[i][j];
                }
                else if(j==triangle[i].length-1){
                    dp[i][j]=dp[i-1][j-1]+triangle[i][j];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j])+triangle[i][j];
                }
            }
        }
        Arrays.sort(dp[dp.length-1]);
        answer = dp[dp.length-1][dp[dp.length-1].length-1];
        
        return answer;
    }
}
