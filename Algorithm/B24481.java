package Algorithm;

import java.util.*;
import java.io.*;

public class B24481 {
    static int n;
    static int m;
    static int r;
    static ArrayList<ArrayList<Integer>> matrix;
    static int[] depth;
    static boolean[] visited;

    static public void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        matrix = new ArrayList<ArrayList<Integer>>();  
        for(int i=0;i<=n;i++){
            matrix.add(new ArrayList<Integer>());
        }

        depth = new int[n+1];
        Arrays.fill(depth, -1);

        visited = new boolean[n+1];

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine(), " ");
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            matrix.get(num1).add(num2);
            matrix.get(num2).add(num1);
        }

        for(int i=0;i<=n;i++){
            Collections.sort(matrix.get(i));
        }

        depth[r]=0;
        dfsByRecursion(r);
        
        for(int i=1;i<=n;i++){
            System.out.println(depth[i]);
        }
    }

    static void dfsByRecursion(int x){
        if(visited[x]){
            return;
        }
        
        visited[x]=true;
        ArrayList<Integer> temp = matrix.get(x);
        for(int i=0;i<temp.size();i++){
            if(visited[temp.get(i)]==false){
                depth[temp.get(i)]=depth[x]+1;
                dfsByRecursion(temp.get(i));
            }
        }
    }
}
