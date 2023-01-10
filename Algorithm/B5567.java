package Algorithm;

import java.util.*;

public class B5567 {
    static boolean[][] relationship;
    static boolean[] visited;
    static int[] relationshipDepth;

    static void BFS(int n){
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1]=true;
        relationshipDepth[1]=0;

        while(!q.isEmpty()){
            int person = q.poll();
            for(int i=1;i<n+1;i++){
                if(relationship[person][i]==true && visited[i]==false){
                    q.add(i);
                    visited[i]=true;
                    relationshipDepth[i]=relationshipDepth[person]+1;
                }
            }
        }
    }

    static int countFriends(int n){
        int friendsCnt = 0;
        for(int i=1;i<n+1;i++){
            if(relationshipDepth[i]==1 || relationshipDepth[i]==2){
                friendsCnt++;
            }
        }
        return friendsCnt;
    }

    static public void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        relationship = new boolean[n+1][n+1];
        for(int i=0;i<m;i++){
            int friend1 = sc.nextInt();
            int friend2 = sc.nextInt();
            relationship[friend1][friend2]=true;
            relationship[friend2][friend1]=true;
        }

        visited = new boolean[n+1];
        relationshipDepth = new int[n+1];

        BFS(n);
        int result = countFriends(n);
        System.out.println(result);
    }
}
