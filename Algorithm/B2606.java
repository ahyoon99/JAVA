package Algorithm;

import java.util.*;

public class B2606 {
    // 방법 1 : DFS (재귀)
    // static int dfs(int[][] computer, boolean[] visited, int idx, int n, int cnt){
    //     cnt++;
    //     visited[idx]=true;
    //     for(int i=0;i<=n;i++){
    //         if(computer[idx][i]==1 && visited[i]==false){
    //             cnt = dfs(computer, visited, i,n, cnt);
    //         }
    //     }
    //     return cnt;
    // }
    // static public void main(String args[]){
    //     Scanner sc = new Scanner(System.in);
    //     int n = sc.nextInt();
    //     int k = sc.nextInt();
    //     int[][] computer = new int[n+1][n+1];
    //     boolean[] visited = new boolean[n+1];
    //     for(int i=0;i<k;i++){
    //         int a = sc.nextInt();
    //         int b = sc.nextInt();
    //         computer[a][b]=1;
    //         computer[b][a]=1;
    //     }
    //     System.out.println(dfs(computer, visited, 1, n, 0)-1);
    // }

    // 방법 2 : DFS (Stack)
    // static public void main(String args[]){
    //     Scanner sc = new Scanner(System.in);
    //     int n = sc.nextInt();
    //     int k = sc.nextInt();
    //     int[][] computer = new int[n+1][n+1];
    //     boolean[] visited = new boolean[n+1];
    //     for(int i=0;i<k;i++){
    //         int a = sc.nextInt();
    //         int b = sc.nextInt();
    //         computer[a][b]=1;
    //         computer[b][a]=1;
    //     }
    //     Stack<Integer> stack = new Stack<>();
    //     int cnt=0;
    //     stack.push(1);
    //     visited[1]=true;
    //     while(!stack.isEmpty()){
    //         cnt++;
    //         int num = stack.pop();
    //         for(int i=0;i<=n;i++){
    //             if(computer[num][i]==1 && visited[i]==false){
    //                 visited[i]=true;
    //                 stack.push(i);
    //             }
    //         }
    //     }
    //     System.out.println(cnt-1);
    // }

    // 방법 3 : BFS (Queue)
    static public void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        boolean[][] computer = new boolean[n+1][n+1];
        boolean[] visited = new boolean[n+1];
        for(int i=0;i<m;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            computer[a][b]=true;
            computer[b][a]=true;
        }

        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(1);
        visited[1]=true;

        int cnt=0;
        while(!q.isEmpty()){
            cnt++;
            int num = q.poll();
            for(int i=0;i<=n;i++){
                if(computer[num][i]==true && visited[i]==false){
                    q.add(i);
                    visited[i]=true;
                }
            }
        }
        System.out.println(cnt-1);
    }
}
