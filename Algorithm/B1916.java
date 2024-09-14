package Algorithm;

import java.util.*;
import java.io.*;

// B1916 최소비용 구하기
public class B1916 {
    static int n;
    static int m;
    static ArrayList<Node>[] graph;
    static int start;
    static int end;
    static int distance[];

    static class Node implements Comparable<Node>{
        int dest;
        int dist;

        Node(int dest, int dist){
            this.dest = dest;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node next){
            return this.dist - next.dist;
        }
    }
    static public void main(String args[]) throws IOException{
        input();
        dijkstra();

        System.out.println(distance[end]);
    }

    static void dijkstra(){
        boolean[] visited = new boolean[n+1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        distance[start]=0;

        while(!pq.isEmpty()){
            Node node = pq.poll();
            int id = node.dest;
            if(visited[id]){
                continue;
            }
            visited[id]=true;
            for(int i=0;i<graph[id].size();i++){
                int nextId = graph[id].get(i).dest;
                if(distance[nextId]>distance[id]+graph[id].get(i).dist){
                    distance[nextId]=distance[id]+graph[id].get(i).dist;
                    pq.add(new Node(nextId, distance[nextId]));
                }
            }
        }
    }

    static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n+1];
        for(int i=0;i<=n;i++){
            graph[i] = new ArrayList<Node>();
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            graph[s].add(new Node(e, d));
        }

        st = new StringTokenizer(br.readLine(), " ");
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        distance = new int[n+1];
    }
}
