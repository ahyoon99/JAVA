package Algorithm;

import java.util.*;
import java.io.*;

public class B2875 {
    static public void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        while(k>0){
            if(n%2==1){
                n--;
                k--;
                continue;
            }
            
            int nTeam = n/2;
            int mTeam = m;
            if(nTeam>mTeam){
                n--;
                k--;
            }
            else if(nTeam<mTeam){
                m--;
                k--;
            }
            else if(nTeam==mTeam){
                n-=2;
                m-=1;
                k-=3;
            }
        }

        int teams = Math.min(n/2, m);
        System.out.println(teams);
    }
}
