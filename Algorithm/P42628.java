package Algorithm;

import java.util.*;

public class P42628 {
    static public void main(String args[]){
        String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};

        int[] result = solution(operations);
        System.out.println("["+result[0]+" , "+result[1]+"]");
    }

    static public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0;i<operations.length;i++){
            String[] com = operations[i].split(" ");
            if(com[0].equals("I")){
                int num = Integer.parseInt(com[1]);
                min.add(num);
                max.add(num);
            }
            else if(com[0].equals("D")){
                if(min.size()==0){
                    continue;
                }
                if(com[1].equals("1")){
                    int removeInt = max.poll();
                    min.remove(removeInt);
                }
                else if(com[1].equals("-1")){
                    int removeInt = min.poll();
                    max.remove(removeInt);
                }
            }
        }
        
        if(min.size()==0){
            answer[0]=0;
            answer[1]=0;
        }
        else{
            answer[0]=max.poll();
            answer[1]=min.poll();
        }
        
        return answer;
    }
}
