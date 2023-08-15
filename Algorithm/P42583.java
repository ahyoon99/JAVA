package Algorithm;

import java.util.*;

public class P42583 {
    static public void main(String argsp[]){
        // tc1
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7,4,5,6};

        // tc2
        // int bridge_length = 100;
        // int weight = 100;
        // int[] truck_weights = {10};

        // tc2
        // int bridge_length = 100;
        // int weight = 100;
        // int[] truck_weights = {10,10,10,10,10,10,10,10,10,10};

        int result = solution(bridge_length, weight, truck_weights);
        System.out.println(result);
    }
    
    static public int solution(int bridge_length, int weight, int[] truck_weights) {
        int times = 0;
    
        Queue<Integer> bridge = new LinkedList<>();
        
        int bridgeWeights = 0;
        for(int i=0;i<truck_weights.length;i++){
            int truck = truck_weights[i];
            while(true){
                if(bridge.isEmpty()){
                    bridge.add(truck);
                    bridgeWeights += truck;
                    times++;
                    break;
                }
                else if(bridge.size() == bridge_length){
                    bridgeWeights-=bridge.peek();
                    bridge.poll();
                }
                else if(bridge.size() < bridge_length){
                    if(bridgeWeights + truck <= weight){
                        bridge.add(truck);
                        bridgeWeights += truck;
                        times++;
                        break;
                    }
                    else{
                        bridge.add(0);
                        times++;
                    }
                }
            }
        }
        return times+bridge_length;
    }
}
