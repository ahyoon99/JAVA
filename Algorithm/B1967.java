package Algorithm;

import java.util.*;
import java.io.*;

public class B1967 {
    // 방법 1 : dijkstra
    static int n;
    static ArrayList<Node>[] graph;
    static int maxValue=Integer.MIN_VALUE;
    static int maxIdx=-1;

    static class Node implements Comparable<Node>{
        int child;
        int weight;

        Node(){}
        Node(int child, int weight){
            this.child=child;
            this.weight=weight;
        }

        @Override
        public int compareTo(Node next){
            return this.weight - next.weight;
        }
    }
    static public void main(String args[]) throws IOException{
        System.setIn(new FileInputStream("res/input.txt"));

        input();

        dijkstra(1);
        dijkstra(maxIdx);

        System.out.println(maxValue);
    }

    static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[n+1];
        int[] distance = new int[n+1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        pq.add(new Node(start, 0));
        distance[start]=0;

        while(!pq.isEmpty()){
            Node node = pq.poll();
            if(visited[node.child]){
                continue;
            }
            visited[node.child]=true;

            ArrayList<Node> children = graph[node.child];
            for(int i=0;i<children.size();i++){
                if(distance[children.get(i).child] > distance[node.child]+children.get(i).weight){
                    distance[children.get(i).child] = distance[node.child]+children.get(i).weight;
                    pq.add(new Node(children.get(i).child, distance[children.get(i).child]));
                }
            }
        }

        maxValue=Integer.MIN_VALUE;
        maxIdx=-1;

        for(int i=1;i<n+1;i++){
            if(maxValue<distance[i]){
                maxValue=distance[i];
                maxIdx=i;
            }
        }
    }

    static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n+1];
        for(int i=0;i<n+1;i++){
            graph[i] = new ArrayList<Node>();
        }

        for(int i=0;i<n-1;i++){
            st = new StringTokenizer(br.readLine(), " ");
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph[parent].add(new Node(child, weight));
            graph[child].add(new Node(parent, weight));
        }
    }
}
