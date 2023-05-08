package Algorithm;

import java.util.*;

public class P42885 {
    static public void main(String argsp[]){
        int[] people = {70, 50, 80, 50};
        int limit = 100;

        int result = solution(people, limit);
        System.out.println(result);
    }
    static public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        
        int start=0;
        int end=people.length-1;
        
        for(int i=end;start<=i;i--){
            if(people[i]+people[start]<=limit){
                start++;
            }
            answer++;
        }
        return answer;
    }
}
