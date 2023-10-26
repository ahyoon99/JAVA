package Algorithm;

import java.util.*;

public class P150369 {
    static public void main(String args[]){
        int cap = 2;
        int n = 7;
        int[] deliveries = {1,0,2,0,1,0,2};
        int[] pickups = {0,2,0,1,0,2,0};
        
        long result = solution(cap, n, deliveries, pickups);
        System.out.println(result);
    }

    static public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        //트럭 하나로 모든 배달과 수거를 마치고 물류창고까지 돌아올 수 있는 최소 이동 거리를 return 
        
        int d = 0;
        int p = 0;
        for(int i=n-1; i>=0; i--){
            // 배달해야하는 택배와 수거해야 하는 택배 차감하기
            d -= deliveries[i];
            p -= pickups[i];
            
            
            while(d < 0 || p < 0){  // 물류창고에서 집 방향으로 이동하면서 집에 배달 가능한 택배 용량이 초과됨. 이 집을 다시 방문해야함
                d += cap;
                p += cap;
                answer += (i+1)*2;
            }
        }
        return answer;
    }
}
