package Algorithm;

import java.util.*;

public class P42746 {
    static public void main(String args[]){
        int[] numbers = {3,30,34,5,9};

        String answer = solution(numbers);
        System.out.println(answer);
    }
    static public String solution(int[] numbers) {
        String answer = "";
        
        List<String> list = new ArrayList<>();
        for(int i=0;i<numbers.length;i++){
            list.add(String.valueOf(numbers[i]));
        }
        
        Collections.sort(list, (o1, o2) -> {
            int num1 = Integer.parseInt((o1+o2));
            int num2 = Integer.parseInt((o2+o1));
            return num2 - num1;
        });   
        
        for(int i=0;i<list.size();i++){
            answer+=list.get(i);
        }
        
        if(answer.charAt(0)=='0'){
            answer="0";
        }
        
        return answer;
    }
}
