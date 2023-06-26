package Algorithm;

import java.util.*;

public class P42584 {
    static public void main(String args[]){
        int[] prices = {1,2,3,2,3};

        int[] result = solution(prices);
        for(int i=0;i<result.length;i++){
            System.out.print(result[i]+" ");
        }
        System.out.println();
    }

    static public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        for(int i=0;i<prices.length;i++){
            int cnt=0;
            for(int j=i+1;j<prices.length;j++){
                cnt++;
                if(prices[i]>prices[j]){
                    break;
                }
            }
            answer[i]=cnt;
        }
        return answer;
    }
}
