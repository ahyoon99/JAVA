package Algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B11724 {

    // 1. 인접 행렬
    // static boolean[] check;
    // static int[][] edges;
    // static int n;

    // public static boolean DFS(int x){
    //     if(check[x]==true){
    //         return false;
    //     }
    //     check[x]=true;
    //     //System.out.print(x+" ");
    //     for(int i=1;i<=n;i++){
    //         if(edges[x][i]==1 && check[i]==false){
    //             DFS(i);
    //         }
    //     }
    //     return true;
    // }

    // static Queue<Integer> q = new LinkedList<>();
    // public static void BFS(int x){
    //     check[x]=true;
    //     q.add(x);
    //     while(!q.isEmpty()){
    //         int num = q.poll();
    //         //System.out.print(num+" ");
    //         for(int i=1;i<=n;i++){
    //             if(edges[num][i]==1 && check[i]==false){
    //                 check[i]=true;
    //                 q.add(i);
    //             }
    //         }
    //     }
    // }

    // public static void main(String args[]){
    //     Scanner sc = new Scanner(System.in);
    //     n = sc.nextInt();
    //     int m = sc.nextInt();

    //     edges = new int[n+1][n+1];
    //     check = new boolean[n+1];

    //     for(int i=0;i<m;i++){
    //         int from = sc.nextInt();
    //         int to = sc.nextInt();
    //         edges[from][to] = 1;
    //         edges[to][from] = 1;
    //     }

    //     int connected_graph_cnt=0;
        
    //     // 1-1) DFS
    //     // for(int i=1;i<=n;i++){
    //     //     if(DFS(i)){
    //     //         connected_graph_cnt++;
    //     //     }
    //     // }

    //     // 1-2) BFS
    //     for(int i=1;i<=n;i++){
    //         if(check[i]==false){
    //             BFS(i);
    //             connected_graph_cnt++;
    //         }
    //     }

    //     System.out.println(connected_graph_cnt);
    // }

    // 2. 인접 리스트
    static ArrayList<Integer>[] edges;
    static boolean[] check;
    static Queue<Integer> q = new LinkedList<>();

    public static boolean DFS(int x){
        if(check[x]==true){
            return false;
        }
        check[x]=true;
        //System.out.print(x+" ");
        for(int i=0;i<edges[x].size();i++){
            if(check[edges[x].get(i)]==false){
                DFS(edges[x].get(i));
            }
        }
        return true;
    }

    public static void BFS(int x){
        check[x]=true;
        q.add(x);
        while(!q.isEmpty()){
            int num = q.poll();
            for(int i=0;i<edges[num].size();i++){
                if(!check[edges[num].get(i)]){
                    check[edges[num].get(i)]=true;
                    q.add(edges[num].get(i));
                }
            }
        }
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        check = new boolean[n+1];
        edges = (ArrayList<Integer>[])new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            edges[i] = new ArrayList<Integer>();
        }


        for(int i=0;i<m;i++){
            int from = sc.nextInt();
            int to  = sc.nextInt();
            edges[from].add(to);
            edges[to].add(from);
        }

        int connected_graph_cnt = 0;

        // 2-1) DFS
        // for(int i=1;i<=n;i++){
        //     if(DFS(i)==true){
        //         connected_graph_cnt++;
        //     }
        // }

        // 2-2) BFS
        for(int i=1;i<=n;i++){
            if(check[i]==false){
                BFS(i);
                connected_graph_cnt++;
            }
        }

        System.out.println(connected_graph_cnt);
    }
    
}
