package Algorithm;

import java.util.*;

public class P68645 {
    static public void main(String args[]){
        int n = 4;
        int[] result = solution(n);

        for(int i=0;i<result.length;i++){
            System.out.print(result[i]+" ");
        }
        System.out.println();
    }

    static public int[] solution(int n) {
        int length = 0;
        for(int i=1;i<=n;i++){
            length+=i;
        }
        int[] answer = new int[length];
        
        int[][] result = new int[n][n];
        int[][] direction = {{1,0},{0,1},{-1,-1}}; // 내려가는거, 오른쪽, 왼오
        int x = -1;
        int y = 0;
        int dir = 0;
        int num=1;
        for(int tc=n;tc>0;tc--){
            for(int i=0;i<tc;i++){
                x+=direction[dir][0];
                y+=direction[dir][1];
                result[x][y]= num;
                num++;
            }
            if(dir==0){
                dir=1;
            }
            else if(dir==1){
                dir=2;
            }
            else if(dir==2){
                dir=0;
            }
        }
        
        int idx=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                answer[idx]=result[i][j];
                idx++;
            }
        }
        return answer;
    }
}
