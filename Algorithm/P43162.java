package Algorithm;

import java.util.*;

public class P43162 {
    static public void main(String args[]){
        int n=3;
        int[][] computers = {{1,1,0},{1,1,0},{0,0,1}};
        
        int result = solution(n, computers);
        System.out.println(result);
    }

    static public int solution(int n, int[][] computers) {
        int answer = 0;
        
        boolean[] visited = new boolean[n];
        
        for(int i=0;i<n;i++){
            if(visited[i]==false){
                answer++;

                // 방법 1 : BFS
                // BFS(i, n, computers, visited);

                // 방법 2 : DFS
                DFS(i, n, computers, visited);
            }
        }
        return answer;
    }
    
    // 방법 1 : BFS
    static public void BFS(int x, int n, int[][] computers, boolean[] visited){
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        visited[x]=true;
        
        while(!q.isEmpty()){
            int num = q.poll();
            for(int i=0;i<n;i++){
                if(i==num){
                    continue;
                }
                if(computers[num][i]==1 && visited[i]==false){
                    q.add(i);
                    visited[i]=true;
                }
            }
        }
    }

    // 방법 2 : DFS
    static public void DFS(int x, int n, int[][] computers, boolean[] visited){
        for(int i=0;i<n;i++){
            if(i==x){
                continue;
            }
            if(computers[x][i]==1 && visited[i]==false){
                visited[i]=true;
                DFS(i, n, computers, visited);
            }
        }
    }
}
