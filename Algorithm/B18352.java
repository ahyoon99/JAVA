package Algorithm;

import java.util.*;
import java.io.*;

public class B18352 {
    static int n;
    static int m;
    static int k;
    static int x;
    static ArrayList<ArrayList<Integer>> matrix;

    static int[] distance;
    static public void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        matrix = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<=n;i++){
            matrix.add(new ArrayList<Integer>());
        }

        distance = new int[n+1];

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine(), " ");
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            matrix.get(n1).add(n2);
        }

        dfs();

        boolean flag=false;
        for(int i=1;i<=n;i++){
            if(distance[i]==k){
                System.out.println(i);
                flag=true;
            }
        }

        if(!flag){
            System.out.println("-1");
        }
    }

    static void dfs(){
        Queue<Integer> q = new LinkedList<>();
        Arrays.fill(distance, -1);

        q.add(x);
        distance[x]=0;

        while(!q.isEmpty()){
            int num = q.poll();
            ArrayList<Integer> temp = matrix.get(num);
            for(int i=0;i<temp.size();i++){
                if(distance[temp.get(i)]==-1){
                    q.add(temp.get(i));
                    distance[temp.get(i)]=distance[num]+1;
                }
            }
        }
    }
}
