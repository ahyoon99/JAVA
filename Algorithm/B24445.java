package Algorithm;

import java.util.*;
import java.io.*;

public class B24445 {
    static int n;
    static int m;
    static int r;
    static ArrayList<ArrayList<Integer>> matrix;
    static int[] orders;
    static int order;

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

        orders = new int[n+1];
        Arrays.fill(orders, -1);
        order=1;

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine(), " ");
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            matrix.get(num1).add(num2);
            matrix.get(num2).add(num1);
        }

        for(int i=0;i<=n;i++){
            Collections.sort(matrix.get(i), Collections.reverseOrder());
        }

        dfs();

        for(int i=1;i<=n;i++){
            if(orders[i]==-1){
                System.out.println(0);
            }
            else{
                System.out.println(orders[i]);
            }
        }
    }

    static void dfs(){
        Queue<Integer> q = new LinkedList<>();

        q.add(r);
        orders[r]=order;
        order++;

        while(!q.isEmpty()){
            int num = q.poll();
            for(int i=0;i<matrix.get(num).size();i++){
                int next = matrix.get(num).get(i);
                if(orders[next]==-1){
                    q.add(next);
                    orders[next]=order;
                    order++;
                }
            }
        }
    }
}
