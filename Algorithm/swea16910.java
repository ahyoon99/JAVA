package Algorithm;

import java.util.*;
import java.io.*;

public class swea16910 {
    static int n;
    static int answer;
    public static void main(String args[]) throws Exception
	{
	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int T = Integer.parseInt(st.nextToken());

		for(int test_case = 1; test_case <= T; test_case++)
		{
            System.out.print("#"+test_case+" ");
			solution(br, st);
		}
	}

    static public void solution(BufferedReader br, StringTokenizer st) throws Exception{
        input(br, st);

        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(distance(i,j)<=n*n){
                    answer++;
                }
            }
        }
        answer*=4;
        answer+=(4*n+1);
        System.out.println(answer);
    }

    static public void input(BufferedReader br, StringTokenizer st) throws Exception{
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());

        answer=0;
    }

    static public int distance(int x, int y){
        return x*x+y*y;
    }
}
