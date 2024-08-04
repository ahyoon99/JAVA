package Algorithm;

import java.util.*;
import java.io.*;

public class swea6808 {
    static int t;
    static int n;
    static int r;
    static int[] num;
    static int[] arr1;
    static int[] arr2;
    static boolean[] used;
    static int winCnt;
    static int loseCnt;
    
    
    static public void main(String args[]) throws IOException {
        System.setIn(new FileInputStream("res/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        t = Integer.parseInt(st.nextToken());

        for(int testcase=1;testcase<=t;testcase++){
            System.out.print("#"+testcase+" ");
            input(br, st);
            solution();
        }
    }

    static void solution(){
        go(0);
        System.out.println(winCnt+" "+loseCnt);
    }

    static void go(int myIdx){
        if(myIdx>=r){
            calculation();
            // for(int i=0;i<r;i++){
            //     System.out.print(arr2[i]+ " ");
            // }
            // System.out.println();
            return;
        }

        for(int i=0;i<r;i++){
            if(used[i]){
                continue;
            }
            arr2[myIdx]=num[i];
            used[i]=true;
            go(myIdx+1);
            used[i]=false;
        }
    }

    static void calculation(){
        int score1 = 0;
        int score2 = 0;
        for(int i=0;i<r;i++){
            if(arr1[i]>arr2[i]){
                score1 += (arr1[i]+arr2[i]);
            }
            else{
                score2 += (arr1[i]+arr2[i]);
            }
        }

        if(score1>score2){
            winCnt++;
        }
        else if(score1<score2){
            loseCnt++;
        }
    }

    static void input(BufferedReader br, StringTokenizer st) throws IOException{
        n = 18;
        r = 9;

        num = new int[r];
        arr1 = new int[r];
        arr2 = new int[r];
        used = new boolean[r];

        boolean isValid[] = new boolean[n];

        winCnt = 0;
        loseCnt = 0;

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<r;i++){
            arr1[i] = Integer.parseInt(st.nextToken());
            isValid[arr1[i]-1]=true;
        }
        
        int idx=0;  
        for(int i=0;i<n;i++){
            if(isValid[i]){
                continue;
            }
            num[idx] = (i+1);
            idx++;
        }
    }
}
