package Algorithm;

import java.util.*;

public class B1987 {
    // 방법 1 : DFS(재귀)
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int ans = 0;

    static void dfs(char[][] map, boolean[] alp, int x, int y, int n, int m, int cnt){
        char ch = map[x][y];
        if(alp[ch-'A']==true){
            if(ans<cnt){
                ans = cnt;
            }
            return;
        }
        alp[ch-'A'] = true;
        for(int i=0;i<4;i++){
            int nx = x+ dx[i];
            int ny = y+ dy[i];
            if(0<=nx && nx<n && 0<=ny && ny<m){
                dfs(map,alp, nx, ny, n,m, cnt+1);
            }
        }
        alp[ch-'A']=false;
        return;
    }
    static public void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[][] map = new char[n][m];
        boolean[] alp = new boolean[26];
        for(int i=0;i<n;i++){
            String com = sc.next();
            for(int j=0;j<m;j++){
                map[i][j] = com.charAt(j);
            }
        }
        dfs(map,alp,0,0,n,m,0);
        System.out.println(ans);
    }
}
