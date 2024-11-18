package Algorithm;

import java.util.*;
import java.io.*;

public class swea1206 {
    static int n;
    static int answer;

    // 방법 1
    static int[] buildings;

    // 방법 2
    static boolean[][] apt;
    static public void main(String args[]) throws IOException{

        System.setIn(new FileInputStream("res/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0;i<10;i++){
            // 방법 1
            // solution(br);
            // System.out.println("#"+(i+1)+" "+answer);

            // 방법 2
            solution2(br);
            System.out.println("#"+(i+1)+" "+answer);
        }
    }

    static void solution2(BufferedReader br) throws IOException{
        input2(br);
        for(int i=2;i<n-2;i++){
            for(int j=0;j<256;j++){
                if(!apt[i][j]){
                    break;
                }
                if(apt[i][j]){
                    if(!apt[i-2][j] && !apt[i-1][j] && !apt[i+1][j] && !apt[i+2][j]){
                        answer++;
                    }
                }
            }
        }
    }

    static void input2(BufferedReader br) throws IOException{
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        apt = new boolean[n][256];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<n;i++){
            int height = Integer.parseInt(st.nextToken());
            for(int j=0;j<height;j++){
                apt[i][j]=true;
            }
        }

        answer = 0;
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
