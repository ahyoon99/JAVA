package Algorithm;

import java.util.*;

public class P49189 {
    static public void main(String args[]){
        int n=6;
        int[][] edge = {{3,6},{4,3},{3,2},{1,3},{1,2},{2,4},{5,2}};
        
        int result = solution(n, edge);
        System.out.println(result);
    }

    // 방법 1 : 인접 리스트
    // static public int solution(int n, int[][] edge) {
    //     int answer = 0;
        
    //     LinkedList<Integer>[] graph = new LinkedList[n+1];
    //     for(int i=0;i<=n;i++){
    //         graph[i] = new LinkedList<Integer>();
    //     }
    //     for(int i=0;i<edge.length;i++){
    //         graph[edge[i][0]].add(edge[i][1]);
    //         graph[edge[i][1]].add(edge[i][0]);
    //     }
        
    //     int[] depth = new int[n+1];
    //     boolean[] visited = new boolean[n+1];
        
    //     Queue<Integer> q = new LinkedList<>();
    //     q.add(1);
    //     visited[1]=true;
    //     while(!q.isEmpty()){
    //         int num = q.poll();
    //         for(int i=0;i<graph[num].size();i++){
    //             int temp = graph[num].get(i);
    //             if(visited[temp]==false){
    //                 q.add(temp);
    //                 depth[temp]=depth[num]+1;
    //                 visited[temp]=true;
    //             }
    //         }
    //     }
        
    //     Arrays.sort(depth);
    //     int max = depth[n];
        
    //     for(int i=1;i<=n;i++){
    //         if(depth[i]==max){
    //             answer++;
    //         }
    //     }
        
    //     return answer;
    // }

    // 방법 2 : 인접 행렬 -> int[][] 사용시 메모리 초과 발생!
    static public int solution(int n, int[][] edge) {
        int answer = 0;
        
        boolean[][] graph = new boolean[n+1][n+1];
        for(int i=0;i<edge.length;i++){
            graph[edge[i][0]][edge[i][1]]=true;
            graph[edge[i][1]][edge[i][0]]=true;
        }
        
        int[] depth = new int[n+1];
        boolean[] visited = new boolean[n+1];
        
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1]=true;
        while(!q.isEmpty()){
            int num = q.poll();
            for(int i=1;i<=n;i++){
                if(graph[num][i]==true && visited[i]==false){
                    q.add(i);
                    depth[i]=depth[num]+1;
                    visited[i]=true;
                }
            }
        }
        
        Arrays.sort(depth);
        int max = depth[n];
        
        for(int i=1;i<=n;i++){
            if(depth[i]==max){
                answer++;
            }
        }
        return answer;
    }
}
