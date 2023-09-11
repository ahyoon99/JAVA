package Algorithm;

import java.util.*;
import java.io.*;

public class B1946 {
    static public void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");
        int t = Integer.parseInt(st.nextToken());
        for(int tc=0;tc<t;tc++){
            st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            
            int[] score = new int[n+1];
            for(int i=0;i<n;i++){
                st = new StringTokenizer(br.readLine(), " ");
                int n1 = Integer.parseInt(st.nextToken());
                int n2 = Integer.parseInt(st.nextToken());
                score[n1]=n2;
            }

            int answer=1;
            int maxRank = score[1];
            for(int i=2;i<=n;i++){
                if(score[i]<maxRank){
                    answer++;
                    maxRank=score[i];
                }
            }

            System.out.println(answer);
        }
    }
}
