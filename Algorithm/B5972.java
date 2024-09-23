package Algorithm;

import java.util.*;
import java.io.*;

public class B5972 {
    static int n;
    static int m;
    static ArrayList<Node>[] matrix;
    static int[] distance;

    static class Node implements Comparable<Node>{
        int end;
        int dist;

        Node(){}
        Node(int end, int dist){
            this.end=end;
            this.dist=dist;
        }

        @Override
        public int compareTo(Node next){
            return this.dist - next.dist;
        }
    }

    static public void main(String args[]) throws IOException{
        input();
        dijkstra();

        System.out.println(distance[n]);
    }

    static void dijkstra(){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[n+1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        pq.add(new Node(1, 0));
        distance[1]=0;

        while(!pq.isEmpty()){
            Node now = pq.poll();
            if(visited[now.end]){
                continue;
            }
            visited[now.end]=true;

            ArrayList<Node> temp = matrix[now.end];
            for(int i=0;i<temp.size();i++){
                Node next = temp.get(i);
                if(distance[next.end]>distance[now.end]+next.dist){
                    distance[next.end]=distance[now.end]+next.dist;
                    pq.add(new Node(next.end, distance[next.end]));
                }
            }
        }


    }

    static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        matrix = new ArrayList[n+1];
        
        for(int i=0;i<n+1;i++){
            matrix[i] = new ArrayList<Node>();
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            
            boolean isExist = false;
            ArrayList<Node> temp = matrix[start];
            for(int j=0;j<temp.size();j++){
                if(temp.get(j).end==end){
                    if(temp.get(j).dist>dist){
                        temp.get(j).dist = dist;
                        isExist = true;
                        break;
                    }
                }
            }
            if(isExist){
                temp = matrix[end];
                for(int j=0;j<temp.size();j++){
                    if(temp.get(j).end==start){
                        if(temp.get(j).dist>dist){
                            temp.get(j).dist = dist;
                            break;
                        }
                    }
                }   
            }
            if(!isExist){
                matrix[start].add(new Node(end, dist));
                matrix[end].add(new Node(start, dist));
            }
        }

        distance = new int[n+1];
    }

    static void printMatrix(){
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].size();j++){
                System.out.print(matrix[i].get(j).end +"," + matrix[i].get(j).dist+" / ");
            }
            System.out.println();
        }
    }
}
