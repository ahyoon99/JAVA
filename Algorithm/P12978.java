package Algorithm;

import java.util.*;

public class P12978 {
    static public void main(String args[]){
        int N = 5;
        int[][] road = {{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};
        int K = 3;

        int result = solution(N, road, K);
        System.out.println(result);
    }

    static public int solution(int N, int[][] road, int K) {
        int answer = 0;

        int[][] map = new int[N][N];
        
        for(int i=0;i<road.length;i++){
            int start = road[i][0]-1;
            int end = road[i][1]-1;
            int dis = road[i][2];
            if(map[start][end]==0 || map[start][end]>dis){
                map[start][end]=dis;
                map[end][start]=dis;
            }
        }
        
        int[] distance = new int[N];
        Arrays.fill(distance, Integer.MAX_VALUE);
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        distance[0]=0;
        while(!q.isEmpty()){
            int x = q.poll();
            for(int i=0;i<N;i++){
                if(map[x][i]>0 && distance[i]>distance[x]+map[x][i]){
                    q.add(i);
                    distance[i]=distance[x]+map[x][i];
                }
            }
        }
        
        Arrays.sort(distance);
        for(int i=0;i<N;i++){
            if(distance[i]<=K){
                answer++;
            }
            else{
                break;
            }
        }
        return answer;
    }
    
}
