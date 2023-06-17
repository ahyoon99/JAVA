package Algorithm;

import java.util.*;

public class P87946 {
    static int maxCnt=-1;
    static public void main(String args[]){
        int k = 80;
        int[][] dungeons = {{80,20},{50,40},{30,10}};

        int result = solution(k, dungeons);
        System.out.println(result);
    }

    static public int solution(int k, int[][] dungeons) {
        int[] result = new int[dungeons.length];
        boolean[] check = new boolean[dungeons.length];
        go(dungeons.length, 0, result, check, dungeons, k);
        
        return maxCnt;
    }
    
    static public void go(int n, int idx, int[] result, boolean[] check, int[][] dungeons, int k){
        if(idx>=result.length){
            int cnt = playGame(result, dungeons, k);
            if(cnt>maxCnt){
                maxCnt = cnt;
            }
        }
        
        for(int i=0;i<n;i++){
            if(check[i]==false){
                result[idx]=(i+1);
                check[i]=true;
                go(n, idx+1, result, check, dungeons, k);
                check[i]=false;
            }
        }
    }
    
    static int playGame(int[] result, int[][] dungeons, int k){
        int cnt=0;
        for(int i=0;i<result.length;i++){
            int idx = result[i]-1;
            if(k>=dungeons[idx][0]){
                k-=dungeons[idx][1];
                cnt++;
            }
        }
        return cnt;
    }
}
