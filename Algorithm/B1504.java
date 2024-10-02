package Algorithm;

import java.util.*;
import java.io.*;

public class B1504 {
    static int n;
    static int e;
    static int v1;
    static int v2;
    static ArrayList<Node>[] graph;

    static class Node implements Comparable<Node>{
        int num;
        int distance;

        Node(){}
        Node(int num, int distance){
            this.num=num;
            this.distance=distance;
        }

        @Override
        public int compareTo(Node next){
            return this.distance - next.distance;
        }
    }
    static public void main(String args[]) throws IOException{
        System.setIn(new FileInputStream("res/input.txt"));
        input();
        solution();
    }

    static void solution(){
        int answer = -1;

        int root1 = dijkstra(1, v1);
        int root2 = dijkstra(v1, v2);
        int root3 = dijkstra(v2, n);
        if(root1!=-1 && root2!=-1 && root3!=-1){
            answer = root1+root2+root3;
        }

        root1 = dijkstra(1, v2);
        root2 = dijkstra(v2, v1);
        root3 = dijkstra(v1, n);
        if(root1!=-1 && root2!=-1 && root3!=-1){
            if(answer>root1+root2+root3){
                answer=root1+root2+root3;
            }
        }

        System.out.println(answer);
    }

    static int dijkstra(int start, int end){
        boolean[] visited = new boolean[n+1];
        int[] distance = new int[n+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.add(new Node(start, 0));
        distance[start]=0;

        while(!pq.isEmpty()){
            Node now = pq.poll();
            if(visited[now.num]){
                continue;
            }
            visited[now.num]=true;

            for(int i=0;i<graph[now.num].size();i++){
                Node next = graph[now.num].get(i);
                if(distance[next.num]>distance[now.num]+next.distance){
                    distance[next.num] = distance[now.num]+next.distance;
                    pq.add(new Node(next.num, distance[next.num]));
                }
            }
        }

        if(distance[end]==Integer.MAX_VALUE){
            return -1;
        }
        else{
            return distance[end];
        }
    }

    static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n+1];
        for(int i=0;i<=n;i++){
            graph[i]=new ArrayList<Node>();
        }

        for(int i=0;i<e;i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[start].add(new Node(end, weight));
            graph[end].add(new Node(start, weight));            
        }

        st = new StringTokenizer(br.readLine(), " ");
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());
    }
}
