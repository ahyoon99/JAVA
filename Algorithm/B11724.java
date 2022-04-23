package Algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B11724 {

    static boolean[] check;
    static int[][] edges;
    static int n;

    public static boolean DFS(int x){
        if(check[x]==true){
            return false;
        }
        check[x]=true;
        //System.out.print(x+" ");
        for(int i=1;i<=n;i++){
            if(edges[x][i]==1 && check[i]==false){
                DFS(i);
            }
        }
        return true;
    }

    static Queue<Integer> q = new LinkedList<>();
    public static void BFS(int x){
        check[x]=true;
        q.add(x);
        while(!q.isEmpty()){
            int num = q.poll();
            //System.out.print(num+" ");
            for(int i=1;i<=n;i++){
                if(edges[num][i]==1 && check[i]==false){
                    check[i]=true;
                    q.add(i);
                }
            }
        }
    }

    // 1. 인접행렬
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();

        edges = new int[n+1][n+1];
        check = new boolean[n+1];

        for(int i=0;i<m;i++){
            int from = sc.nextInt();
            int to = sc.nextInt();
            edges[from][to] = 1;
            edges[to][from] = 1;
        }

        int connected_graph_cnt=0;
        
        // 1-1) DFS
        // for(int i=1;i<=n;i++){
        //     if(DFS(i)){
        //         connected_graph_cnt++;
        //     }
        // }

        // 1-2) BFS
        for(int i=1;i<=n;i++){
            if(check[i]==false){
                BFS(i);
                connected_graph_cnt++;
            }
        }

        System.out.println(connected_graph_cnt);
    }
    
}
