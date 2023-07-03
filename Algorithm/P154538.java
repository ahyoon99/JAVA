package Algorithm;

import java.util.*;

public class P154538 {
    static public void main(String args[]){
        int x = 10;
        int y = 40;
        int n = 5;

        int result = solution(x, y, n);
        System.out.println(result);
    }

    static public int solution(int x, int y, int n) {
        int answer = 0;
        
        int[] dp = new int[1000001];
        Arrays.fill(dp,-1);
        
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        dp[x]=0;
        
        while(!q.isEmpty()){
            x = q.poll();
            if(x+n<1000001 && dp[x+n]==-1){
                dp[x+n]=dp[x]+1;
                q.add(x+n);
            }
            if(x*2<1000001 && dp[x*2]==-1){
                dp[x*2]=dp[x]+1;
                q.add(x*2);
            }
            if(x*3<1000001 && dp[x*3]==-1){
                dp[x*3]=dp[x]+1;
                q.add(x*3);
            }
        }
        answer = dp[y];
        return answer;
    }
}
