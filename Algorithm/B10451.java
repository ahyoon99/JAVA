package Algorithm;

import java.util.*;

public class B10451 {
    static public void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        for(int testcase =0; testcase<tc; testcase++){
            int n = sc.nextInt();

            int[] graph = new int[1001];
            boolean[] visited = new boolean[1001];

            for(int i=1;i<=n;i++){
                int end = sc.nextInt();
                graph[i]=end;
            }
            
            int cycleCnt = 0;
            for(int i=1;i<=n;i++){
                if(DFS(graph, visited, i, -1)){
                    cycleCnt++;
                }
            }
            System.out.println(cycleCnt);
        }
    }

    static boolean DFS(int[] graph, boolean[] visited, int cur, int parent){
        if(visited[cur]){
            return false;
        }

        visited[cur]=true;
        int next = graph[cur];
        if(!visited[next]){
            if(DFS(graph, visited, next, cur)){
                return true;
            }
        }
        if(next!=parent){
            return true;
        }
        return false;

    }
}
