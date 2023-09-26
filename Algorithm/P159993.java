package Algorithm;

import java.util.*;

public class P159993 {
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    
    static class Pair{
        int x;
        int y;
        
        Pair(){}
        Pair(int x, int y){
            this.x=x;
            this.y=y;
        }
    }

    static public void main(String args[]){
        String[] maps = {"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"};

        int result = solution(maps);
        System.out.println(result);
    }
    
    static public int solution(String[] maps) {
        int answer = 0;
        
        Pair lever = new Pair();
        Pair start = new Pair();
        Pair end = new Pair();
        char[][] map = new char[maps.length][maps[0].length()];
        for(int i=0;i<maps.length;i++){
            for(int j=0;j<maps[i].length();j++){
                map[i][j]=maps[i].charAt(j);
                if(map[i][j]=='S'){
                    start = new Pair(i,j);
                }
                else if(map[i][j]=='E'){
                    end = new Pair(i,j);
                }
                else if(map[i][j]=='L'){
                    lever = new Pair(i,j);
                }
            }
        }
        
        
        int[][] distance= new int[map.length][map[0].length];
        for(int i=0;i<distance.length;i++){
            Arrays.fill(distance[i], -1);
        }
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(start.x, start.y));
        distance[start.x][start.y]=0;
        while(!q.isEmpty()){
            Pair p = q.poll();
            int x = p.x;
            int y = p.y;
            for(int i=0;i<4;i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(0<=nx && nx<map.length && 0<=ny && ny<map[0].length){
                    if(distance[nx][ny]==-1 && map[nx][ny]!='X'){
                        q.add(new Pair(nx,ny));
                        distance[nx][ny]=distance[x][y]+1;
                    }
                }
            }
        }
        
        if(distance[lever.x][lever.y]==-1){
            return -1;
        }
        answer+=distance[lever.x][lever.y];
        
        
        for(int i=0;i<distance.length;i++){
            Arrays.fill(distance[i], -1);
        }
        q = new LinkedList<>();
        q.add(new Pair(lever.x, lever.y));
        distance[lever.x][lever.y]=0;
        while(!q.isEmpty()){
            Pair p = q.poll();
            int x = p.x;
            int y = p.y;
            for(int i=0;i<4;i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(0<=nx && nx<map.length && 0<=ny && ny<map[0].length){
                    if(distance[nx][ny]==-1 && map[nx][ny]!='X'){
                        q.add(new Pair(nx,ny));
                        distance[nx][ny]=distance[x][y]+1;
                    }
                }
            }
        }
        
        if(distance[end.x][end.y]==-1){
            return -1;
        }
        answer+=distance[end.x][end.y];
        
        return answer;
    }
}
