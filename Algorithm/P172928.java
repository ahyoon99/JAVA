package Algorithm;

import java.util.*;

public class P172928 {
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    
    static class Pair{
        int x;
        int y;
        
        Pair(){}
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static public void main(String args[]){
        String[] park = {"SOO","OOO","OOO"};
        String[] routes = {"E 2","S 2","W 1"};
        int[] result = solution(park, routes);
        for(int i=0;i<result.length;i++){
            System.out.print(result[i]+" ");
        }
        System.out.println();
    }
    
    static public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        
        // 1. S 찾기
        char[][] charPark=new char[park.length][park[0].length()];
        Pair startPoint = new Pair();
        for(int i=0;i<park.length;i++){
            for(int j=0;j<park[i].length();j++){
                charPark[i][j]=park[i].charAt(j);
                if(park[i].charAt(j)=='S'){
                    startPoint = new Pair(i,j);
                }
            }
        }
        
        
        for(int i=0;i<routes.length;i++){
            char direction = routes[i].charAt(0);
            int cnt = routes[i].charAt(2)-'0';
            int nx=startPoint.x;
            int ny=startPoint.y;
            
            // 2. 방향 찾아주기
            int directionIdx=-1;
            if(direction=='N'){
                directionIdx=0;
            }
            else if(direction=='E'){
                directionIdx=1;
            }
            else if(direction=='S'){
                directionIdx=2;
            }
            else if(direction=='W'){
                directionIdx=3;
            }
            
            // 3. 공원을 벗어나는지 확인
            nx+=(dx[directionIdx]*cnt);
            ny+=(dy[directionIdx]*cnt);
            if(0>nx || nx>=charPark.length || 0>ny || ny>=charPark[0].length){
                continue;
            }
            
            // 4. 주어진 방향으로 이동 중 장애물 만나는지 확인
            boolean check=true;
            nx=startPoint.x;
            ny=startPoint.y;
            for(int j=0;j<cnt;j++){
                nx+=dx[directionIdx];
                ny+=dy[directionIdx];
                if(charPark[nx][ny]=='X'){
                    check=false;
                    break;
                }
            }
            
            if(check){
                startPoint = new Pair(nx,ny);
            }
        }
        
        answer[0]=startPoint.x;
        answer[1]=startPoint.y;
        return answer;
    }
}
