package Algorithm;

import java.util.*;

public class P86971 {
    static class Node{
        int x;
        int y;
        
        Node(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    
    static public void main(String args[]){
        int n = 9;
        int[][] wires = {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};

        int result = solution(n, wires);
        System.out.println(result);
    }

    static public int solution(int n, int[][] wires) {
        int answer = -1;
        
        for(int tc=0;tc<wires.length;tc++){
            
            ArrayList<Integer>[] tree = new ArrayList[n+1];
            for(int i=0;i<n+1;i++){
                tree[i] = new ArrayList<Integer>();
            }
            
            for(int i=0;i<wires.length;i++){
                if(i==tc){
                    continue;
                }
                tree[wires[i][0]].add(wires[i][1]);
                tree[wires[i][1]].add(wires[i][0]);
            }
            
            ArrayList<Integer> cnts = new ArrayList<>();
            boolean[] visited = new boolean[n+1];
            for(int i=1;i<n+1;i++){
                if(!visited[i]){
                    cnts.add(bfs(tree, visited,i));
                }
            }
            
            Collections.sort(cnts);
            if(answer==-1 || answer> cnts.get(1)-cnts.get(0)){
                answer = cnts.get(1)-cnts.get(0);
            }
        }
        
        return answer;
    }
    
    static int bfs(ArrayList<Integer>[] tree, boolean[] visited, int n){
        if(visited[n]){
            return -1;
        }
        
        int cnt=0;
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        visited[n]=true;
        cnt++;
        
        while(!q.isEmpty()){
            int x = q.poll();
            for(int i=0;i<tree[x].size();i++){
                if(visited[tree[x].get(i)]==false){
                    q.add(tree[x].get(i));
                    visited[tree[x].get(i)]=true;
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
