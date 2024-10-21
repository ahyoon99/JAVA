package Algorithm;

import java.util.*;

public class P172927 {
    static int[] picksOrder;
    static int[][] power = {{},{0,1,5,25},{0,1,1,5},{0,1,1,1}};
    static int answer;

    static public void main(String args[]){
        int[] picks = {1,3,2};
        String[] minerals = {"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"};
        int result = solution(picks, minerals);
        System.out.println(result);
    }

    static public int solution(int[] picks, String[] minerals) {
        answer = Integer.MAX_VALUE;

        ArrayList<Integer> picksOrderList = new ArrayList<Integer>();
        for(int i=0;i<picks.length;i++){
            for(int j=0;j<picks[i];j++){
                picksOrderList.add(3-i);
            }
        }
        Collections.sort(picksOrderList);
        
        picksOrder = new int[picksOrderList.size()];
        for(int i=0;i<picksOrderList.size();i++){
            picksOrder[i] = picksOrderList.get(i);
        }
        
        do{
            int total = 0;
            for(int i=0;i<picksOrder.length;i++){
                int pick = picksOrder[i];
                for(int j=0;j<5;j++){
                    int mineral = i*5+j;
                    if(mineral>=minerals.length){
                        break;
                    }
                    if(minerals[mineral].equals("diamond")){
                        total+=power[pick][3];
                    }
                    else if(minerals[mineral].equals("iron")){
                        total+=power[pick][2];
                    }
                    else if(minerals[mineral].equals("stone")){
                        total+=power[pick][1];
                    }
                }
            }
            answer = Math.min(answer, total);
        }
        while(nextPermutation(picksOrder.length));
        
        return answer;
    }
    
    static boolean nextPermutation(int n){
        int i = n-1;
        while(i>0 && picksOrder[i-1]>=picksOrder[i]){
            i--;
        }
        if(i<=0){
            return false;
        }
        
        int j = n-1;
        while(picksOrder[i-1]>=picksOrder[j]){
            j--;
        }
        
        swap(i-1, j);
        
        j=n-1;
        while(i<j){
            swap(i, j);
            i++;
            j--;
        }
        
        return true;
    }
    
    static void swap(int i, int j){
        int temp = picksOrder[i];
        picksOrder[i]=picksOrder[j];
        picksOrder[j]=temp;
    }
}
