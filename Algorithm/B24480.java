package Algorithm;

import java.util.*;
import java.io.*;

public class B24480 {
    static int n;
    static int m;
    static int r;
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;
    static int[] distance;
    static int cnt;
    
    static public void main(String args[]) throws IOException{
        solution();
    }

    static void solution() throws IOException{
        input();

        DFSByRecursion(r);

        for(int i=1;i<=n;i++){
            System.out.println(distance[i]);
        }
    }

    static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        visited = new boolean[n+1];
        distance = new int[n+1];
        cnt = 1;

        graph = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<Integer>());
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        for(int i=0;i<=n;i++){
            Collections.sort(graph.get(i), Collections.reverseOrder());
        }
    }

    static void DFSByRecursion(int num){   
        if(visited[num]){
            return;
        }

        visited[num]=true;
        distance[num]=cnt;

        ArrayList<Integer> arr = graph.get(num);
        for(int i=0;i<arr.size();i++){
            if(visited[arr.get(i)]==false){
                cnt++;
                DFSByRecursion(arr.get(i));
            }
        }
    }
}