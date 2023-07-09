package Algorithm;

import java.util.*;

public class P155651 {
    static public void main(String args[]){
        String[][] book_time = {{"15:00", "17:00"}, 
                                {"16:40", "18:20"}, 
                                {"14:20", "15:20"}, 
                                {"14:10", "19:20"}, 
                                {"18:20", "21:20"}};
        int result = solution(book_time);
        System.out.println(result);
    }
    
    static public int solution(String[][] book_time) {
        int answer = 0;
        
        int[] times = new int[1451];
        for(int i=0;i<book_time.length;i++){
            String[] startStr = book_time[i][0].split(":");
            int startInt = Integer.parseInt(startStr[0])*60 + Integer.parseInt(startStr[1]);
            String[] endStr = book_time[i][1].split(":");
            int endInt = Integer.parseInt(endStr[0])*60 + Integer.parseInt(endStr[1])+10;
            for(int j=startInt+1;j<=endInt;j++){
                times[j]++;
            }
        }
        Arrays.sort(times);
        answer = times[1450];
        
        return answer;
    }
}
