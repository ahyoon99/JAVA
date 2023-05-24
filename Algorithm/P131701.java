package Algorithm;

import java.util.*;

public class P131701 {
    static public void main(String args[]){
        int[] elements = {7,9,1,1,4};
        int result = solution(elements);
        System.out.println(result);
    }

    static public int solution(int[] elements) {
        Set<Integer> result = new HashSet<>();
        
        int start=1;
        while(start<=elements.length){
            for(int j=0;j<elements.length;j++){
                int sum=0;
                for(int k=j;k<j+start;k++){
                    sum+=elements[k%elements.length];
                }
                result.add(sum);
            }
            start++;
        }
        return result.size();
    }
}
