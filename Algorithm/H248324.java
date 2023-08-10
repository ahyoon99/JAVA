package Algorithm;

import java.util.*;
import java.io.*;

/* 입력예제1
5 3
1 2 3 4 5
1 3
2 4
2 5
*/
public class H248324 {
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] w = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<n;i++){
            w[i]=Integer.parseInt(st.nextToken());
        }
        
        ArrayList<Integer>[] friendship = new ArrayList[n];
        for(int i=0;i<n;i++){
            friendship[i]=new ArrayList<Integer>();
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine(), " ");
            int p1 = Integer.parseInt(st.nextToken()) -1;
            int p2 = Integer.parseInt(st.nextToken()) -1;
            friendship[p1].add(p2);
            friendship[p2].add(p1);
        }

        int answer = 0;
        for(int i=0;i<n;i++){
            int myscore = w[i];
            boolean check=true;
            if(friendship[i].size()==0){
                answer++;
                continue;
            }
            for(int j=0;j<friendship[i].size();j++){
                int other = friendship[i].get(j);
                if(myscore<=w[other]){
                    check=false;
                    break;
                }
            }
            if(check){
                answer++;
            }
        }
        System.out.println(answer);
    }
}
