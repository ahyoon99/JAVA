package Algorithm;
import java.util.*;

public class P92342 {
    static int[] apeach;
    static int[] answer = {-1};
    static int maxDiffScore=-100;
    
    static void dfs(int[] ryan, int depth, int n){
        if(depth==n+1){
            int apeachScore = 0;
            int ryanScore = 0;
            for(int i=0; i<11; i++){
                if(apeach[i]!=0 || ryan[i]!=0){
                    if(ryan[i]<=apeach[i]){
                        apeachScore+=(10-i);
                    }
                    else{
                        ryanScore+=(10-i);
                    }
                }
            }
            if(ryanScore<=apeachScore){
                return;
            }
            else if(maxDiffScore <= ryanScore-apeachScore){
                maxDiffScore = ryanScore-apeachScore;
                answer = ryan.clone();
            }
            return ;
        }
        
        for(int j=0; j<=10 && ryan[j]<=apeach[j]; j++){
            ryan[j]++;
            dfs(ryan, depth+1, n);
            ryan[j]--;
        }
    }
        
    static public int[] solution(int n, int[] info) {
        apeach = info;
        int[] ryan = new int[11];
        dfs(ryan, 1, n);
        return answer;
    }

    static public void main(String args[]){
        int n = 5;
        int[] info = {2,1,1,1,0,0,0,0,0,0,0};
        int[] result = solution(n, info);
        for(int i=0;i<result.length;i++){
            System.out.print(result[i]+" ");
        }
        System.out.println();
    }
}
