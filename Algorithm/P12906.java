package Algorithm;
import java.util.*;

public class P12906 {
    static public int[] solution(int []arr) {
        
        ArrayList<Integer> result = new ArrayList<>();
        
        int first = arr[0];
        result.add(first);
        for(int i=1;i<arr.length;i++){
            if(first != arr[i]){
                result.add(arr[i]);
            }
            first = arr[i];
        }
        
        int[] answer = new int[result.size()];
        for(int i=0;i<result.size();i++){
            answer[i]=result.get(i);
        }
        return answer;
    }
    
    static public void main(String args[]){
        int[] arr = {1,1,3,3,0,1,1};
        solution(arr);
    }
}
