package Algorithm;

import java.util.*;

public class P131704 {
    static public void main(String args[]){
        int[] order = {4,3,1,2,5};

        int result= solution(order);
        System.out.println(result);
    }

    static public int solution(int[] order) {
        int answer = 0;
        
        Stack<Integer> st = new Stack<>();
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> truck = new ArrayList<>();
        
        for(int i=1;i<=order[0];i++){
            st.add(i);
        }
        for(int i=order[0]+1;i<=order.length;i++){
            q.add(i);
        }
        
        int idx=0;
        while(true){
            if(!st.isEmpty() && st.peek()==order[idx]){
                int x = st.pop();
                truck.add(x);
                idx++;
            }
            else if(!q.isEmpty() && q.peek()==order[idx]){
                int x = q.poll();
                truck.add(x);
                idx++;
            }
            else{
                if(!q.isEmpty()){
                    int x = q.poll();
                    st.add(x);
                }
                if(q.isEmpty()){
                    break;
                }
            }
        }
        answer = truck.size();
        return answer;
    }
}
