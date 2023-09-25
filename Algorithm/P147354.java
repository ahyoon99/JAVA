package Algorithm;

import java.util.*;

public class P147354 {
    static public void main(String args[]){
        int[][] data = {{2,2,6},{1,5,10},{4,2,9},{3,8,3}};
        int col=2;
        int row_begin=2;
        int row_end=3;

        int result = solution(data, col, row_begin, row_end);
        System.out.println(result);
    }

    static public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        
        Arrays.sort(data, (o1,o2)->{
            if(o1[col-1]==o2[col-1]){
                return o2[0]-o1[0];
            }
            else{
                return o1[col-1]-o2[col-1];
            }
        });
        
        for(int i=row_begin;i<=row_end;i++){
            int S = 0;
            for(int j=0;j<data[i-1].length;j++){
                S+=(data[i-1][j]%i);
            }
            answer=answer^S;
        }
        return answer;
    }
}
