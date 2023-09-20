package Algorithm;

import java.util.*;

public class P42884 {
    static class Car{
        int start;
        int end;
        
        Car(int start, int end){
            this.start=start;
            this.end=end;
        }
    }

    static public void main(String args[]){
        int[][] routes = {{-20,-15},{-14,-5},{-18,-13},{-5,-3}};

        int result = solution(routes);
        System.out.println(result);
    }
    
    static public int solution(int[][] routes) {
        int answer = 0;
        
        ArrayList<Car> cars = new ArrayList<>();
        for(int i=0;i<routes.length;i++){
            cars.add(new Car(routes[i][0], routes[i][1]));
        }
        
        Collections.sort(cars, (o1, o2) -> {
            if(o1.end!=o2.end){
                return o1.end-o2.end;
            }
            else{
                return o1.start-o2.start;
            }
        });
        
        int endTime = cars.get(0).end;
        answer++;
        cars.remove(0);
        while(!cars.isEmpty()){
            if(cars.get(0).start>endTime){
                endTime = cars.get(0).end;
                answer++;
            }
            cars.remove(0);
        }
        return answer;
    }
}
