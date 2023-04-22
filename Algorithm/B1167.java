package Algorithm;

import java.util.*;

public class B1167 {
    
    static class Node{
        int end;
        int weight;

        Node(){}
        Node(int end, int weight){
            this.end = end;
            this.weight = weight;
        }
    }

    static int v;
    static ArrayList<Node>[] tree;
    static int idx=-1;
    static int max=-1;

    static public void main(String args[]){
        Scanner sc = new Scanner(System.in);
        v = sc.nextInt();
        tree = new ArrayList[v];
        for(int i=0;i<v;i++){
            tree[i] = new ArrayList<>();
        }

        for(int i=0;i<v;i++){
            int start = sc.nextInt()-1;
            while(true){
                int n = sc.nextInt();
                if(n==-1){
                    break;
                }
                int w = sc.nextInt();
                tree[start].add(new Node(n-1, w));
            }
        }
        // 1. 가장 긴 지름을 만드는 노드 node1과 node2가 있다고 가정한다면,
        // 2. 임의의 노드(0)에서 가장 먼 노드인 node1 찾기 
        BFS(0);
        int node1 = idx;

        // 3. node1에서 가장 먼 노드인 node2 찾기
        BFS(node1);
        
        System.out.println(max);
    }

    static public void BFS(int n){
        boolean[] visited = new boolean[v];
        Queue<Integer> q = new LinkedList<>();
        int[] distance = new int[v];
        q.add(n);
        visited[n]=true;

        while(!q.isEmpty()){
            int num = q.poll();
            for(int i=0;i<tree[num].size();i++){
                Node newNode = tree[num].get(i);
                int end = newNode.end;
                int weight = newNode.weight;
                int dist = distance[num]+weight;
                if(visited[end]==false && distance[end]<dist){
                    distance[end]=dist;
                    visited[end]=true;
                    q.add(end);
                }
            }
        }
        findMaxNode(distance);
    }

    static public void findMaxNode(int[] distance){
        for(int i=0;i<distance.length;i++){
            if(max<distance[i]){
                max = distance[i];
                idx=i;
            }
        }
    }

}
