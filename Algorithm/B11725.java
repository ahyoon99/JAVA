package Algorithm;

import java.util.*;
import java.io.*;

public class B11725 {
    static int n;
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;
    static int[] parent;
    static public void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        graph = new ArrayList<ArrayList<Integer>>();
        visited = new boolean[n+1];
        parent = new int[n+1];
        parent[1]=-1;

        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<Integer>());
        }

        for(int i=0;i<n-1;i++){
            st = new StringTokenizer(br.readLine(), " ");
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            graph.get(n1).add(n2);
            graph.get(n2).add(n1);
        }

        //BFS();

        DFS();

        for(int i=2;i<=n;i++){
            System.out.println(parent[i]);
        }

    }

    static void BFS(){
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1]=true;
        
        while(!q.isEmpty()){
            int num = q.poll();
            ArrayList<Integer> med = graph.get(num);
            for(int i=0;i<med.size();i++){
                int next = med.get(i);
                if(visited[next]==false){
                    q.add(next);
                    visited[next]=true;
                    parent[next]=num;
                }
            }
        }
    }

    static void DFS(){
        Stack<Integer> st = new Stack<>();

        st.add(1);
        visited[1]=true;
        boolean flag;

        while(!st.isEmpty()){
            int num = st.peek();
            ArrayList<Integer> med = graph.get(num);
            flag=false;
            for(int i=0;i<med.size();i++){
                int next = med.get(i);
                if(visited[next]==false){
                    st.add(next);
                    parent[next]=num;
                    visited[next]=true;
                    flag=true;
                    break;
                }
            }
            if(!flag){
                st.pop();
            }
        }
    }
}
