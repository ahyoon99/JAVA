package Algorithm;

import java.util.*;

public class P134239{
    static public void main(String args[]){
        int k = 5;
        int[][] ranges = {{0,0},{0,-1},{2,-3},{3,-3}};

        double[] result = solution(k, ranges);
        for(int i=0;i<result.length;i++){
            System.out.print(result[i]+" ");
        }
        System.out.println();
    }
    
    static public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        
        ArrayList<Double> y = new ArrayList<>();
        double doubleK = (double)k;
        y.add(doubleK);
        
        while(doubleK>1){
            if(doubleK%2==0){
                doubleK/=2;
            }
            else{
                doubleK*=3;
                doubleK++;
            }
            y.add(doubleK);
        }
    
        for(int i=0;i<ranges.length;i++){
            int a = ranges[i][0];
            int b = ranges[i][1];
            b += (y.size()-1);

            if(a>b){
                answer[i]=-1.0;
            }
            else{
                for(int j=a;j<b;j++){
                    answer[i] += (y.get(j)+y.get(j+1))/2;
                }
            }
            
        }
        
        return answer;
    }
}