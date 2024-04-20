package Algorithm;

import java.util.*;
import java.io.*;

public class B9663 {
    static int n;
    static boolean[][] check;
    static int cnt;

    static public void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        
        check = new boolean[3][2*n];
        cnt = 0;

        for(int i=0;i<n;i++){
            check[0][i]=true;
            check[1][n-1-i]=true;
            check[2][i]=true;
            bfs(1);
            check[0][i]=false;
            check[1][n-1-i]=false;
            check[2][i]=false;
        }
        System.out.println(cnt);
    }

    static void bfs(int x){
        if(x==n){
            cnt++;
            return;
        }
        for(int i=0;i<n;i++){
            if(!checkValue(x, i)){
                continue;
            }
            check[0][i]=true;
            check[1][x-i+n-1]=true;
            check[2][x+i]=true;
            bfs(x+1);
            check[0][i]=false;
            check[1][x-i+n-1]=false;
            check[2][x+i]=false;
        }
        
    }

    static boolean checkValue(int x, int y){
        if(check[0][y]){
            return false;
        }
        else if(check[1][x-y+n-1]){
            return false;
        }
        else if(check[2][x+y]){
            return false;
        }
        return true;
    }

}
