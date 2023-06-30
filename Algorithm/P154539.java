package Algorithm;

import java.util.*;

public class P154539 {
    static public void main(String args[]){
        int[] numbers = {2,3,3,5};

        int[] result = solution(numbers);
        for(int i=0;i<result.length;i++){
            System.out.print(result[i]+" ");
        }
        System.out.println();
    }
    static public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);
        
        Stack<Integer> st = new Stack<>();
        
        for(int i=0;i<numbers.length;i++){
            while(!st.isEmpty() && numbers[st.peek()]<numbers[i]){
                answer[st.peek()]=numbers[i];
                st.pop();
            }
            st.push(i);
        }
        return answer;
    } 
}
