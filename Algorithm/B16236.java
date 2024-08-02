package Algorithm;

import java.util.*;
import java.io.*;

public class B16236 {
    static int n;
    static int[][] matrix;
    static Fish shark;
    static int time;
    static int eatenCount;

    static ArrayList<Fish> eatableFish;
    static Fish targetFish;

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    static class Fish{
        int x;
        int y;
        int size; 
        Fish(){}
        Fish(int x, int y, int size){
            this.x=x;
            this.y=y;
            this.size=size;
        }   
    }
    
    static public void main(String args[]) throws IOException{
        input();

        while(true){
            
            // 먹을 수  있는 물고기 찾기
            findEatableFish();
            
            // 먹을 수  있는 물고기 없을 때
            if(eatableFish.size()==0){
                break;
            }

            // 먹을 수  있는 물고기 1마리 이상일 때
            else{
                // 이동 하기
                targetFish = bfs();

                // 이동할 수 있는 경로가 없을 때
                if(targetFish.x==-1){
                    break;
                }
            }
            time+=targetFish.size;
            eatenCount++;
            matrix[shark.x][shark.y]=0;
            matrix[targetFish.x][targetFish.y]=9;
            if(eatenCount==shark.size){
                shark.size++;
                eatenCount=0;
            }
            shark.x=targetFish.x;
            shark.y=targetFish.y;
        }
        System.out.println(time);
    }

    static void findShortestFish(){
        bfs();
    }

    static Fish bfs(){
        int x = shark.x;
        int y = shark.y;

        Queue<Fish> q = new LinkedList<>();
        int[][] distance = new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(distance[i], -1);
        }

        q.add(shark);
        distance[x][y]=0;

        while(!q.isEmpty()){
            Fish f = q.poll();
            x = f.x;
            y = f.y;
            for(int i=0;i<4;i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(isValid(nx, ny)){
                    if(distance[nx][ny]==-1 && matrix[nx][ny]<=shark.size){
                        q.add(new Fish(nx,ny,matrix[nx][ny]));
                        distance[nx][ny]=distance[x][y]+1;
                    }
                }
            }
        }

        Fish shortestFish = new Fish(-1,-1,Integer.MAX_VALUE);
        for(int i=0;i<eatableFish.size();i++){
            Fish f = eatableFish.get(i);
            if(distance[f.x][f.y]==-1){
                continue;
            }
            if(distance[f.x][f.y]<shortestFish.size){
                shortestFish.x = f.x;
                shortestFish.y = f.y;
                shortestFish.size = distance[f.x][f.y];
            }
        }
        return shortestFish;
    }

    static boolean findEatableFish(){
        eatableFish = new ArrayList<Fish>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(0<matrix[i][j] && matrix[i][j]<7 && matrix[i][j]<shark.size){
                    eatableFish.add(new Fish(i,j,matrix[i][j]));
                }
            }
        }

        return true;
    }

    static boolean isValid(int x, int y){  
        if(0<=x && x<n && 0<=y && y<n){
            return true;
        }
        return false;
    }

    static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        matrix = new int[n][n];
        time = 0;
        eatenCount = 0;

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0;j<n;j++){
                matrix[i][j] = Integer.parseInt(st.nextToken());
                if(matrix[i][j]==9){
                    shark = new Fish(i,j,2);
                }
            }
        }
    }
}
