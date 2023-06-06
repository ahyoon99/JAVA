package Algorithm;

import java.util.*;

public class P17680 {
    static public void main(String args[]){
        int cacheSize = 3;
        String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};

        int result = solution(cacheSize, cities);
        System.out.println(result);
    }

    static public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        if(cacheSize==0){
            answer = 5*cities.length;
            return answer;
        }
        
        Queue<String> q = new LinkedList<>();
        for(int i=0;i<cities.length;i++){
            String city = cities[i].toLowerCase();
            if(q.contains(city)){
                answer+=1;
                q.remove(city);
                q.add(city);
            }
            else if(q.size()==cacheSize){
                q.poll();
                q.add(city);
                answer+=5;
            }
            else{
                q.add(city);
                answer+=5;
            }
        }
        return answer;
    }
}
