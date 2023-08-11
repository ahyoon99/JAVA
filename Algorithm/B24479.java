package Algorithm;

import java.util.*;
import java.io.*;

public class B24479 {
    static ArrayList<ArrayList<Integer>> ground;
    static int[] orders;
    static int n;
    static int times;

    static public void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        

        ground = new ArrayList<>();
        for(int i=0;i<n;i++){
            ground.add(new ArrayList<Integer>());
        }

        orders = new int[n];

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken())-1;
            int end = Integer.parseInt(st.nextToken())-1;
            ground.get(start).add(end);
            ground.get(end).add(start);
        }

        for(int i=0;i<n;i++){
            Collections.sort(ground.get(i));
        }
        
        times=1;
        DFS(r-1);

        for(int i=0;i<orders.length;i++){
            sb.append(orders[i]).append("\n");
        }
        System.out.println(sb);
    }

    static public void DFS(int r){
        orders[r]=times;
        for(int i=0;i<ground.get(r).size();i++){
            int newVertex = ground.get(r).get(i);
            if(orders[newVertex]==0){
                times++;
                DFS(newVertex);
            }
        }
    }
    
}
