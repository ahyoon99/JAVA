package Algorithm;

import java.util.*;
import java.io.*;

public class swea11315 {
    static int t;
    static int n;
    static char[][] board;

    static int[] dx = {1,0,1,1};    // 세로, 가로, 오른대각, 왼대각
    static int[] dy = {0,1,1,-1};
    
    static public void main(String args[]) throws IOException{
        System.setIn(new FileInputStream("res/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        t = Integer.parseInt(st.nextToken());
        for(int testcase=1;testcase<=t;testcase++){
            System.out.print("#"+testcase+" ");
            input(br, st);
            if(solution()){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
        }
    }   

    static boolean solution(){
        boolean answer = false;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='o'){
                    for(int k=0;k<4;k++){
                        answer = dfs(i,j,k,0);
                        if(answer){
                            return true;
                        }
                    }
                }
            }
        }
        return answer;
    }

    static boolean dfs(int x, int y, int dir, int cnt){
        if(cnt>=5){
            return true;
        }

        if(!isValid(x,y)){
            return false;
        }

        if(board[x][y]=='o'){
            return dfs(x+dx[dir], y+dy[dir], dir, cnt+1);
        }
        return false;
    }

    static boolean isValid(int x, int y){
        if(0<=x && x<n && 0<=y && y<n){
            return true;
        }
        return false;
    }
    
    static void input(BufferedReader br, StringTokenizer st) throws IOException{
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        board = new char[n][n];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine(), " ");
            String temp = st.nextToken();
            for(int j=0;j<n;j++){
                board[i][j] = temp.charAt(j);
            }
        }
    }
}
