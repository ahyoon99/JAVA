package Algorithm;

import java.util.*;

public class P150365 {
    static int[] dx = {1,0,0,-1};
    static int[] dy = {0,-1,1,0};
    static String[] dd = {"d","l","r","u"};
    static String answer;
    
    static class Node{
        int x;
        int y;
        Node(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    
    static public void main(String args[]){
        int n=3;
        int m=4;
        int x=2;
        int y=3;
        int r=3;
        int c=1;
        int k=5;

        String result = solution(n, m, x, y, r, c, k);
        System.out.println(result);
    }

    static public String solution(int n, int m, int x, int y, int r, int c, int k) {
        answer = "";
        x-=1;
        y-=1;
        r-=1;
        c-=1;

        if(Math.abs(distance(x,y,r,c)-k)%2!=0){
            return "impossible";
        }
        if(distance(x,y,r,c)>k){
            return "impossible";
        }
        
        dfs(n,m,x,y,r,c,k,0,"");
        
        return answer;
    }
    
    static public int distance(int x, int y, int r, int c){
        return Math.abs(x-r)+Math.abs(y-c);
    }
    
    static public void dfs(int n, int m, int x, int y, int r, int c, int k, int dist, String route){
        if(!answer.equals("")){
            return;
        }
        if(dist+distance(x,y,r,c)>k){
            return;
        }
        if(k==dist){
            answer=route;
            return;
        }
        for(int i=0;i<4;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(isRangeOf(n,m,nx,ny)){
                dfs(n,m,nx,ny,r,c,k,dist+1, route+dd[i]);
            }
        }
    }
    
    static public boolean isRangeOf(int n, int m, int x, int y){
        if(0<=x && x<n && 0<=y && y<m){
            return true;
        }
        return false;
    }
    
}
