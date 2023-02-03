package Algorithm;

import java.util.*;

public class P92341 {
    static public int[] solution(int[] fees, String[] records) {
        
        HashMap<String, Integer> parking = new HashMap<>();
        HashMap<String, Integer> totalTime = new HashMap<>();
        
        for(int i=0;i<records.length;i++){
            String[] record = records[i].split(" ");
            String[] timeArr = record[0].split(":");
            int timeToNum = 60*(Integer.parseInt(timeArr[0]))+(Integer.parseInt(timeArr[1]));
            
            if(record[2].equals("IN")){
                parking.put(record[1], timeToNum);
                
            }
            else if(record[2].equals("OUT")){
                int calTime = timeToNum-parking.get(record[1]);
                
                int times = 0;
                if(totalTime.containsKey(record[1])){
                    times = totalTime.get(record[1]);
                }
                totalTime.put(record[1], times+calTime);
                parking.remove(record[1]);
            }
        }
        
        for(String i : parking.keySet()){ // 남아있는 차량은 23:59분에 출차
            int calTime = 1439-parking.get(i);
                
            int times = 0;
            if(totalTime.containsKey(i)){
                times = totalTime.get(i);
            }
            totalTime.put(i, times+calTime);
        }
        
        Map<Integer, Integer> priceMap = new HashMap<>();
        
        for(String carNum : totalTime.keySet()){
            int result = totalTime.get(carNum);
            int price=0;
            if(result>fees[0]){
                price = fees[1] + (int)(Math.ceil((result-fees[0])/(double)fees[2])) *fees[3];
                priceMap.put(Integer.parseInt(carNum), price);
            }else{
                priceMap.put(Integer.parseInt(carNum),fees[1]);
            }
        }
        
        Map<Integer, Integer> priceTreeMap = new TreeMap<>(priceMap);
        int[] answer = new int[priceMap.size()];
        
        int idx=0;
        for(Integer carNum : priceTreeMap.keySet()){
            answer[idx]=priceTreeMap.get(carNum);
            idx++;
        }
        return answer;
    } 
    static public void main(String args[]){
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", 
                            "06:00 0000 IN", 
                            "06:34 0000 OUT", 
                            "07:59 5961 OUT", 
                            "07:59 0148 IN", 
                            "18:59 0000 IN", 
                            "19:09 0148 OUT", 
                            "22:59 5961 IN", 
                            "23:00 5961 OUT"};

        int[] result = solution(fees, records);
        for(int i=0;i<result.length;i++){
            System.out.print(result[i]+" ");
        }
        System.out.println();
    }
}
