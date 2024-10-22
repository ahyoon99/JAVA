package Algorithm;

import java.util.*;

public class P181188 {
    static public void main(String args[]){
        int[][] targets = {{4,5},{4,8},{10,14},{11,13},{5,12},{3,7},{1,4}};
        int result = solution(targets);
        System.out.println(result);
    }

    static public int solution(int[][] targets) {
        int answer = 0;
        
        Arrays.sort(targets, (o1, o2)->{return o1[1]-o2[1];});
        
        int position=0;
        for(int i=0;i<targets.length;i++){
            if(position<=targets[i][0]){
                position = targets[i][1];
                answer++;
            }
        }
        return answer;
    }
}
