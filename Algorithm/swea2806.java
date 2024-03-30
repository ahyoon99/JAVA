package Algorithm;

import java.util.*;
import java.io.*;

public class swea2806 {
    static int T;
    static int n;
    static int[][] matrix;
    static int cnt;
    static int[] dx = {-1,-1,-1}; // 위, 왼대, 오대
    static int[] dy = {0,-1,1};
    
    static public void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        T = Integer.parseInt(st.nextToken());
        for(int tc=0;tc<T;tc++){
            System.out.print("#"+(tc+1)+" ");
            solution(br, st);
            System.out.println(cnt);
        }
    }

    static void solution(BufferedReader br, StringTokenizer st) throws IOException{
        input(br, st);

        for(int i=0;i<n;i++){
            matrix[0][i]=1;
            bfs(1);
            matrix[0][i]=0;
        }
    }

    static void bfs(int x){
        if(x==n){
            cnt++;
            return;
        }
        for(int i=0;i<n;i++){
            if(!check(x,i,0) || !check(x,i,1) || !check(x,i,2)){
                continue;
            }
            matrix[x][i]=1;
            bfs(x+1);
            matrix[x][i]=0;
        }
    }

    static boolean check(int x, int y, int idx){
        while(true){
            x+=dx[idx];
            y+=dy[idx];

            if(x<0 || y<0 || x>=n || y>=n){
                break;
            }

            if(matrix[x][y]==1){
                return false;
            }
        }
        return true;
    }

    static void input(BufferedReader br, StringTokenizer st) throws IOException{
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        matrix = new int[n][n];
        cnt=0;
    }
}
