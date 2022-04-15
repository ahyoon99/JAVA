package Algorithm;

import java.util.ArrayList;
import java.util.Scanner;

public class B13023 {
    static class Edge{
        int from, to;
        Edge(int from, int to){
            this.from = from;
            this.to = to;
        }
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        boolean[][] a = new boolean[n][n];  // 2차원 boolean 배열 : 인접행렬이라고 생각
        ArrayList<Integer>[] g = (ArrayList<Integer>[]) new ArrayList[n];   // 인접리스트라고 생각
        for(int i=0;i<n;i++){
            g[i] = new ArrayList<Integer>();
        }
        ArrayList<Edge> edges = new ArrayList<>();  // 인접리스트라고 생각

        for(int i=0;i<m;i++){
            int from = sc.nextInt();
            int to = sc.nextInt();
            edges.add(new Edge(from,to));
            edges.add(new Edge(to,from));
            a[from][to]=true;
            a[to][from]=true;
            g[from].add(to);
            g[to].add(from);
        }
        
        // edge(to->from)는 원래 m개
        // to->from도 추가를 해주었기 때문에
        // => 총 edge의 개수는 2*m개가 된다.
        m = 2*m;

        for(int i=0; i<m; i++){
           for(int j=0;j<m;j++){
               int A = edges.get(i).from;
               int B = edges.get(i).to;
               int C = edges.get(j).from;
               int D = edges.get(j).to;
               if(A==B || A==C || A==D || B==C || B==D || C==D){
                   continue;
               }
               // A,B,C,D가 겹치지 않은 경우 찾음!
               if(!a[B][C]){
                   continue;
               }
               // A,B,C,D가 겹치고 않고 && B와 C가 친구인 경우 찾음!
               for(int E : g[D]){
                   if(E==A || E==B || E==C || E==D){
                       continue;
                   }
                   // A->B->C->D->E 인 친구관계 발견!
                   System.out.println("1");
                   return;
               }
           } 
        }
        System.out.println("0");
        return;
    }
    
}
