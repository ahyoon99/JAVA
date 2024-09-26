package Algorithm;

import java.util.*;
import java.io.*;

public class B1238 {
    static int n;
    static int m;
    static int x;
    static ArrayList<Node>[] village;
    static int[] times;

    static class Node implements Comparable<Node>{
        int end;
        int dist;
        Node(){}
        Node(int end, int dist){
            this.end = end;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node next){
            return this.dist - next.dist;
        }
    }
    static public void main(String args[]) throws IOException{
        input();
        solution();
    }

    static void solution(){
        for(int i=1;i<=n;i++){
            dijkstra(i, x, false);
        }

        for(int i=1;i<=n;i++){
            dijkstra(x, i, true);
        }

        Arrays.sort(times);
        System.out.println(times[n]);
    }

    static void dijkstra(int start, int end, boolean reverse){
        if(start==end){
            return;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[n+1];
        int[] distance = new int[n+1];

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start]=0;
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()){
            Node node = pq.poll();
            if(visited[node.end]){
                continue;
            }
            visited[node.end]=true;

            ArrayList<Node> temp = village[node.end];
            for(int i=0;i<temp.size();i++){
                Node next = temp.get(i);
                if(distance[next.end]>distance[node.end]+next.dist){
                    distance[next.end]=distance[node.end]+next.dist;
                    pq.add(new Node(next.end, distance[next.end]));
                }
            }
        }
        if(!reverse){
            times[start]+=distance[end];
        }
        else{
            times[end]+=distance[end];
        }
    }

    static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        village = new ArrayList[n+1];
        for(int i=0;i<=n;i++){
            village[i] = new ArrayList<Node>();
        }
        
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            village[start].add(new Node(end, dist));
        }
        
        times = new int[n+1];
    }
}
