package Algorithm;

import java.util.*;
import java.io.*;

public class B17396 {
    static int n;
    static int m;
    static int[] branch;
    static ArrayList<Node>[] graph;

    static class Node implements Comparable<Node>{
        int end;
        long dist;

        Node(){}
        Node(int end, long dist){
            this.end=end;
            this.dist=dist;
        }

        @Override
        public int compareTo(Node next){
            if(this.dist-next.dist>0){
                return 1;
            } 
            else{
                return -1;
            }
        }
    }

    static public void main(String args[]) throws IOException{
        input();
        dijkstra();
    }


    static void dijkstra(){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[n];
        long[] distance = new long[n];
        Arrays.fill(distance, Long.MAX_VALUE);

        pq.add(new Node(0,0));
        distance[0]=0;

        while(!pq.isEmpty()){
            Node now = pq.poll();
            if(now.end == (n-1)){
                break;
            }
            if(visited[now.end]){
                continue;
            }
            visited[now.end]=true;
            ArrayList<Node> next = graph[now.end];
            for(int i=0;i<next.size();i++){
                Node nextNode = next.get(i);
                if(branch[nextNode.end]==0 || nextNode.end==(n-1)){
                    if(distance[nextNode.end]>distance[now.end]+nextNode.dist){
                        distance[nextNode.end]=distance[now.end]+nextNode.dist;
                        pq.add(new Node(nextNode.end, distance[nextNode.end]));
                    }
                }
            }
        }

        if(distance[n-1]==Long.MAX_VALUE){
            System.out.println(-1);
        }
        else{
            System.out.println(distance[n-1]);
        }
    }

    static void input()throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        branch = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<n;i++){
            branch[i] = Integer.parseInt(st.nextToken());
        }

        graph = new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<Node>();
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            graph[start].add(new Node(end, dist));
            graph[end].add(new Node(start, dist));
        }
    }
}
