package Algorithm;

import java.util.*;


public class P81302 {
    static String[] place;
    static int[][] room;
    static ArrayList<Pair> person;
    static int[][] depth;
    
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
        
        int getX(){
            return x;
        }
        int getY(){
            return y;
        }
    }
    
    // 입력값 String[]을 int[][]로 변환하기 & P인 경우에는 ArrayList에 해당 좌표 추가하기
    static public void makeRoom(){
        for(int i =0;i<5;i++){
            String row = place[i];
            for(int j=0;j<5;j++){
                if(row.charAt(j)=='P'){
                    room[i][j]=1;
                    addPerson(i,j);
                }
                else if(row.charAt(j)=='0'){
                    room[i][j]=0;
                }
                else if(row.charAt(j)=='X'){
                    room[i][j]=-1;
                }
            }
        }
    }
    
    // P인 경우, ArrayList에 해당 좌표 추가하기
    static public void addPerson(int x, int y){
        person.add(new Pair(x,y));
    }
    
    
    static public boolean BFS(int x, int y){
        LinkedList<Pair> queue = new LinkedList<>();
        boolean[][] visited = new boolean[5][5];
        
        queue.add(new Pair(x,y));
        depth[x][y]=0;
        while(!queue.isEmpty()){
            Pair p = queue.poll();
            x = p.getX();
            y = p.getY();
            if(depth[x][y]>=3){
                return true;
            }
            visited[x][y]=true;
            for(int i=0;i<4;i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(0<=nx && nx<5 && 0<=ny && ny<5){
                    if(visited[nx][ny]==false){
                        // 부모(x,y)가 X인 경우, 그 자리(nx, ny)에는 사람이 앉아있어도 상관없다!
                        if(room[x][y]==-1){
                            continue;
                        }
                        
                        depth[nx][ny]=depth[x][y]+1;
                        queue.add(new Pair(nx, ny));
                        visited[nx][ny]=true;
                        
                        // 현재 자리(nx, ny)가 P이고 depth가 2이하이면 규칙을 어긴 것!
                        if(depth[nx][ny]<=2 && room[nx][ny]==1){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
    
    static public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        for(int tc=0;tc<5;tc++){
            place = places[tc];
            room = new int[5][5];
            
            person = new ArrayList<>();
            makeRoom();
            
            boolean result=true;
            for(int i=0;i<person.size();i++){
                int x = person.get(i).getX();
                int y = person.get(i).getY();
                depth = new int[5][5];
                if(!BFS(x,y)){
                    result=false;
                    break;
                }
            }
            
            answer[tc] = result ? 1 : 0 ;
        }
        return answer;
    }

    static public void main(String args[]){
        String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                             {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                             {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                             {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                             {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
        solution(places);
    }
}
