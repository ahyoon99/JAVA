package Algorithm;

import java.util.*;

public class P42862 {
    static public void main(String args[]){
        int n = 5;
        int[] lost = {2,4};
        int[] reserve = {1,3,5};
        int result = solution(n, lost, reserve);
        System.out.println(result);
    }
    
    static public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        int[] isCloth = new int[n+1];
        
        for(int i=0;i<lost.length;i++){
            isCloth[lost[i]]--;
        }
        
        for(int i=0;i<reserve.length;i++){
            isCloth[reserve[i]]++;
        }
        
        if(isCloth[1]==-1 && isCloth[2]==1){
            isCloth[1]++;
            isCloth[2]--;
        }
        
        for(int i=2;i<n;i++){
            if(isCloth[i]==-1){
                if(isCloth[i-1]==1){
                    isCloth[i]++;
                    isCloth[i-1]--;
                }
                else if(isCloth[i+1]==1){
                    isCloth[i]++;
                    isCloth[i+1]--;
                }
            }
        }
        
        if(isCloth[n]==-1 && isCloth[n-1]==1){
            isCloth[n]++;
            isCloth[n-1]--;
        }
    
        int cntNoCloth = 0;
        for(int i=1;i<=n;i++){
            if(isCloth[i]==-1){
                cntNoCloth++;
            }
        }
        answer = n-cntNoCloth;
        
        return answer;
    }
}
