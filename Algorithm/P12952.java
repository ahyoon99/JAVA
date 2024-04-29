package Algorithm;

import java.util.*;

public class P12952 {
    static int[][] matrix;
    static int cnt;
    
    static int[] dx = {0,0,1,-1,1,-1,-1,1};
    static int[] dy = {1,-1,0,0,1,-1,1,-1};
    
    static public void main(String arg[]){
        int n = 4;
        int result = solution(n);
        System.out.println(result);
    }

    static public int solution(int n) {
        int answer = 0;
        
        matrix = new int[n][n];
        cnt=0;
        
        for(int i=0;i<n;i++){
            matrix[0][i]=1;
            go(1, n);
            matrix[0][i]=0;
        }
    
        answer=cnt;
        return answer;
    }
    
    static void go(int x, int n){
        if(x>=n){
            cnt++;
            return;
        }
        
        for(int i=0;i<n;i++){
            if(checkValid(x, i, n)){
                matrix[x][i]=1;
                go(x+1, n);
                matrix[x][i]=0;
            }
        }        
    }
    
    static boolean checkValid(int x, int y, int n){
        for(int i=0;i<8;i++){
            int nx = x;
            int ny = y;
            while(true){
                nx += dx[i];
                ny += dy[i];
                if(0>nx || nx>=n || 0>ny || ny>=n){
                    break;
                }
                if(matrix[nx][ny]==1){
                    return false;
                }
            }
        }
        return true;
    }
}
