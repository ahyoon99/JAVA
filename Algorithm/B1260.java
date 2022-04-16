package Algorithm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class B1260 {

    // 인접 행렬 사용
    static Queue<Integer> q = new LinkedList<>();

    public static void DFS(boolean[][] edges, boolean[] check, int x, int n){
        check[x]=true;
        System.out.print(x+" ");
        for(int i=1;i<=n;i++){
            if(edges[x][i]==true && check[i]==false){
                DFS(edges, check, i, n);
            }
        }
    }

    public static void BFS(boolean[][] edges, boolean[] check, int x, int n){
        check[x]=true;
        q.offer(x);
        while(!q.isEmpty()){
            int num = q.poll();
            System.out.print(num+" ");
            for(int i=1;i<=n;i++){
                if(edges[num][i]==true && check[i]==false){
                    check[i]=true;
                    q.offer(i);
                }
            }
        }
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int v = sc.nextInt();

        boolean[][] edges = new boolean[n+1][n+1];
        
        for(int i=0;i<m;i++){
            int from = sc.nextInt();
            int to = sc.nextInt();
            edges[from][to]=true;
            edges[to][from]=true;
        }
        boolean[] check = new boolean[n+1];
        DFS(edges, check, v, n);
        System.out.println();
        Arrays.fill(check, false);
        BFS(edges, check, v, n);
    }
    
}
