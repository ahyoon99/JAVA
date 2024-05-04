package Algorithm;

import java.util.*;

public class P12952 {
    // 방법 1
    // static int[][] matrix;
    // static int cnt;
    
    // static int[] dx = {0,0,1,-1,1,-1,-1,1};
    // static int[] dy = {1,-1,0,0,1,-1,1,-1};
    
    // static public void main(String arg[]){
    //     int n = 4;
    //     int result = solution(n);
    //     System.out.println(result);
    // }

    // static public int solution(int n) {
    //     int answer = 0;
        
    //     matrix = new int[n][n];
    //     cnt=0;
        
    //     for(int i=0;i<n;i++){
    //         matrix[0][i]=1;
    //         go(1, n);
    //         matrix[0][i]=0;
    //     }
    
    //     answer=cnt;
    //     return answer;
    // }
    
    // static void go(int x, int n){
    //     if(x>=n){
    //         cnt++;
    //         return;
    //     }
        
    //     for(int i=0;i<n;i++){
    //         if(checkValid(x, i, n)){
    //             matrix[x][i]=1;
    //             go(x+1, n);
    //             matrix[x][i]=0;
    //         }
    //     }        
    // }
    
    // static boolean checkValid(int x, int y, int n){
    //     for(int i=0;i<8;i++){
    //         int nx = x;
    //         int ny = y;
    //         while(true){
    //             nx += dx[i];
    //             ny += dy[i];
    //             if(0>nx || nx>=n || 0>ny || ny>=n){
    //                 break;
    //             }
    //             if(matrix[nx][ny]==1){
    //                 return false;
    //             }
    //         }
    //     }
    //     return true;
    // }

    // 방법 2
    static int[][] matrix;
    static int[][] check;
    static int cnt;

    static public void main(String arg[]){
        int n = 4;
        int result = solution(n);
        System.out.println(result);
    }
    
    static public int solution(int n){
        int answer = 0;
        
        matrix = new int[n][n];
        check = new int[4][2*n];
        cnt=0;
        
        for(int j=0;j<n;j++){
            matrix[0][j]=1;
            check[0][0]=1;
            check[1][j]=1;
            check[2][n-1-j]=1;
            check[3][j]=1;
            
            go(1, n);
            
            matrix[0][j]=0;
            check[0][0]=0;
            check[1][j]=0;
            check[2][n-1-j]=0;
            check[3][j]=0;
        }
        
        answer = cnt;
        return answer;
    }
    
    static void go(int x, int n){
        if(x==n){
            cnt++;  
            return;
        }
        for(int j=0;j<n;j++){
            if(isCheck(x, j, n)){
                check[0][x]=1;
                check[1][j]=1;
                check[2][x-j+n-1]=1;
                check[3][x+j]=1;
                matrix[x][j]=1;
                go(x+1, n);
                check[0][x]=0;
                check[1][j]=0;
                check[2][x-j+n-1]=0;
                check[3][x+j]=0;
                matrix[x][j]=0;
            }
        }
    }
    
    static boolean isCheck(int x, int y, int n){
        if(check[0][x]==1){
            return false;
        }
        else if(check[1][y]==1){
            return false;
        }
        else if(check[2][x-y+n-1]==1){
            return false;
        }
        else if(check[3][x+y]==1){
            return false;
        }
        return true;
    }
}
