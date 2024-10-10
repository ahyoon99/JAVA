package Algorithm;

import java.util.*;
import java.io.*;

public class B1753 {
    static int v;
    static int e;
    static int k;
    static ArrayList<Node>[] graph;
    static int[] distance;

    static class Node implements Comparable<Node>{
        int id;
        int weight;
        Node(){}
        Node(int id, int weight){
            this.id = id;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node next){
            return this.weight - next.weight;
        }
    }
    static public void main(String args[]) throws IOException{
        System.setIn(new FileInputStream("res/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        input(br);

        dijkstra();     
        
        for(int i=0;i<v;i++){
            if(distance[i]==Integer.MAX_VALUE){
                sb.append("INF").append("\n");
            }
            else{
                sb.append(distance[i]).append("\n");
            }
        }

        System.out.print(sb);
    }

    static void dijkstra(){
        distance = new int[v];
        Arrays.fill(distance, Integer.MAX_VALUE);

        boolean[] visited = new boolean[v];
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.add(new Node(k, 0));
        distance[k]=0;
        
        while(!pq.isEmpty()){
            Node now = pq.poll();
            if(visited[now.id]){
                continue;
            }
            visited[now.id] = true;
            
            ArrayList<Node> arr = graph[now.id];
            for(int i=0;i<arr.size();i++){
                int nextId = arr.get(i).id;
                if(distance[nextId]>distance[now.id]+arr.get(i).weight){
                    distance[nextId] = distance[now.id]+arr.get(i).weight;
                    pq.add(new Node(nextId, distance[nextId]));
                }
            }
        }

    }
    
    static void input(BufferedReader br) throws IOException{
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());


        st = new StringTokenizer(br.readLine(), " ");
        k = Integer.parseInt(st.nextToken())-1;

        graph = new ArrayList[v];
        for(int i=0;i<v;i++){
            graph[i] = new ArrayList<Node>();
        }

        for(int i=0;i<e;i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken())-1;
            int end = Integer.parseInt(st.nextToken())-1;
            int weight = Integer.parseInt(st.nextToken());

            graph[start].add(new Node(end, weight));
        }
    }
}
