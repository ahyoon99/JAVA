package Algorithm;

import java.util.*;

public class P49191 {
    static public void main(String args[]){
        int n = 5;
        int[][] results = {{4,3},{4,2},{3,2},{1,2},{2,5}};

        int result = solution(n, results);
        System.out.println(result);
    }

    static public int solution(int n, int[][] results) {
        int answer = 0;
        
        int[][] score = new int[n+1][n+1];
        for(int i=0;i<results.length;i++){
            int n1 = results[i][0];
            int n2 = results[i][1];
            score[n1][n2]=1;
            score[n2][n1]=-1;
        }
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                for(int k=1;k<=n;k++){
                    if(score[i][j]==1 && score[j][k]==1){
                        score[i][k]=1;
                        score[k][i]=-1;
                    }
                    if(score[i][j]==-1 && score[j][k]==-1){
                        score[i][k]=-1;
                        score[k][i]=1;
                    }
                }
            }
        }
        
        for(int i=1;i<=n;i++){
            int num=1;
            for(int j=1;j<=n;j++){
                if(score[i][j]!=0){
                    num++;
                }
            }
            if(num==n){
                answer++;
            }
        }
        
        return answer;
    }
}
