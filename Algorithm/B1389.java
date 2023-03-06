package Algorithm;

import java.util.*;

public class B1389 {
    static public void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] friends = new int[n][n];
        int[][] result = new int[n][n];
        for(int i=0;i<m;i++){
            int start = sc.nextInt();
            int end = sc.nextInt();
            friends[start-1][end-1]=1;
            friends[end-1][start-1]=1;
        }

        for(int i=0;i<n;i++){
            boolean[] visited = new boolean[n];
            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            visited[i]=true;
            result[i][i]=0;
            while(!q.isEmpty()){
                int num = q.poll();
                for(int j=0;j<n;j++){
                    if(friends[num][j]==1 && visited[j]==false){
                        q.add(j);
                        visited[j]=true;
                        result[i][j]=result[i][num]+1;
                    }
                }
            }
        }

        int min=-1;
        int minValue=-1;
        int total=0;
        for(int i=0;i<n;i++){
            total=0;
            for(int j=0;j<n;j++){
                total+=result[i][j];
            }
            if(minValue==-1 || minValue>total){
                minValue = total;
                min = i;
            }
        }
        System.out.println(min+1);
    }
}
