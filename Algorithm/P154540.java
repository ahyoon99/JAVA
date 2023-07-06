package Algorithm;

import java.util.*;

public class P154540 {
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
        String[] maps = {"X591X","X1X5X","X231X", "1XXX1"};

        int[] result = solution(maps);
        for(int i=0;i<result.length;i++){
            System.out.println(result[i]);
        }
    }
    
    static public int[] solution(String[] maps) {
        int[] answer = {-1};
        
        ArrayList<Integer> result = new ArrayList<>();
        
        int[][] map = new int[maps.length][maps[0].length()];
        boolean[][] check = new boolean[maps.length][maps[0].length()];
        
        for(int i=0;i<maps.length;i++){
            for(int j=0;j<maps[0].length();j++){
                if(maps[i].charAt(j)=='X'){
                    map[i][j]=-1;
                }
                else{
                    map[i][j] = maps[i].charAt(j)-'0';
                }
            }
        }
        
        for(int i=0;i<map.length;i++){
            for(int j=0;j<map[0].length;j++){
                if(!check[i][j] && map[i][j]!=-1){
                    int days = BFS(map, check, i,j,0);
                    result.add(days);
                }
            }
        }
        
        Collections.sort(result);
        if(result.size()!=0){
            answer = new int[result.size()];
            for(int i=0;i<result.size();i++){
                answer[i]=result.get(i);
            }
        }
        return answer;
    }
    
    static int BFS(int[][] map, boolean[][] check, int i, int j, int days){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i,j));
        check[i][j]=true;
        days=map[i][j];
        
        while(!q.isEmpty()){
            Pair p = q.poll();
            int x = p.x;
            int y = p.y;
            for(int k=0;k<4;k++){
                int nx = x+dx[k];
                int ny = y+dy[k];
                if(0<= nx && nx<map.length && 0<= ny && ny<map[0].length){
                    if(map[nx][ny]!=-1 && check[nx][ny]==false){
                        q.add(new Pair(nx, ny));
                        check[nx][ny]=true;
                        days+=map[nx][ny];
                    }
                }
            }
        }
        return days;
    }
}
