package Algorithm;

import java.util.*;
import java.io.*;

public class swea1206 {
    static int n;
    static int[] buildings;
    static int answer;
    static public void main(String args[]) throws IOException{

        System.setIn(new FileInputStream("res/input_swea1206.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0;i<10;i++){
            solution(br);
            System.out.println("#"+(i+1)+" "+answer);
        }
    }
    
    static public void solution(BufferedReader br) throws IOException{
        input(br);

        for(int i=2;i<n-2;i++){
            int prev1 = buildings[i-1];
            int prev2 = buildings[i-2];
            int maxPrev = Math.max(prev1, prev2);
            if(buildings[i]<=maxPrev){
                continue;
            }

            int next1 = buildings[i+1];
            int next2 = buildings[i+2];
            int maxNext = Math.max(next1, next2);
            if(buildings[i]<=maxNext){
                continue;
            }

            int max = Math.max(maxPrev, maxNext);
            answer+=(buildings[i]-max);
            
        }
    }

    static public void input(BufferedReader br) throws IOException{
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());

        buildings = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<n;i++){
            buildings[i]=Integer.parseInt(st.nextToken());
        }
        answer=0;
    }
}
