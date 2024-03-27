package Algorithm;

import java.util.*;

public class P258712 {
    static public void main(String args[]){
        String[] friends = {"muzi", "ryan", "frodo", "neo"};
        String[] gifts = {"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"};

        int result = solution(friends, gifts);
        System.out.println(result);
    }

    static int solution(String[] friends, String[] gifts) {
        int answer = 0;
        
        int n = friends.length;
        HashMap<String, Integer> nameId = new HashMap<>();
        for(int i=0;i<n;i++){
            nameId.put(friends[i], i);
        }
        
        int[][] log = new int[n][n];
        int[][] cnt = new int[n][3];
        
        int[] result = new int[n];
        
        for(int i=0;i<gifts.length;i++){
            String[] com = gifts[i].split(" ");
            int p1 = nameId.get(com[0]);
            int p2 = nameId.get(com[1]);
            log[p1][p2]++;
            cnt[p1][0]++;
            cnt[p2][1]++;
        }
        
        for(int i=0;i<n;i++){
            cnt[i][2]=cnt[i][0]-cnt[i][1];
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j){
                    continue;
                }
                if(log[i][j]==0 && log[j][i]==0){
                    if(cnt[i][2]>cnt[j][2]){
                        result[i]++;
                    }
                }
                else if(log[i][j]>log[j][i]){
                    result[i]++;
                }
                else if(log[i][j]==log[j][i]){
                    if(cnt[i][2]>cnt[j][2]){
                        result[i]++;
                    }
                }
            }
        }
        
        Arrays.sort(result);
        answer = result[n-1];
        
        return answer;
    }
}
