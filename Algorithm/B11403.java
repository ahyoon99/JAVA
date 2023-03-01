package Algorithm;

import java.util.*;

public class B11403 {

    static class Pair{
        int x;
        int y;
        Pair(){}
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static public void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] map = new int[n][n];
        int[][] result = new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int temp = sc.nextInt();
                map[i][j]=temp;
                result[i][j]=temp;
            }
        }

        for(int i=0;i<n;i++){
            Queue<Integer> q = new LinkedList<>();
            boolean[] visited = new boolean[n];
            q.add(i);
            while(!q.isEmpty()){
                int num = q.poll();
                
                for(int j=0;j<n;j++){
                    if(map[num][j]==1 && visited[j]==false){
                        q.add(j);
                        visited[j]=true;
                        result[i][j]=1;
                    }
                }
            }
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }
    }
}
